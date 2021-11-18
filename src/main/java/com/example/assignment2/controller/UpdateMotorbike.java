package com.example.assignment2.controller;

import com.example.assignment2.model.MotorbikeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateMotorbike", value = "/UpdateMotorbike")
public class UpdateMotorbike extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();

        String motorbikeID = request.getParameter("motorbikeID");
        String email = request.getParameter("motorbikeEmail");
        String make = request.getParameter("motorbikeMake");
        String model = request.getParameter("motorbikeModel");
        String cc = request.getParameter("motorbikeCc");

        try {
            MotorbikeDAO.instance.update(motorbikeID, email, make, model, cc);
            request.getRequestDispatcher("AllMotorbikeController").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
