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

public class carController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/car.jsp";
    private static String LIST_USER = "/listCar.jsp";
    private carDAO dao;

    public carController() {
        super();
        dao = new carDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        System.out.println(request.getParameter("color")+"action is"+action);

        if (action.equalsIgnoreCase("delete")){
            String carId = request.getParameter("car_id");
            dao.deleteCar(carId);
            forward = LIST_USER;
            request.setAttribute("cars", dao.getAllCars());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String carId = request.getParameter("car_id");
            Car car = dao.getCarById(carId);
            request.setAttribute("car", car);
        } else if (action.equalsIgnoreCase("listCar")){
            forward = LIST_USER;
            request.setAttribute("cars", dao.getAllCars());
        } 
         else {
            forward = INSERT_OR_EDIT;
            System.out.println("i am in insert ");
        }

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