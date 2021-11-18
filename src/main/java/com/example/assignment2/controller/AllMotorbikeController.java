package com.example.assignment2.controller;

import com.example.assignment2.model.Motorbike;
import com.example.assignment2.model.MotorbikeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AllMotorbikeController", value = "/AllMotorbikeController")
public class AllMotorbikeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMotorbikeController() {
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
        ArrayList<Motorbike> allMotorbikes = new ArrayList<>();

        try {
            allMotorbikes = MotorbikeDAO.instance.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("myList", allMotorbikes);
        request.getRequestDispatcher("showMotorbikes.jsp").forward(request, response);
    }

}
