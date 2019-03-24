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
public class Pharmacist extends User {

    private String firstName;
    private String lastName;
    private String company;
    private String location;

    /**
     * Default constructor for Pharmacist
     *
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param company
     * @param location
     */
    public Pharmacist(String username, String password, String email, String firstName, String lastName, String company, String location) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.location = location;
    }

    /**
     * Return the pharmacist first name
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the pharmacist first name
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the pharmacist last name
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the pharmacist last name
     *
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the pharmacist company
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Set the pharmacist company
     *
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Return the pharmacist location
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the pharmacist location
     *
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
