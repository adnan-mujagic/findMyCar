/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfinder;

import carfinder.cars.Car;
import carfinder.ui.UserInterface;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * @author Paprika
 */
public class CarFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*Scanner reader = new Scanner(System.in);
        System.out.println("Enter license plate:");
        String input = reader.nextLine();
        if(input.matches("[a-z][0-9]{2}-[a-z]-[0-9]{3}")){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }*/
        
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
        
    }
    
}
