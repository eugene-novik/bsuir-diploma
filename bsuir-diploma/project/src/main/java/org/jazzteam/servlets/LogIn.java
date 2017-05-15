package org.jazzteam.servlets;

import org.jazzteam.model.serializer.UserManager;
import org.jazzteam.model.table.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogIn extends HttpServlet {
    private UserManager userManager;

    @Override
    public void init() {
        userManager = new UserManager();
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String nickname = request.getParameter("nickname");
        final String password = request.getParameter("password");
        User user = null;
        try {
            user = userManager.getUser(nickname);
            if (user.getPassword().equals(password)) {
                if (user.getControl().getType().equals("Арендодатель")) {
                    response.getWriter().print("Landlord");
                } else {
                    response.getWriter().print("Lessee");
                }
                request.getSession().setAttribute("user", user);
            } else {
                response.getWriter().print("ERROR");
            }
        } catch (Exception e) {
            response.getWriter().print("ERROR");
        }

    }

}
