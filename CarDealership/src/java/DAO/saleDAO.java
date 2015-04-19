/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Used_Car;
import DBUtility.DbUtil;
import Models.Customer;
import Models.New_Car;
import java.sql.Connection;
import Models.Sale;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gayathri
 */
public class saleDAO {
    
    private Connection connection;

	public saleDAO() {
		connection = DbUtil.getConnection();
	}
           
        
        
    public void addSale(Sale sale) {
		try {
                    
                                       
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into sales(sale_id,customer_id,car_id,date_of_sale,sale_price,loan_id,payment_id) values (?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
                        preparedStatement.setString(1, "sal0000020");
                        preparedStatement.setString(2, sale.getCustomer_id());
                        preparedStatement.setString(3, sale.getCar_id());
			preparedStatement.setDate(4, sale.getDate_of_sale());
			preparedStatement.setFloat(5, sale.getSale_price());
                        preparedStatement.setString(6, sale.getLoan_id());
                        preparedStatement.setString(7,sale.getPayment_id());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    
    public New_Car getPrice(String car_id)
    {
        New_Car new_Car = new New_Car();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from New_Car where car_id=?");
			preparedStatement.setString(1, car_id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				new_Car.setCar_id(rs.getString("car_id"));
                                new_Car.setMarket_price(rs.getFloat("market_price"));
                                new_Car.setMiles(rs.getInt("miles"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
                return new_Car;
    }
    
    
    public Used_Car getAskingPrice(String car_id)
    {
        Used_Car used_Car = new Used_Car();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Used_Car where car_id=?");
			preparedStatement.setString(1, car_id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				used_Car.setCar_id(rs.getString("car_id"));
                                used_Car.setMiles(rs.getInt("miles"));
                                used_Car.setCost_of_refurbish(rs.getFloat("cost_of_refurbish"));
                                used_Car.setAsking_price(rs.getInt("asking_price"));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
                return used_Car;
    }
    
    
    
    
}
