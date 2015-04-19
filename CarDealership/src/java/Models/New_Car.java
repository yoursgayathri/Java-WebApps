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
public class New_Car {
    
    
    String car_id;
    int miles;
    float market_price;

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

    public float getMarket_price() {
        return market_price;
    }

    public void setMarket_price(float market_price) {
        this.market_price = market_price;
    }

    @Override
    public String toString() {
        return "New_Car{" + "car_id=" + car_id + ", miles=" + miles + ", market_price=" + market_price + '}';
    }
    
    
    
    
    
}
