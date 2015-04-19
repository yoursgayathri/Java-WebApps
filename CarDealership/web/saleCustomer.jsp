<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Cars</title>
</head>
<body>
     <a href="index.jsp"><img src="http://www.cairnsrsl.com.au/club/images/stories/buttons/homeicon.png" width="50" height="50" alt="home" /></a>
     <br>
     <br>
     
     <jsp:include page="lookForCustomer.jsp" ></jsp:include> <br>
    
    <table border=1>
        <thead>
            <tr>
                <th>Select</th>
                <th>Customer Id</th>
                <th>Name</th>
                <th>DOB</th>
                <th>gender</th>
                <th>Address</th>
                <th>Phone number</th>
                <th>email</th>
            
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="customers">
                <tr>
                    <td><a href="carSaleController?action=sale&customer_id=<c:out value="${customers.customer_id}"/>">select</a></td>
                    <td><c:out value="${customers.customer_id}" /></td>
                    <td><c:out value="${customers.first_name}" />  <c:out value="${customers.last_name}" /></td>
                    <td><c:out value="${customers.dob}" /></td>
                    <td><c:out value="${customers.gender}" /></td>
                    <td><c:out value="${customers.address_line1}" /> <c:out value="${customers.address_line2}" /> <c:out value="${customers.city}" /> <c:out value="${customers.state}" /><c:out value="${customers.zip}" /></td>
                    <td><c:out value="${customers.cell_phone}" /> <c:out value="${customers.home_phone}" /></td>
                    <td><c:out value="${customers.email}" /></td>
                    
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="customerController?action=insert">Add Customer</a></p>
</body>
</html>