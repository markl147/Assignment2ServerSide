package com.example.assignment2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

import com.example.assignment2.model.Motorbike;
import com.example.assignment2.model.User;
import com.example.assignment2.model.UserDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    ArrayList<User> users = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
            ArrayList<User> users = UserDAO.instance.list();
            int userFound = 0;

                for (int i = 0; i < users.size(); i++) {

                    if (email.equals(users.get(i).getEmail())) {
                        userFound++;
                        if (password.equals(users.get(i).getPassword())) {
                           u1 = users.get(i);
                            userFound++;
                        }
                    }
                }

                if(userFound==0) {
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }else if(userFound ==1) {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else if(userFound ==2){
                    HttpSession session = request.getSession();
                    session.setAttribute("User", u1);

                    session.setAttribute("userEmail", u1.getEmail());
                    session.setAttribute("userName", u1.getName());

                    request.setAttribute("myUser", u1);
                    request.getRequestDispatcher("showUser.jsp").forward(request, response);
                }else {
                    System.out.println("something seriously wrong");
                }

        } catch (Exception e) {
            System.out.println("information could not be retrieved user controller");
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}