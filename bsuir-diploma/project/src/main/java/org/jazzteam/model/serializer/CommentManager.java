package org.jazzteam.model.serializer;

import org.hibernate.Query;
import org.jazzteam.model.table.Comment;
import org.jazzteam.model.table.User;

import java.util.List;

public class CommentManager extends Transaction {

    public void addComment(User landlord, User lessee, String text) throws Exception {
        begin();
        try {
            Comment comment = new Comment();
            comment.setUser(landlord);
            comment.setCommentator(lessee);
            comment.setComment(text);
            landlord.getComments().add(comment);
            getSession().save(comment);
            getSession().save(landlord);
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        } finally {
            commit();
        }
    }

    public List<Comment> getComments(String nickname) {
        begin();
        Query query = null;
        try {
            UserManager userManager = new UserManager();
            User user = userManager.getUser(nickname);
            query = getSession().createQuery("from Comment where iduser=:code");
            query.setParameter("code", user.getIduser());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commit();
        }
        return (List<Comment>) query.list();
    }

}
