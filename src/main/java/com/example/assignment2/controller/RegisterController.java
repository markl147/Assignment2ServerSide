package com.example.assignment2.controller;

import com.example.assignment2.model.User;
import com.example.assignment2.model.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<User> users = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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

        String name = request.getParameter("userName");
        String email = request.getParameter("userEmail");
        String password = request.getParameter("userPassword");

        User u1 = new User(name, email, password);

        try {
            ArrayList<User> users = new ArrayList<User>();

            for(int i = 0; i < users.size(); i++) {

                if(email == users.get(i).getEmail()){
                }
            }

            users.add(u1);

            UserDAO.instance.save(u1);

            request.setAttribute("userRegisterList", users);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("information could not be retrieved register controller");
            // TODO Auto-generated catch block
            //e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}