/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfinder.listeners;

import carfinder.cars.Car;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Paprika
 */
public class SearchCar implements ActionListener{
    private JTextField lp;
    private JLabel notifier;
    private JLabel topRight;
    private JLabel trOne;
    private JLabel trTwo;
    private JLabel trThree;
    private JLabel trFour;
    
    
    
    private ArrayList<Car> cars;
    public SearchCar(JTextField licensePlate,JLabel notifier, JLabel topRight, JLabel trOne, JLabel trTwo, JLabel trThree, JLabel trFour, ArrayList<Car> cars){
        this.lp=licensePlate;
        this.topRight=topRight;
        this.cars=cars;
        this.notifier=notifier;
        this.trOne=trOne;
        this.trTwo=trTwo;
        this.trThree=trThree;
        this.trFour=trFour;
    }
    
    public void actionPerformed(ActionEvent ae){
        reset();
        String input = lp.getText();
        searchCar(input);
        lp.setText("");
    }
    
    public void searchCar(String input){
        HashMap<String, Car> licenses = new HashMap<String, Car>();
        for(Car c : cars){
            licenses.put(c.getLicense(), c);
        }
        if(licenses.containsKey(input)){
            notifier.setText("Car found successfully.");
            topRight.setText("Make: "+ licenses.get(input).getMake());
            trOne.setText("Model: "+licenses.get(input).getModel());
            trTwo.setText("Color: "+licenses.get(input).getColor());
            trThree.setText("License: "+licenses.get(input).getLicense());
            trFour.setText("Owner: "+licenses.get(input).getOwner().toString());
        }
        else{
            notifier.setText("No car matches your license number.");
        }
        
    }
    
    public void reset(){
        notifier.setText("");
        topRight.setText("");
        trOne.setText("");
        trTwo.setText("");
        trThree.setText("");
        trFour.setText("");
    }
    
    
}
