/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class InsuranceCompany extends User {

    private String name;
    private String address;
    private ArrayList<Patient> clientList;

    /**
     * Default constructor for Insurance Company
     *
     * @param username
     * @param name
     * @param address
     */
    public InsuranceCompany(String username, String password, String email, String name, String address) {
        super(username, password, email);
        this.name = name;
        this.address = address;
        this.clientList = new ArrayList<>();
    }

    /**
     * Get the company's name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the company's name
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the company's address
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the company's address
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Return the client list
     *
     * @return the clientList
     */
    public ArrayList<Patient> getClientList() {
        return clientList;
    }

    /**
     * Add a client to the Patient list
     *
     * @param patient
     */
    public void addClient(Patient patient) {

    }
}
