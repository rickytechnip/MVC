/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author chris
 */
public class Change {

    private int quarters = 0, dimes = 0, nickels = 0, pennies = 0;
    private double totalChange = 0.00;

    public Change() {

    }

    public Change (double totalChange)
    {
        this.totalChange = totalChange;
    }
    public Change(int quarters, int dimes, int nickels, int pennies, double totalChange) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
        this.totalChange = totalChange;

    }
    
    

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    public double getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(double totalChange) {
        this.totalChange = totalChange;
    }
    
    

    public String toString() {

        String changeString = "Quarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies
                + "\nTotal change: $" + totalChange;

        return changeString;
    }

}
