package com.example.assignment2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.assignment2.model.Motorbike;
import com.example.assignment2.model.MotorbikeDAO;
import com.example.assignment2.model.UserDAO;

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
        ArrayList<Motorbike> allMotorbikes = new ArrayList<>();

        try {
            allMotorbikes = MotorbikeDAO.instance.list();
        } catch (Exception e) {
            e.printStackTrace();
        }


        HttpSession session = request.getSession();
        String emailMBC = (String)session.getAttribute("userEmail");
        ArrayList<Motorbike> listOfMotorbikes = new ArrayList<>();
        try {
                listOfMotorbikes = (MotorbikeDAO.instance.selectOne(emailMBC));
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setAttribute("myList", listOfMotorbikes);
        request.getRequestDispatcher("showMotorbikes.jsp").forward(request, response);
    }
}