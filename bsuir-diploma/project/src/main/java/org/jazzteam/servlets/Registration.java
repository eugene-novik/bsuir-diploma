package org.jazzteam.servlets;

import org.jazzteam.model.serializer.UserManager;
import org.jazzteam.model.table.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {
    private UserManager userManager;

    @Override
    public void init() {
        userManager = new UserManager();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setNikname(request.getParameter("nickname"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setMobile(Integer.parseInt(request.getParameter("mobile")));
        user.setCity(request.getParameter("city"));
        try {
            userManager.addUser(user, request.getParameter("type"));
            response.sendRedirect("logIn.jsp");
            System.out.println("Ok");
        } catch (Exception e) {
            response.sendRedirect("registration.jsp");
            response.getWriter().print("ERROR");
            System.out.println("Error");
        }

    }
}
