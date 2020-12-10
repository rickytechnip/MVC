/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ServiceLayer.ServiceLayerImplementation;
import View.View;
import java.util.*;
import DTO.Item;


/**
 *
 * @author rickytechnip
 */
public class Controller {
    
    private ServiceLayerImplementation serviceLayer;
    private View view;
    private Change change;
    
    private int customItemId;
    private String customItemName;
    private int customItemNumber;
    
    public Controller(ServiceLayerImplementation inputServiceLayer, View inputView){
        serviceLayer = inputServiceLayer;
        view = inputView;
        change = new Change();
    }
    
    public List<Item> getInventory(){
        return serviceLayer.getAllItems();
    }
    
    public boolean isAvailable(int itemId, int itemAmount){
        List<Item> currentInventory = serviceLayer.getAllItems();
        
        for(Item item: currentInventory){
            if(item.getId() == itemId)
                return item.getStock() >= itemAmount;
        }
        return false;
   }
    
    public void run(){
        do{
            List<Integer> changeList = null;
            view.showItems(getInventory());
            view.askItems();
            int itemId = getInputInt();
            
            Item userItem = serviceLayer.getItem(itemId);
            
            view.askNumber();
            int itemAmount = getInputInt();
            
            if(!isAvailable(itemId, itemAmount)){
                view.outOfStock();
                view.askAgain();
                int again = getInputInt();
                if(again == 1)
                    continue;
                else{
                    view.bye();
                    break;
                }
            }
            view.askMoney();
            int userCent = (int) Math.floor(getInputDouble() * 100);
            int cost = (int) Math.floor(calculatePrice(itemId, itemAmount) * 100);
            
            if(cost > userCent){
                view.insufficientMoney();
                view.moneyReturned();
                view.bye();
                continue;
            }
            
            changeList = change.makeChange(userCent, cost);
            
            processTransaction(itemId, itemAmount);
            view.printOutCome(itemId, userItem.getName(), itemAmount, changeList);
            
            view.askAgain();
            int again = getInputInt();
            if(again == 1)
                continue;
            else
                view.bye();
        }while(true);
    }
    
    public void processTransaction(int itemId, int itemAmount){
        Item currentItem = serviceLayer.getItem(itemId);
        Item updatedItem = new Item(currentItem.getName(), currentItem.getCost(), currentItem.getId(), currentItem.getStock() - itemAmount);
        serviceLayer.updateItem(itemId, updatedItem);
    }
    
    public double calculatePrice(int itemId, int itemAmount){
        Item currentItem = serviceLayer.getItem(itemId);
        return currentItem.getCost() * itemAmount;
    }
    
    public int getInputInt(){
        Scanner input = new Scanner(System.in);
        int userInputInt = input.nextInt();
        return userInputInt;
    }
    
    public double getInputDouble(){
        Scanner input = new Scanner(System.in);
        int userInputInt;
        double userInputDouble = input.nextDouble();
        return userInputDouble;
    }
}
