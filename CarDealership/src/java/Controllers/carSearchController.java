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

import DAO.carDAO;
import Models.Car;

public class carSearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/car.jsp";
    private static String LIST_USER = "/listCar.jsp";
    private carDAO dao;

    public carSearchController() {
        super();
        dao = new carDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
       float mileage;
       int model_year;
            forward = LIST_USER;
            String s= request.getParameter("mileage");
            System.out.println("in search car");
            String category=request.getParameter("category");
            String color=request.getParameter("color");
            String model=request.getParameter("model");
            if(!request.getParameter("model_year").isEmpty())
            {model_year=Integer.parseInt(request.getParameter("model_year"));
            System.out.println("year"+model_year);}
            else{model_year=0;}
            if(!request.getParameter("mileage").isEmpty())
            {mileage=Float.parseFloat(s);}
            else{mileage=0;}
            String manufacturer=request.getParameter("manufacturer");
            System.out.println(category+"sdfsdfds"+request.getParameter("category"));
            Car carSearch=new Car();
            carSearch.setCategory(category);
            carSearch.setColor(color);
            carSearch.setModel(model);
            carSearch.setModel_year(model_year);
            carSearch.setMileage(mileage);
            carSearch.setManufacturer(manufacturer);
            request.setAttribute("cars", dao.searchCar(carSearch));
       
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = new Car();
        car.setVin(request.getParameter("vin"));
        car.setCategory(request.getParameter("category"));
        car.setColor(request.getParameter("color"));
        car.setModel(request.getParameter("model"));
         car.setManufacturer(request.getParameter("manufacturer"));
      
        
        try {
            car.setModel_year(new Integer(request.getParameter("model_year")));
            car.setMileage(new Float(request.getParameter("mileage")));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
       
        String carid = request.getParameter("car_id");
        System.out.println("heloooa"+carid);
        if(carid == null || carid.isEmpty())
        {
            dao.addCar(car);
        }
        else
        {
            car.setCar_id(carid);
            dao.updateCar(car);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("cars", dao.getAllCars());
        view.forward(request, response);
    }
}