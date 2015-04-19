package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Models.Customer;
import DBUtility.DbUtil;

public class customerDAO {

	private Connection connection;

	public customerDAO() {
		connection = DbUtil.getConnection();
	}

	public void addCustomer(Customer customer) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into customer(customer_id,first_name,last_name,dob,gender,address_line1,address_line2,city,state,zip,cell_phone,home_phone,email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
                        preparedStatement.setString(1, "cus0000018");
                        preparedStatement.setString(2, customer.getFirst_name());
                        preparedStatement.setString(3, customer.getLast_name());
			preparedStatement.setDate(4, customer.getDob());
			preparedStatement.setString(5, customer.getGender());
                       
                        preparedStatement.setString(6,customer.getAddress_line1());
			preparedStatement.setString(7,customer.getAddress_line2());
                        preparedStatement.setString(8,customer.getCity());
                        preparedStatement.setString(9,customer.getState());
                        preparedStatement.setInt(10,customer.getZip());
                        preparedStatement.setString(11,customer.getCell_phone());
                        preparedStatement.setString(12,customer.getHome_phone());
                        preparedStatement.setString(13,customer.getEmail());
                      
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(String customerId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from customer where customer_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, customerId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCustomer(Customer customer) {
		try {
                    System.out.println("inside update");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update customer set first_name=?,last_name=?,dob=?,gender=?,address_line1=?,address_line2=?,city=?,state=?,zip=?,cell_phone=?,home_phone=?,email=?" +
							"where customer_id=?");
			// Parameters start with 1
			 preparedStatement.setString(1, customer.getFirst_name());
                        preparedStatement.setString(2, customer.getLast_name());
			preparedStatement.setDate(3, customer.getDob());
			preparedStatement.setString(4, customer.getGender());
                       
                        preparedStatement.setString(5,customer.getAddress_line1());
			preparedStatement.setString(6,customer.getAddress_line2());
                        preparedStatement.setString(7,customer.getCity());
                        preparedStatement.setString(8,customer.getState());
                        preparedStatement.setInt(9,customer.getZip());
                        preparedStatement.setString(10,customer.getCell_phone());
                        preparedStatement.setString(11,customer.getHome_phone());
                        preparedStatement.setString(12,customer.getEmail());
                        preparedStatement.setString(13,customer.getCustomer_id());
                        preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
                    connection = DbUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer");
			while (rs.next()) {
                            System.out.println("get all customers");
				Customer customer = new Customer();
				customer.setCustomer_id(rs.getString("customer_id"));
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setDob(rs.getDate("dob"));
				customer.setGender(rs.getString("gender"));
                                customer.setAddress_line1(rs.getString("address_line1"));
                                customer.setAddress_line2(rs.getString("address_line2"));
                                customer.setCity(rs.getString("city"));
                                customer.setState(rs.getString("state"));
				customer.setZip(rs.getInt("zip"));
				customer.setCell_phone(rs.getString("cell_phone"));
                                customer.setHome_phone(rs.getString("home_phone"));
                                customer.setEmail(rs.getString("email"));
                                customers.add(customer);
                                System.out.println("get all customers"+customers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}
	
	public Customer getCustomerById(String customerId) {
		Customer customer = new Customer();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from customer where customer_id=?");
			preparedStatement.setString(1, customerId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				customer.setCustomer_id(rs.getString("customer_id"));
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setDob(rs.getDate("dob"));
				customer.setGender(rs.getString("gender"));
                                customer.setAddress_line1(rs.getString("address_line1"));
                                customer.setAddress_line2(rs.getString("address_line2"));
                                customer.setCity(rs.getString("city"));
                                customer.setState(rs.getString("state"));
				customer.setZip(rs.getInt("zip"));
				customer.setCell_phone(rs.getString("cell_phone"));
                                customer.setHome_phone(rs.getString("home_phone"));
                                customer.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}
        
        
        public List<Customer> searchCustomer(Customer customerObj) {
		List<Customer> customers = new ArrayList<Customer>();
                System.out.println(customerObj.getFirst_name()+"address is"+customerObj.getAddress_line1()+customerObj.getCustomer_id()+customerObj.getDob()+customerObj.getZip());
		try {
                    int flag=0;
                    
                    String query="select * from customer where ";
                    if(!customerObj.getCustomer_id().toString().equals(""))
                        {
                            System.out.println("1");
                            if (flag==1){query=query.concat(" and "); }
                            query=query.concat("customer_id='"+customerObj.getCustomer_id()+"'");
                            flag=1;
                        }
                       if(!customerObj.getFirst_name().toString().equals(""))
                        {
                            System.out.println("2");
                            if (flag==1){query=query.concat(" and "); }
                            query=query.concat("first_name='"+customerObj.getFirst_name()+"'");
                            flag=1;
                        }
                        if(!customerObj.getLast_name().toString().equals(""))
                        {
                            System.out.println("3");
                            if (flag==1){query=query.concat(" and "); }
                            query=query.concat("last_name='"+customerObj.getLast_name()+"'");
                            flag=1;
                        }
                        if(customerObj.getDob()!=null)
                        {
                            System.out.println("33");
                            if (flag==1){query=query.concat(" and "); }
                            query=query.concat("dob='"+customerObj.getDob()+"'");
                            flag=1;
                        }
                        if(!customerObj.getGender().toString().equals(""))
                        {
                            System.out.println("4");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("gender='"+customerObj.getGender()+"'");
                            flag=1;
                        }
                      if(!customerObj.getAddress_line1().toString().equals(""))
                        {
                            System.out.println("5");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("address_line1='"+customerObj.getAddress_line1()+"'");
                            flag=1;
                        }
                      
                      if(!customerObj.getAddress_line2().toString().equals(""))
                        {
                            System.out.println("6");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("address_line2='"+customerObj.getAddress_line2()+"'");
                            flag=1;
                        }
                      
                      if(!customerObj.getCity().toString().equals(""))
                        {
                            System.out.println("7");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("city='"+customerObj.getCity()+"'");
                            flag=1;
                        }
                      if(!customerObj.getState().toString().equals(""))
                        {
                            System.out.println("8");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("state='"+customerObj.getState()+"'");
                            flag=1;
                        }
                      if(customerObj.getZip()!=0)
                        {
                            System.out.println("9");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("zip='"+customerObj.getZip()+"'");
                            flag=1;
                        }
                      if(!customerObj.getHome_phone().toString().equals(""))
                        {
                            System.out.println("10");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("home_phone='"+customerObj.getHome_phone()+"'");
                            flag=1;
                        }
                      if(!customerObj.getCell_phone().toString().equals(""))
                        {
                            System.out.println("11");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("cell_phone='"+customerObj.getCell_phone()+"'");
                            flag=1;
                        }
                      if(!customerObj.getEmail().toString().equals(""))
                        {
                            System.out.println("12");
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("email='"+customerObj.getEmail()+"'");
                            flag=1;
                        }
                        if(customerObj.getCustomer_id().toString().equals("") && customerObj.getFirst_name().toString().equals("") && customerObj.getLast_name().toString().equals("") && customerObj.getDob()==null && customerObj.getGender().toString().equals("") && customerObj.getAddress_line1().toString().equals("") && customerObj.getAddress_line2().toString().equals("") && customerObj.getCity().toString().equals("") && customerObj.getState().toString().equals("") && customerObj.getZip()==0 && customerObj.getCell_phone().toString().equals("") && customerObj.getHome_phone().toString().equals("") && customerObj.getEmail().toString().equals(""))
                         {
                             System.out.println("13");
                            query="select * from customer";
                        }
                        System.out.println("in dao method"+query);
                        PreparedStatement preparedStatement = connection.
					prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(rs.getString("customer_id"));
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setDob(rs.getDate("dob"));
				customer.setGender(rs.getString("gender"));
                                customer.setAddress_line1(rs.getString("address_line1"));
                                customer.setAddress_line2(rs.getString("address_line2"));
                                customer.setCity(rs.getString("city"));
                                customer.setState(rs.getString("state"));
				customer.setZip(rs.getInt("zip"));
				customer.setCell_phone(rs.getString("cell_phone"));
                                customer.setHome_phone(rs.getString("home_phone"));
                                customer.setEmail(rs.getString("email"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}
        
        
}
