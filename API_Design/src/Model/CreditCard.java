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
public class CreditCard {

    private String creditCard;
    private String ccv;
    private String name;

    public CreditCard(String creditCard, String ccv, String name) {
        this.ccv = ccv;
        this.creditCard = creditCard;
        this.name = name;
    }

    /**
     * @return the creditCard
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * @return the ccv
     */
    public String getCcv() {
        return ccv;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
