<%-- 
    Document   : searchCustomer
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
    <body>
       
        
        <br>
        <form method="GET" action='customerSearchController' name="searchForm"> 
             <h3>Look for a Customer</h3>
             <br>
        
         <font>Customer ID</font> 
        <input type="text" name="customer_id"  /> 
        <font>First Name</font> 
        <input type="text" name="first_name"  />  
        <font>Last Name :</font>
        <input type="text" name="last_name"/> 
        <br>
        <br>
        
        <input type="hidden" name="address_line1" /> 
        <input type="hidden" name="address_line2" /> 
        <input type="hidden" name="gender" /> 
        <input type="hidden" name="dob" /> 
        <font>City :</font>
        <input type="text" name="city" /> 
        <font>State :</font>
        <input type="text" name="state"  />  
        <font>zip :</font>
        <input type="text" name="zip" /><br><br>
         <font>cell number:</font>
        <input type="text" name="cell_phone" />
         <font>Phone number:</font>
        <input type="text" name="home_phone" /> <font>email :</font>
        <input type="text" name="email" /> 
        <br><br>
        
        
        <input type="submit" value="Find Customer!" formaction="customerSearchController" />
        
        
    </form>
    </body>
</html>
