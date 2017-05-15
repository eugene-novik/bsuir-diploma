package org.jazzteam.servlets;


import org.jazzteam.model.serializer.CommentManager;
import org.jazzteam.model.table.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddComment extends HttpServlet {
    private CommentManager commentManager;

    @Override
    public void init() throws ServletException {
        commentManager = new CommentManager();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("show");
        User commentator = (User) request.getSession().getAttribute("user");
        String text = request.getParameter("text");
        response.sendRedirect("reviewShow.jsp");
        try {
            commentManager.addComment(user, commentator, text);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
