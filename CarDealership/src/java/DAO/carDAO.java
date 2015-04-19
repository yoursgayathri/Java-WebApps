package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Models.Car;
import DBUtility.DbUtil;
import static jdk.nashorn.internal.objects.NativeMath.round;

public class carDAO {

	private Connection connection;

	public carDAO() {
		connection = DbUtil.getConnection();
	}

	public void addCar(Car car) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into cars(car_id,vin,color,category,model,model_year,manufacturer,mileage) values (?, ?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
                        preparedStatement.setString(1, "car0000018");
                        preparedStatement.setString(2, car.getVin());
                        preparedStatement.setString(3, car.getColor());
			preparedStatement.setString(4, car.getCategory());
			preparedStatement.setString(5, car.getModel());
                        preparedStatement.setInt(6, car.getModel_year());
                        preparedStatement.setString(7,car.getManufacturer());
			preparedStatement.setFloat(8,car.getMileage());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCar(String carId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cars where car_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, carId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCar(Car car) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update cars set vin=?, color=?, category=?, model=?, model_year=?, manufacturer=?, mileage=?" +
							"where car_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, car.getVin());
                        preparedStatement.setString(2, car.getColor());
			preparedStatement.setString(3, car.getCategory());
			preparedStatement.setString(4, car.getModel());
                        preparedStatement.setInt(5, car.getModel_year());
                        preparedStatement.setString(6,car.getManufacturer());
			preparedStatement.setFloat(7,car.getMileage());
                        preparedStatement.setString(8, car.getCar_id());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<Car>();
		try {
                    connection = DbUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cars");
			while (rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getString("car_id"));
				car.setVin(rs.getString("vin"));
				car.setColor(rs.getString("color"));
				car.setCategory(rs.getString("category"));
				car.setModel(rs.getString("model"));
                                car.setModel_year(rs.getInt("model_year"));
                                car.setManufacturer(rs.getString("manufacturer"));
                                car.setMileage(rs.getFloat("mileage"));
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cars;
	}
	
	public Car getCarById(String carId) {
		Car car = new Car();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from cars where car_id=?");
			preparedStatement.setString(1, carId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				car.setCar_id(rs.getString("car_id"));
				car.setVin(rs.getString("vin"));
				car.setColor(rs.getString("color"));
				car.setCategory(rs.getString("category"));
				car.setModel(rs.getString("model"));
                                car.setModel_year(rs.getInt("model_year"));
                                car.setManufacturer(rs.getString("manufacturer"));
                                car.setMileage(rs.getFloat("mileage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;
	}
        
        
        public List<Car> searchCar(Car carObj) {
		List<Car> cars = new ArrayList<Car>();
		try {
                    int flag=0;
                    System.out.println(carObj.getCategory()+"in dao method"+carObj.getColor());
                    String query="select * from cars where ";
                       if(carObj.getCategory()!=null)
                        {
                            if (flag==1){query=query.concat(" and "); }
                            query=query.concat("category='"+carObj.getCategory()+"'");
                            flag=1;
                        }
                        if(!carObj.getColor().toString().equals(""))
                        {
                            
                            if (flag==1){query=query.concat(" and "); }
                            query=query.concat("color='"+carObj.getColor()+"'");
                            flag=1;
                        }
                        if(!carObj.getManufacturer().toString().equals(""))
                        {
                            if (flag==1){query=query.concat(" and "); }
                            query=query.concat("manufacturer='"+carObj.getManufacturer()+"'");
                            flag=1;
                        }
                        if(!carObj.getModel().toString().equals(""))
                        {
                             if (flag==1){query=query.concat(" and "); }
                            query=query.concat("model='"+carObj.getModel()+"'");
                            flag=1;
                        }
                        if(carObj.getModel_year()!=0)
                        {
                            query=query.concat("model_year="+carObj.getModel_year());
                        }
                         if(carObj.getMileage()!=0)
                        {
                            query=query.concat("mileage="+carObj.getMileage());
                            
                        }
                        if(carObj.getCategory()==null && carObj.getColor().toString().equals("") && carObj.getManufacturer().toString().equals("")&& carObj.getModel().toString().equals("") && carObj.getModel_year()==0 && carObj.getMileage()==0)
                         {
                            query="select * from cars";
                        }
                        System.out.println("in dao method"+query);
                        PreparedStatement preparedStatement = connection.
					prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getString("car_id"));
				car.setVin(rs.getString("vin"));
				car.setColor(rs.getString("color"));
				car.setCategory(rs.getString("category"));
				car.setModel(rs.getString("model"));
                                car.setModel_year(rs.getInt("model_year"));
                                car.setManufacturer(rs.getString("manufacturer"));
                                car.setMileage(rs.getFloat("mileage"));
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cars;
	}
        
        
}
