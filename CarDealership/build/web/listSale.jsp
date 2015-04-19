<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link type="text/css"
              href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Add new car</title>
    </head>
    <body style="margin-left: 500px;margin-top: 100px">
         <a href="index.jsp"><img src="http://www.cairnsrsl.com.au/club/images/stories/buttons/homeicon.png" width="50" height="50" alt="home" /></a>
         <br>
         <br>
         
        <form method="POST" action='carController' name="frmAddCar"> 
            <table border="1" cellpadding="20">
                <tbody>
                    <tr>
                        <td>

                            <font> CAR DETAILS </font><br>
                            <font>Car ID :</font>  <c:out value="${car.car_id}" /><br>
                            <font>vin:</font> <c:out value="${car.vin}" /><br>

                            <font>Color :</font> <c:out value="${car.color}" /><br>
                            <font>Category :</font><c:out value="${car.category}" /><br>
                            <font>Model :</font><c:out value="${car.model}" /><br>
                            <font>Model Year :</font><c:out value="${car.model_year}" /><br>
                            <font>Manufacturer :</font><c:out value="${car.manufacturer}" /><br>
                            <font>Mileage :</font><c:out value="${car.mileage}" /> <br><br>


                        </td>
                        <td rowspan="2">

                            <p>Car ID :</p>
                            <input type="text" name="car_id" value="<c:out value="${sales.car_id}" />" /> <br /> 
                            <p>vin:</p> 
                            <input type="text" name="vin" value="<c:out value="${sales.customer_id}" />" /> <br /> 
                            <p>Color :</p> 
                            <input type="text" name="color" value="<c:out value="${sales.date_of_sale}" />" /> <br /> 
                            <p>Category :</p>
                            <input type="text" name="category" value="<c:out value="${sales.sale_price}" />" /> <br /> 
                            <br><br>
                            <input type="submit" value="Submit" />

                        </td>
                    </tr>
                    <tr>
                        <td> <font> CUSTOMER DETAILS </font><br>
                            <font>Name :</font>  <c:out value="${customer.first_name}" />  <c:out value="${customer.last_name}" /><br>
                            <font>DOB :</font> <c:out value="${customer.dob}" /><br>
                            <font>Gender :</font><c:out value="${customer.gender}" /><br>
                            <font>Address :</font><c:out value="${customer.address_line1}" /> <c:out value="${customer.address_line2}" /><c:out value="${customer.city}" /><c:out value="${customer.state}" /><c:out value="${customer.zip}" /><br>
                            <font>Phone :</font><c:out value="${customer.cell_phone}" /><c:out value="${customer.home_phone}" /><br>
                            <font>email :</font><c:out value="${customer.email}" /><br><br>

                            

                        </td><br>



                </tr>
                </tbody>
            </table>



        </form>
    </body>
</html>