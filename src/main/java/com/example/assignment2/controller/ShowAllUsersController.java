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

@WebServlet(name = "ShowAllUsersController", value = "/ShowAllUsersController")
public class ShowAllUsersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<User> allUsers = new ArrayList<>();

        try {
            allUsers = UserDAO.instance.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("myUserList", allUsers);
        request.getRequestDispatcher("showAllUsers.jsp").forward(request, response);
    }
}
