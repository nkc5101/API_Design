/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PersistentDataCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author nate
 */
public class PersistentDataController {

    private static PersistentDataController controller;
    private PersistentDataCollection dataCollection;
    private final String filename = "data.txt";
    private static SecretKeySpec secretKey; //allows simpiler implementation of keys for encryption/decryption
    private static byte[] key;

    /**
     * Default constructor for PrescriptionController and displays the
     * prescriptions interface
     */
    private PersistentDataController() {
        readData();
        if (dataCollection == null) {
            dataCollection = new PersistentDataCollection();
            writeData();
            readData();
        }
    }

    public static PersistentDataController getPersistentDataController() {
        if (controller == null) {
            controller = new PersistentDataController();
        }
        return controller;
    }

    public PersistentDataCollection getPersistentDataCollection() {
        return dataCollection;
    }

    private void readData() {
        Gson gson = new Gson();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                dataCollection = gson.fromJson(data, PersistentDataCollection.class);
                
                
            }
            
        } catch (JsonSyntaxException | FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    public void writeData() {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(dataCollection, writer);
            
            writer.close();

        } catch (IOException ex) {
            ex.getMessage();
        }

    }
    
    private static void setKey(String suppliedKey) {
        MessageDigest sha;
        try {
            key = suppliedKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            ex.getMessage();
        }
    }

    //allows the encryption to be done by the controller and not the data classes
    private static String encrypt(String stringToEncrypt, String key) {
        try {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(stringToEncrypt.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException ex) {
            ex.getMessage();
        }
        return null;
    }

    //allows the decryption to be done by the controller and not the data classes
    private static String decrypt(String stringToDecrypt, String key) {
        try {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(stringToDecrypt)));
        } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException | BadPaddingException ex) {
            ex.getMessage();
        }
        return null;
    }
}
