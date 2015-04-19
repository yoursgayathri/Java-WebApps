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
<title>Add new customer</title>
</head>
<body>
     <form method="POST" action='customerController' name="frmAddCustomer"> 
         <font>Customer ID :</font>
         <input type="text" name="customer_id" value="<c:out value="${customer.customer_id}" />" />  
         <font>First Name</font> 
        <input type="text" name="first_name" value="<c:out value="${customer.first_name}" />" /> 
        <font>Last name :</font> 
        <input type="text" name="last_name" value="<c:out value="${customer.last_name}" />" />
        <font>DOB :</font>
        <input type="text" name="dob" value="<c:out value="${customer.dob}" />" /> <br /> <br /> 
        <font>Gender :</font>
        <input type="text" name="gender" value="<c:out value="${customer.gender}" />" />
        <font>Address Line1 :</font>
        <input type="text" name="address_line1" value="<c:out value="${customer.address_line1}" />" /> 
        <font>Address Line2:</font>
        <input type="text" name="address_line2" value="<c:out value="${customer.address_line2}" />" /> 
        <font>City :</font>
        <input type="text" name="city" value="<c:out value="${customer.city}" />" /> <br /> <br /> 
        <font>State :</font>
        <input type="text" name="state" value="<c:out value="${customer.state}" />" /> 
        <font>zip :</font>
        <input type="text" name="zip" value="<c:out value="${customer.zip}" />" /> 
        <font>Cell Phone :</font>
        <input type="text" name="cell_phone" value="<c:out value="${customer.cell_phone}" />" /> 
        <font>Home Phone :</font>
        <input type="text" name="home_phone" value="<c:out value="${customer.home_phone}" />" /> <br /> <br /> 
        <font>email :</font>
        <input type="text" name="email" value="<c:out value="${customer.email}" />" />
        <input type="submit" value="Add and proceed to Sale!" />
    </form>
</body>
</html>