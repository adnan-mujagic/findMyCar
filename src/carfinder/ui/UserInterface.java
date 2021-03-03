/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfinder.ui;

import carfinder.cars.Car;
import carfinder.listeners.AddCarListener;
import carfinder.listeners.ExportCarsListener;
import carfinder.listeners.SearchCar;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Paprika
 */
public class UserInterface implements Runnable{
    private JFrame frame;
    
    
    public void run(){
        frame = new JFrame("Car Finder");
        frame.setPreferredSize(new Dimension(700,400));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            createContents(frame.getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setResizable(true);
        
        frame.pack();
    }
    
    public void createContents(Container container) throws IOException{
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Opel","Astra","k12-b-777","unknown"));
        cars.add(new Car("TestCar","Model","a00-a-000","unknown"));
        
        container.setLayout(new GridLayout(3,2));
        Container topLeft = new Container();
        topLeft.setLayout(new GridLayout(4,1));
        
        
        JTextField make = new JTextField();
        topLeft.add(new JLabel("Car make"));
        topLeft.add(make);
        
        JTextField model = new JTextField();
        topLeft.add(new JLabel("Model:"));
        topLeft.add(model);
        
        JTextField plate = new JTextField();
        topLeft.add(new JLabel("License plate number:"));
        topLeft.add(plate);
        
        JTextField owner = new JTextField();
        topLeft.add(new JLabel("Owner name:"));
        topLeft.add(owner);
        container.add(topLeft);
        
        
        
        //TOP RIGHT
        
        //JUST TRYING SOMETHING OUT 
        JPanel tR = new JPanel();
        tR.setLayout(new GridLayout(5,2));
        JLabel topRight = new JLabel("");
        JLabel trOne = new JLabel("");
        JLabel trTwo = new JLabel("");
        JLabel trThree = new JLabel("");
        JLabel trFour = new JLabel("");
        JLabel notifier = new JLabel("");
        tR.add(notifier);
        tR.add(topRight);
        tR.add(new JLabel(""));
        tR.add(trOne);
        tR.add(new JLabel(""));
        tR.add(trTwo);
        tR.add(new JLabel(""));
        tR.add(trThree);
        tR.add(new JLabel(""));
        tR.add(trFour);
        
        
        
        container.add(tR);
        
        
        //MIDDLE LEFT - empty container
        JButton add = new JButton("Add Car");
        
        
        
        Container middleLeft = new Container();
        middleLeft.setLayout(new GridLayout(4,2));
        middleLeft.add(new JLabel());
        middleLeft.add(add);
        
        
        AddCarListener acl = new AddCarListener(make,model,plate,owner,cars,notifier,topRight,trOne,trTwo,trThree,trFour);
        add.addActionListener(acl);
        
        
        JButton export = new JButton("Export");
        
        ExportCarsListener exp = new ExportCarsListener(cars);
        export.addActionListener(exp);
        middleLeft.add(new JLabel(""));
        middleLeft.add(new JLabel(""));
        middleLeft.add(new JLabel("Export to file: "));
        middleLeft.add(export);
        middleLeft.add(new JLabel(""));
        middleLeft.add(new JLabel(""));
        
        container.add(middleLeft);
        //MIDDLE RIGHT - just empty container
        container.add(new Container());
        //BOTTOM LEFT
        Container bottomLeft = new Container();
        bottomLeft.setLayout(new GridLayout(4,2));
        bottomLeft.add(new JLabel(""));//empty
        bottomLeft.add(new JLabel(""));//empty
        bottomLeft.add(new JLabel(""));//empty
        bottomLeft.add(new JLabel(""));//empty
        bottomLeft.add(new JLabel("Car license plate:"));
        JTextField searchedPlate = new JTextField();
        bottomLeft.add(searchedPlate);
        bottomLeft.add(new JLabel(""));
        
        JButton search = new JButton("Search");
        SearchCar sc = new SearchCar(searchedPlate,notifier,topRight, trOne,trTwo,trThree,trFour,cars);
        search.addActionListener(sc);
        search.setPreferredSize(new Dimension(20,30));
        bottomLeft.add(search);
        container.add(bottomLeft);
        
        
        //BOTTOM RIGHT
        Container bottomRight = new Container();
        container.add(bottomRight);
                
    }
}
