package org.jazzteam.servlets;

import org.jazzteam.model.serializer.ApartmentManager;
import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Settings extends HttpServlet {

    private ApartmentManager apartmentManager;

    @Override
    public void init() {
        apartmentManager = new ApartmentManager();

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        try {
            if (user.getApartment() != null) {
                user.getApartment().setStatus(request.getParameter("status"));
                user.getApartment().setDescription((request.getParameter("description")));
                user.getApartment().setPrice(Integer.parseInt(request.getParameter("price")));
                apartmentManager.updateApartment(user.getApartment());
            } else {
                Apartment apartment = new Apartment();
                apartment.setStatus(request.getParameter("status"));
                apartment.setPrice(Integer.parseInt(request.getParameter("price")));
                apartment.setDescription(request.getParameter("description"));
                apartmentManager.addApartment(apartment, user);
            }
        } catch (Exception e) {
            response.getWriter().print("Error");
        }finally {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("landlord.jsp");
        }
    }
}
