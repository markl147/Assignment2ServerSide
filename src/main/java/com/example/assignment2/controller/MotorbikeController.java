package com.example.assignment2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.assignment2.model.Motorbike;

/**
 * Servlet implementation class MotorbikeController
 */
@WebServlet("/MotorbikeController")
public class MotorbikeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotorbikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("Start bike controller");
//        String motorbikeID = request.getParameter("MotorbikeID");
        String email = request.getParameter("MotorbikeEmail");
        String make = request.getParameter("MotorbikeMake");
        String model = request.getParameter("MotorbikeModel");
        String cc = request.getParameter("MotorbikeCc");

        System.out.println(email + make + model + cc);
        ArrayList<Motorbike> listOfMotorbikes = new ArrayList();

        Motorbike b1 = new Motorbike(email, make, model, cc);
        listOfMotorbikes.add(b1);
        Motorbike b2 = new Motorbike( "suzie@gmail.com", "Suzuki", "Bandit", "600");
        Motorbike b3 = new Motorbike( "billy@gmail.com", "Honda", "VTX", "1300");
        listOfMotorbikes.add(b2);
        listOfMotorbikes.add(b3);
        System.out.print(b2.getEmail()+ " " +b2.getMake());

        request.setAttribute("myList", listOfMotorbikes);
        request.getRequestDispatcher("showMotorbikes.jsp").forward(request, response);
    }
}