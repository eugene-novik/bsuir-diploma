package org.jazzteam.model.serializer;

import org.hibernate.Query;
import org.jazzteam.model.table.Control;
import org.jazzteam.model.table.User;

import java.util.List;

public class UserManager extends Transaction {

    public UserManager() {
    }

    public User getUser(String nikname) throws Exception {
        User user;
        try {
            begin();
            Query query = getSession().createQuery("from User where nikname=:code");
            query.setParameter("code", nikname);
            user = (User) query.list().get(0);

        } catch (Exception e) {
            rollback();
            throw new Exception("User "+ nikname+" not found");
        }
        return user;
    }

    public void addUser(User user, String access) throws Exception {
        begin();
        try {
            Query query = getSession().createQuery("from Control where type=:code");
            query.setParameter("code", access);
            Control control = (Control) query.list().get(0);
            user.setControl(control);
            control.getUsers().add(user);
            getSession().save(user);
            commit();
        } catch (Exception e) {
            rollback();
            throw new Exception("Come up with another nickname");
        }
    }

    public void removeUser(String nikname) throws Exception {
        try {
            begin();
            Query query = getSession().createQuery("from User where nikname=:code");
            query.setParameter("code", nikname);
            User user = (User) query.list().get(0);
            getSession().delete(user);
            commit();
        } catch (Exception e) {
            rollback();
            throw new Exception("User not found");
        }
    }

    public void update(User user) throws Exception {
        try {
            begin();
            getSession().update(user);
            commit();
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        }
    }

    public List<User> getAllUser() throws Exception {
        Query query=null;
        try {
            begin();
            query = getSession().createQuery("from User");
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        }
        return (List<User>) query.list();
    }

}
