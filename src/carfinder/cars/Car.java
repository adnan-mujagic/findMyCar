/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfinder.cars;

import carfinder.people.Owner;
import java.util.Random;

/**
 *
 * @author Paprika
 */
public class Car {
    private String[] colors = {"Blue","Red","White","Brown","Orange","Green"};
    private String[] states = {"Factory New","Decent","Old","Unsafe"};
    private String make;
    private String model;
    private String license;
    private String color;
    private String state;
    private Owner owner;
    
    private Random rand = new Random();
    
    public Car(String make, String model, String licensePlate, String ownerName){
        state=this.states[rand.nextInt(states.length)];
        color=this.colors[rand.nextInt(colors.length)];
        this.make=make;
        this.model=model;
        this.license=licensePlate.toUpperCase();
        this.owner=new Owner(ownerName);
    }
    
    public String toString(){
        String display ="Make: "+this.make+"\n"
                + "Model: "+this.model+"\n"
                + "Color: "+this.color+"\n"
                + "State: "+this.state+"\n"
                + "License: "+this.license+"\n"
                + "Owner: "+this.owner.toString()+"\n";
        return display;
        
                
        
    }

    public String getLicense() {
        return license.toLowerCase();
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getState() {
        return state;
    }

    public Owner getOwner() {
        return owner;
    }
    
    
    
    
    
    
}
