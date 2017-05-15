package org.jazzteam.servlets;

import org.jazzteam.model.table.User;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jazzteam.model.table.Comment;

import java.io.IOException;

public class ReviewShow extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("show");
        String allComment = "[";
        JSONObject comment = new JSONObject();
        if (user.getComments() != null) {
            for (Comment item : user.getComments()) {
                try {
                    comment.put("comment", item.getComment());
                    comment.put("commentator", item.getCommentator().getNikname());
                    comment.put("user", item.getUser().getNikname());
                    allComment += comment + ",";

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            allComment = allComment.substring(0, allComment.length() - 1);
            allComment += "]";
            response.getWriter().print(allComment);
        } else {
            response.getWriter().print("ERROR");
        }
    }
}
