/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.util.*;
import DTO.Item;

/**
 *
 * @author rickytechnip
 */
public class View {
    
    private String[] coinName = {"quarter", "dime", "nickel", "penny"};
    public View(){
        System.out.println("Welome to Veding Machine");
    }
    
    public void showItems(List<Item> inputItemList){
        for(Item item : inputItemList){
            System.out.println("Currently we have " + 
                    item.getId() + " " + item.getName() + 
                    item.getCost() + " " + item.getStock());
        }
    }
    
    public void askItems(){
        System.out.println("what kind of item do you want? please input item id:");
    }
    
    public void askNumber(){
        System.out.println("how many do you want: ");
    }
    
    public void showInputMoney(int inputCent, int leftOverAmount){
        System.out.println("Currently you input " + inputCent/100 + " dollars" + inputCent%100 + " Cent");
        System.out.println("you need " + leftOverAmount/100 + " dollars" + leftOverAmount%100 + " Cent more.");
    }
    
    public void moreMoneyOrRestartOrQuit(){
        System.out.println("Would you input more money or restart? 1 for more money, 0 for restart, 2 for quit.");
    }
    
    public void askMoney(){
        System.out.println("Please input you money amount:");
    }
    
    public void outOfStock(){
        System.out.println("Sorry, the Item you choose is out of stock");
    }
    
    public void moneyReturned(){
        System.out.println("Your money returned.");
    }
    
    public void printOutCome(int itemId, String itemName, int itemNumber, List<Integer> chargeList){
        System.out.println("Here is you outcome list:");
        System.out.println(itemId + " " + itemName  + " " + itemNumber);
        System.out.println("your have charges below: ");
        for(int i = 0; i < chargeList.size(); i++){
            if(chargeList.get(i) != 0)
                System.out.println(chargeList.get(i) + " " + coinName[i]);
        }
    }
    
    public void insufficientMoney(){
        System.out.println("Sorry, the money you give is not sufficient! pleae input more!");
    }
    
    public void askAgain(){
        System.out.println("Do you want to continue? 1 for YES, 0 for No");
    }
    
    public void bye(){
        System.out.println("Thanks for shopping!");
    }
}
