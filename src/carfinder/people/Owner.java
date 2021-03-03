/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carfinder.people;

import java.util.Random;

/**
 *
 * @author Paprika
 */
public class Owner {
    private String name;
    private int age;
    private Random rd = new Random();
    public Owner(String name){
        this.name=name;
        this.age=rd.nextInt(23-18)+18;
    }
    
    public String toString(){
        return this.name+", "+this.age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    
    
}
