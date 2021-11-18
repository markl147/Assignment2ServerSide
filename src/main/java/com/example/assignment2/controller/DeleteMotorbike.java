package com.example.assignment2.controller;

import com.example.assignment2.model.MotorbikeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteMotorbike", value = "/DeleteMotorbike")
public class DeleteMotorbike extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String motorbikeID = request.getParameter("motorbikeID");
        String email = request.getParameter("motorbikeEmail");

        System.out.println(motorbikeID + " " + email);


        try {
            MotorbikeDAO.instance.delete(motorbikeID, email);
            request.getRequestDispatcher("AllMotorbikeController").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }

