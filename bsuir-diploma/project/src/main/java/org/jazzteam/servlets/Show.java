package org.jazzteam.servlets;

import org.jazzteam.model.serializer.UserManager;
import org.jazzteam.model.table.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Show extends HttpServlet {
    private UserManager userManager;

    @Override
    public void init() {
        userManager = new UserManager();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println(request.getParameter("nickname"));
            User user=userManager.getUser(request.getParameter("nickname"));
            request.getSession().setAttribute("show",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
