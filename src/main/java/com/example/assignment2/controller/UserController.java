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
        System.out.println("name input: " + name);
        String email = request.getParameter("userEmail");
        String password = request.getParameter("userPassword");

        User u1 = new User(name, email, password);


        try {
            ArrayList<User> users = UserDAO.instance.list();
            System.out.println("Start try");
            int userFound = 0;

                for (int i = 0; i < users.size(); i++) {

                    System.out.println("email: " + users.get(i).getEmail() + "password: " + users.get(i).getPassword());
                    System.out.println("Start for loop");
                    if (email.equals(users.get(i).getEmail())) {
                        userFound++;
                        System.out.println("Start email if");
                        if (password.equals(users.get(i).getPassword())) {
                           u1 = users.get(i);
                            userFound++;
                        }
                    }
                }
            System.out.println("userFound: " + userFound);
                if(userFound==0) {
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    System.out.println("email does not exist please register");
                }else if(userFound ==1) {
                    System.out.println("First else");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else if(userFound ==2){
                    HttpSession session = request.getSession();
                    System.out.println("name found: " + u1.getName() + "password found: " + u1.getPassword());
                    session.setAttribute("User", u1);
                    request.setAttribute("myUser", u1);
                    request.getRequestDispatcher("showUser.jsp").forward(request, response);
                }else {
                    System.out.println("something seriously wrong");
                }

        } catch (Exception e) {
            System.out.println("information could not be retrieved user controller");
            // TODO Auto-generated catch block
            //e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}