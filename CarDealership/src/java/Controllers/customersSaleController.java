package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.customerDAO;
import Models.Customer;
import java.text.DateFormat;
import java.util.Locale;

public class customersSaleController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/customer.jsp";
    private static String LIST_USER = "/listCustomer.jsp";
    private static String LIST_USER_SALE = "/saleCustomer.jsp";
    private customerDAO dao;

    public customersSaleController() {
        super();
        dao = new customerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
          
       int zip;
            forward = LIST_USER_SALE;
            System.out.println("in sale customer");
            String customer_id=request.getParameter("customer_id");
            String first_name=request.getParameter("first_name");
            String last_name=request.getParameter("last_name");
            String dob=request.getParameter("dob");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            Date startDate=null;
            try {
               // startDate = df.parse(dob);
              //  System.out.println(startDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String gender=request.getParameter("gender");
            String address_line1=request.getParameter("address_line1");
            String address_line2=request.getParameter("address_line2");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            if(!request.getParameter("zip").isEmpty())
            {zip=Integer.parseInt(request.getParameter("zip"));
            System.out.println("zip"+zip);}
            else{zip=0;}
            String home_phone=request.getParameter("home_phone");
            String cell_phone=request.getParameter("cell_phone");
            String email=request.getParameter("email");
            
            System.out.println(address_line1+city+state+"zip cde is"+zip+gender+address_line1+email+dob);
            
            Customer customerSearch=new Customer();
            customerSearch.setCustomer_id(customer_id);
            customerSearch.setFirst_name(first_name);
            customerSearch.setLast_name(last_name);
           // customerSearch.setDob(null);
            customerSearch.setGender(gender);
            customerSearch.setAddress_line1(address_line1);
            customerSearch.setAddress_line2(address_line2);
            customerSearch.setCity(city);
            customerSearch.setState(state);
            customerSearch.setZip(zip);
             customerSearch.setCell_phone(cell_phone);
            customerSearch.setHome_phone(home_phone);
            customerSearch.setEmail(email);
           request.setAttribute("customers", dao.searchCustomer(customerSearch));
       
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        String customer_id=request.getParameter("customer_id");
        String first_name=request.getParameter("first_name");
            String last_name=request.getParameter("last_name");
            String dob=request.getParameter("dob");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            Date startDate=null;
            try {
                startDate = df.parse(dob);
              //  System.out.println(startDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String gender=request.getParameter("gender");
            String address_line1=request.getParameter("address_line1");
            String address_line2=request.getParameter("address_line2");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            String zip=request.getParameter("zip");
            String home_phone=request.getParameter("home_phone");
            String cell_phone=request.getParameter("cell_phone");
            String email=request.getParameter("email");
            customer.setCustomer_id(customer_id);           
            customer.setFirst_name(first_name);
            customer.setLast_name(last_name);
            customer.setDob(null);
            customer.setGender(gender);
            customer.setAddress_line1(address_line1);
            customer.setAddress_line2(address_line2);
            customer.setCity(city);
            customer.setState(state);
            customer.setZip(Integer.parseInt(zip));
            customer.setCell_phone(cell_phone);
            customer.setHome_phone(home_phone);
            customer.setEmail(email);
                
            String customerid=request.getParameter("customer_id");
        
        if(customerid == null || customerid.isEmpty())
        {
            dao.addCustomer(customer);
        }
        else
        {
            customer.setCustomer_id(customerid);
            dao.updateCustomer(customer);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("customers", dao.getAllCustomers());
        view.forward(request, response);
    }
}