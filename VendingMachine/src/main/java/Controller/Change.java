/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java. util. *;

/**
 *
 * @author rickytechnip
 */
public class Change {
    
    private static final int penny = 1;
    private static final int nickel = 5;
    private static final int dime = 10;
    private static final int quarter = 25;
    private List<Integer> value_list = null;
    
    
    public Change(){
        value_list.add(quarter);
        value_list.add(dime);
        value_list.add(nickel);
        value_list.add(penny);
    }
    
    public List<Integer> makeChange(int userInputCent, int priceAmountCent){
        int chargeAmountCent = priceAmountCent - userInputCent;
        
        List<Integer> chargeList = new ArrayList<>();
        
        for(int i = 0; i < 4; i++){
            int pisces = chargeAmountCent/value_list.get(i);
            int left = chargeAmountCent%value_list.get(i);
            chargeList.add(pisces);
            chargeAmountCent = left;
        }
        return chargeList;
    }
    
}
