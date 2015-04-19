<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Cars</title>
</head>
<body style="margin-left:500px;margin-top: 100px">
     <a href="index.jsp"><img src="http://www.cairnsrsl.com.au/club/images/stories/buttons/homeicon.png" width="50" height="50" alt="home" /></a>
     <br><br>
     
    <jsp:include page="searchCar.jsp"></jsp:include> <br>
    
    
      
    
    
    <table border=1>
        <thead>
            <tr>
                <th>Car Id</th>
                <th>vin</th>
                <th>color</th>
                <th>category</th>
                <th>model</th>
                <th>model_year</th>
                <th>manufacturer</th>
                <th>mileage</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td><c:out value="${car.car_id}" /></td>
                    <td><c:out value="${car.vin}" /></td>
                    <td><c:out value="${car.color}" /></td>
                    <td><c:out value="${car.category}" /></td>
                    <td><c:out value="${car.model}" /></td>
                    <td><c:out value="${car.model_year}" /></td>
                    <td><c:out value="${car.manufacturer}" /></td>
                    <td><c:out value="${car.mileage}" /></td>
                    <td><a href="carController?action=edit&car_id=<c:out value="${car.car_id}"/>">Update</a></td>
                    <td><a href="carController?action=delete&car_id=<c:out value="${car.car_id}"/>">Delete</a></td>
                    <td><a href="carSaleController?action=customer&car_id=<c:out value="${car.car_id}"/>">Make a Sale!</a></td> 
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="carController?action=insert">Add Car</a></p>
</body>
</html>