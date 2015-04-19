/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.carDAO;
import DAO.customerDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.saleDAO;
import Models.Car;
import Models.Customer;
import Models.New_Car;
import Models.Sale;
import Models.Used_Car;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class carSaleController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/sale.jsp";
    private static String LIST_USER = "/listSale.jsp";
    private static String LIST_CUSTOMER = "/lookForCustomer.jsp";
    private saleDAO dao;
     private customerDAO custdao;
     private carDAO cardao;
     private New_Car newcar_result;
     private Used_Car usedcar_result;
     
     
    public carSaleController() {
        super();
        dao = new saleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        System.out.println("actionaha "+action);
            if (action.equalsIgnoreCase("customer"))
            {
                forward = LIST_CUSTOMER;
                String car_id = request.getParameter("car_id");
                 HttpSession session = request.getSession();
                 session.setAttribute("car_id", car_id);
            } 
            else if (action.equalsIgnoreCase("sale"))
            {
            forward = LIST_USER;
            //getting car details
            HttpSession session = request.getSession();
            String car=   (String) session.getAttribute("car_id");
            cardao=new carDAO();
            Car car_2=cardao.getCarById(car);
            request.setAttribute("car", car_2);
            System.out.println(car+"in sale sale" +action);
            
            //gettign customer details            
            String customerId = request.getParameter("customer_id");
            custdao = new customerDAO();
            Customer customer = custdao.getCustomerById(customerId);
            request.setAttribute("customer", customer);
            
            //gettign date
            Calendar calendar_today=new GregorianCalendar();
           String date_today=calendar_today.get(Calendar.YEAR)+"-"+calendar_today.get(Calendar.MONTH)+"-"+calendar_today.get(Calendar.DATE);
            System.out.println(date_today);
          String string = date_today;
          DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
           Date date;
            try {
                date = format.parse(string);
                System.out.println(date);
            } catch (ParseException ex) {
                Logger.getLogger(carSaleController.class.getName()).log(Level.SEVERE, null, ex);
            }

           java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    System.out.println("today date"+sqlDate);
            
            
            //gettign price of car
           saleDAO dao=new saleDAO();
           String category=car_2.getCategory();
           if(category.equalsIgnoreCase("new"))
           {
         newcar_result= dao.getPrice(car);
           System.out.println("in new");
           }
           else if(category.equalsIgnoreCase("old"))
           {
                System.out.println("in old");
            usedcar_result=dao.getAskingPrice(car);
           }
          
          Sale carsale=new Sale();
          carsale.setCar_id(car);
          carsale.setCustomer_id(customerId);
          carsale.setDate_of_sale(sqlDate);
          carsale.setSale_price(newcar_result.getMarket_price());
          
            
            //String color=request.getParameter("color");
            //String model=request.getParameter("model");
            //int model_year=Integer.parseInt(request.getParameter("model_year").toString());
           // float mileage=Float.parseFloat(request.getParameter("mileage").toString());
           // String manufacturer=request.getParameter("manufacturer");
           // System.out.println(category+"sdfsdfds"+request.getParameter("category"));
            //Sale saleSearch=new Sale();
            //saleSearch.setCategory(category);
            //saleSearch.setColor(color);
           // saleSearch.setModel(model);
            //saleSearch.setModel_year(model_year);
            //saleSearch.setMileage(mileage);
            //saleSearch.setManufacturer(manufacturer);
            request.setAttribute("sales",carsale);
            }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Sale sale = new Sale();
        /*sale.setVin(request.getParameter("vin"));
        sale.setCategory(request.getParameter("category"));
        sale.setColor(request.getParameter("color"));
        sale.setModel(request.getParameter("model"));
         sale.setManufacturer(request.getParameter("manufacturer"));*/
      /*
        
        try {
            sale.setModel_year(new Integer(request.getParameter("model_year")));
            sale.setMileage(new Float(request.getParameter("mileage")));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
       
        String saleid = request.getParameter("sale_id");
        System.out.println("heloooa"+saleid);
        if(saleid == null || saleid.isEmpty())
        {
            dao.addSale(sale);
        }
        else
        {
            sale.setCar_id(saleid);
           // dao.updateCar(sale);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("sales", dao.getAllCars());
        view.forward(request, response);
              
              */
    }
}