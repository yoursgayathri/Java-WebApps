<%-- 
    Document   : searchCustomer
    Created on : Apr 10, 2015, 3:51:12 PM
    Author     : Gayathri
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin-left: 350px;margin-top: 50px">
  
        <br>
        <form method="GET" action='customersSaleController' name="searchForm"> 

            <table border="1" cellpadding="50" style="border-style: hidden">

                <tbody>
                    <tr>
                        <td>

                            <h3>Existing Customer? Search using any of the following fields</h3>
                            <br>

                            <font>Customer ID</font> 
                            <input type="text" name="customer_id"  /> 
                            <br><br>
                            <font>First Name</font> 
                            <input type="text" name="first_name"  /> 
                            <br><br>
                            <font>Last Name :</font>
                            <input type="text" name="last_name"/> 


                            <input type="hidden" name="address_line1" /> 
                            <input type="hidden" name="address_line2" /> 
                            <input type="hidden" name="gender" /> 
                            <input type="hidden" name="dob" /> 
                            <input type="hidden" name="city" /> 
                            <input type="hidden" name="state"  />  
                            <input type="hidden" name="zip" /><br><br>
                            <font>cell number:</font>
                            <input type="text" name="cell_phone" />

                            <input type="hidden" name="home_phone" /> 
                            <input type="hidden" name="email" /> 
                            <input type="hidden" name="car_id" value=" <c:out value="${sessionScope.car_id}" />"/> 


                            <br><br>


                            <input type="submit" value="Look up Customer!" formaction="customersSaleController" />

                            <br>
                            <br>


                        </td>
                        <td>

                            <jsp:include page="customer.jsp"></jsp:include>

                        </td>
                    </tr>
                </tbody>
            </table>








        </form>
    </body>
</html>
