/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtility;

/**
 *
 * @author Gayathri
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil
{
private static Connection connection = null;
public static Connection getConnection() {
if (connection != null)
return connection;
else {
try {
//Properties prop = new Properties();
//InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
//prop.load(inputStream);
System.out.println("entered");

Class.forName("com.mysql.jdbc.Driver");
String driver ="com.mysql.jdbc.Driver";
String url ="jdbc:mysql://localhost:3306/Cardealership";
//String web_url="jdbc:mysql://mysql161134-MotoDealers.jelastic.servint.net/cardealership"; 
String user = "root";
String password = "alohamora";
//String web_password="P8RJu6hTfh";
System.out.println("entered");

System.out.println("entered");
connection = DriverManager.getConnection(url, user, password);
 }
catch (ClassNotFoundException e) {
System.out.println("zsdasf");    
e.printStackTrace();
 }
catch (SQLException e) {
e.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
} 
return connection;
}
}
}
