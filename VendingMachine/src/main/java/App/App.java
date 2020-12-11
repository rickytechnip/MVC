/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;
import View.View;
import ServiceLayer.ServiceLayerImplementation;
import Controller.Controller;

/**
 *
 * @author rickytechnip
 */
public class App {
    public static void main(String [] args){
        View appView = new View();
        ServiceLayerImplementation appService = new ServiceLayerImplementation();
        Controller appController = new Controller(appService, appView);
        appController.run();
    }
    
}
