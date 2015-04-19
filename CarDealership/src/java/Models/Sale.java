/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;


/**
 *
 * @author Gayathri
 */
public class Sale {
    
    
String sale_id; 
String customer_id;
String car_id;
Date date_of_sale;
float sale_price;
String loan_id;
String payment_id;
            

    public String getSale_id() {
        return sale_id;
    }

    

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public Date getDate_of_sale() {
        return date_of_sale;
    }

    public void setDate_of_sale(Date date_of_sale) {
        this.date_of_sale = date_of_sale;
    }

    public float getSale_price() {
        return sale_price;
    }

    public void setSale_price(float sale_price) {
        this.sale_price = sale_price;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }
    
    @Override
    public String toString() {
        return "Sale{" + "sale_id=" + sale_id + ", customer_id=" + customer_id + ", car_id=" + car_id + ", date_of_sale=" + date_of_sale + ", sale_price=" + sale_price + ", loan_id=" + loan_id + ", payment_id=" + payment_id + '}';
    }
        
    
    
    
}
