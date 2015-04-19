<%-- 
    Document   : searchCar
    Created on : Apr 10, 2015, 3:51:12 PM
    Author     : Gayathri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin-left:500px; margin-top:100px;">
        
        
       
        <table border="1" cellpadding="10" >
            <thead>
                <tr>
                    <th>
                        
                         <p><a href="customerController?action=listCustomer" >View Customers</a></p> 
        
        <p><a href="customer.jsp" >Add Customer</a></p>    
                        
                        
                    </th>
                    <th>
                        
                         <br>
        <form method="GET" action='carSearchController' name="searchForm"> 
             <h3>Look for a Car</h3>
        <font>Category :</font>
        
        <font>OLD</font><input type="radio" name="category" value="old"/>
        <font>NEW</font><input type="radio" name="category" value="new" />
        <br>
        <br>
        
         <font>vin:</font> 
        <input type="text" name="vin"  /> 
        <font>Color :</font> 
        <input type="text" name="color"  />  
        <font>Mileage :</font>
        <input type="text" name="mileage" value="0.0"/> 
        <br>
        <br>
        <font>Model :</font>
        <input type="text" name="model" /> 
        <font>Model Year :</font>
        <input type="text" name="model_year"  />  
        <font>Manufacturer :</font>
        <input type="text" name="manufacturer" /><br><br>
        <input type="submit" value="Search" formaction="carSearchController" />
            </form>
                
                        
                        
                    </th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

       
       
    
    </body>
</html>
