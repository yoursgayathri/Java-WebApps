/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Gayathri
 */
public class Used_Car {
    
   String car_id;
   int miles;
   float cost_of_refurbish; 
   float asking_price; 

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public float getCost_of_refurbish() {
        return cost_of_refurbish;
    }

    public void setCost_of_refurbish(float cost_of_refurbish) {
        this.cost_of_refurbish = cost_of_refurbish;
    }

    public float getAsking_price() {
        return asking_price;
    }

    public void setAsking_price(float asking_price) {
        this.asking_price = asking_price;
    }

    @Override
    public String toString() {
        return "Used_Car{" + "car_id=" + car_id + ", miles=" + miles + ", cost_of_refurbish=" + cost_of_refurbish + ", asking_price=" + asking_price + '}';
    }
    
   
   
   
   
    
}
