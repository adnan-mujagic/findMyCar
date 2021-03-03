/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfinder.listeners;

import carfinder.cars.Car;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paprika
 */
public class ExportCarsListener implements ActionListener{
    private FileWriter writer;
    private ArrayList<Car> cars;
    public ExportCarsListener(ArrayList<Car> cars) throws IOException{
        this.writer=new FileWriter("src/carfinder/reports/carlist.txt");
        this.cars=cars;
        
    }
    
    public void actionPerformed(ActionEvent aevent){
        try {
            exportCars();
        } catch (IOException ex) {
            Logger.getLogger(ExportCarsListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exportCars() throws IOException{
        writer.write("Cars found: "+cars.size()+"\nFound cars: \n\n");
        int i=1;
        for(Car car : cars){
            writer.write(i+"\n"+car.toString()+"\n\n");
            i++;
        }
        writer.write("--End--");
        writer.close();
    }
    
}
