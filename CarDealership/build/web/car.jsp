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
<body>
     <form method="POST" action='carController' name="frmAddCar"> 
         <p>Car ID :</p>
         <input type="text" name="car_id" value="<c:out value="${car.car_id}" />" /> <br /> 
         <p>vin:</p> 
        <input type="text" name="vin" value="<c:out value="${car.vin}" />" /> <br /> 
        <p>Color :</p> 
        <input type="text" name="color" value="<c:out value="${car.color}" />" /> <br /> 
        <p>Category :</p>
        <input type="text" name="category" value="<c:out value="${car.category}" />" /> <br /> 
        <p>Model :</p>
        <input type="text" name="model" value="<c:out value="${car.model}" />" /> <br /> 
        <p>Model Year :</p>
        <input type="text" name="model_year" value="<c:out value="${car.model_year}" />" /> <br /> 
        <p>Manufacturer :</p>
        <input type="text" name="manufacturer" value="<c:out value="${car.manufacturer}" />" /> <br /> 
        <p>Mileage :</p>
        <input type="text" name="mileage" value="<c:out value="${car.mileage}" />" /> <br /> 
        
        <input type="submit" value="Submit" />
    </form>
</body>
</html>