/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfinder.listeners;

import carfinder.cars.Car;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Paprika
 */
public class AddCarListener implements ActionListener{
    private JTextField make;
    private JTextField model;
    private JTextField license;
    private JTextField owner;
    private ArrayList<Car> cars;
    private JLabel notifier;
    private JLabel topRight;
    private JLabel trOne;
    private JLabel trTwo;
    private JLabel trThree;
    private JLabel trFour;
    public AddCarListener(JTextField make, JTextField model, JTextField license, JTextField owner, ArrayList<Car> cars,JLabel notifier, JLabel topRight, JLabel trOne, JLabel trTwo, JLabel trThree, JLabel trFour){
        this.make=make;
        this.license=license;
        this.model=model;
        this.owner=owner;
        this.cars=cars;
        this.topRight=topRight;
        this.trOne=trOne;
        this.trTwo=trTwo;
        this.trThree=trThree;
        this.trFour=trFour;
        this.notifier=notifier;
        
    }
    
    public void actionPerformed(ActionEvent ae){
        reset();
        if(license.getText().matches("[a-z][0-9]{2}-[a-z]-[0-9]{3}")){
            Car car = new Car(make.getText(),model.getText(),license.getText(), owner.getText());
            this.cars.add(car);
            notifier.setText("Car added succesfully!");
            topRight.setText("Make: "+ car.getMake());
            trOne.setText("Model: "+car.getModel());
            trTwo.setText("Color: "+car.getColor());
            trThree.setText("License: "+car.getLicense());
            trFour.setText("Owner: "+car.getOwner().toString());
            
            
            make.setText("");
            model.setText("");
            license.setText("");
            owner.setText("");
        
        }
        else{
            notifier.setText("Oops, bad license plate. Correct format: a00-k-123");
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
