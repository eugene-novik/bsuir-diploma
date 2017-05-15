package org.jazzteam.servlets;

import org.jazzteam.model.table.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Navigation {

    public static void redirectToIndexPage(final HttpServletResponse response, final String redirect) {
        try {
            response.sendRedirect(redirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean objectInSession(HttpSession session, String name) {
        if (getSessionUser(session,name) != null) {
            return true;
        }
        return false;
    }

    public static User getSessionUser(HttpSession session, String name) {
        final User user = (User) session.getAttribute(name);
        return user;
    }




}
