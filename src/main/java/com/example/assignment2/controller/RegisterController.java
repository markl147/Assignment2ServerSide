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
//        ArrayList<User> users = null;
//        try {
//            users = UserDAO.instance.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String name = request.getParameter("userName");
//        System.out.println("name input: " + name);
        String email = request.getParameter("userEmail");
        String password = request.getParameter("userPassword");

        User u1 = new User(email, name, password);

        System.out.println(name + email + password);
        try {
            ArrayList<User> users = new ArrayList<User>();
            System.out.println("just before for loop in register");

            for(int i = 0; i < users.size(); i++) {

                if(email == users.get(i).getEmail()){
                }
            }

            System.out.println("just after for loop in register");
            users.add(u1);
            System.out.println("just after users.add(u1) in register");

            UserDAO.instance.save(u1);
            System.out.println("u1 saved");

            //String check = "mcurran@ait.ie";
            //User user = UserDAO.instance.selectOne(check);
            //System.out.println(u1.getName());

//            HttpSession session = request.getSession();
//
//            session.setAttribute("User", u1);

            request.setAttribute("userRegisterList", users);

            System.out.println("just after request.setAttribute in register");

            request.getRequestDispatcher("index.jsp").forward(request, response);

            System.out.println("Just before register controller catch");
        } catch (Exception e) {
            System.out.println("information could not be retrieved register controller");
            // TODO Auto-generated catch block
            //e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}