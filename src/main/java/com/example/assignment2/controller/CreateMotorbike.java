package com.example.assignment2.controller;

import com.example.assignment2.model.Motorbike;
import com.example.assignment2.model.MotorbikeDAO;
import com.example.assignment2.model.User;
import com.example.assignment2.model.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CreateMotorbike", value = "/CreateMotorbike")
public class CreateMotorbike extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String motorbikeID = request.getParameter("motorbikeID");
        String email = request.getParameter("motorbikeEmail");
        String make = request.getParameter("motorbikeMake");
        String model = request.getParameter("motorbikeModel");
        String cc = request.getParameter("motorbikeCc");

        Motorbike m1 = new Motorbike(motorbikeID, email, make, model, cc);

        try {
            ArrayList<Motorbike> motorbikes = new ArrayList<Motorbike>();

            for(int i = 0; i < motorbikes.size(); i++) {

                if(email == motorbikes.get(i).getEmail()){
                }
            }

            motorbikes.add(m1);

            MotorbikeDAO.instance.save(m1);

            request.setAttribute("createMotorbikeList", motorbikes);

            request.getRequestDispatcher("AllMotorbikeController").forward(request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.getRequestDispatcher("createMotorbike.jsp").forward(request, response);
        }
    }
    }

