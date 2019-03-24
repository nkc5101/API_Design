/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nate
 */
public class User {

    private String username;
    private String password;
    private String email;

    /**
     * Default constructor for User
     *
     * @param username
     * @param password
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Return the user's username
     *
     * @return the username the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for a User
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Return the user's password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * \
     * Return the user's email
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
