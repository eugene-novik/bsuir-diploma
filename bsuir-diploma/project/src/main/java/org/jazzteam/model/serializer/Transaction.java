package org.jazzteam.model.serializer;

import org.hibernate.Session;
import org.jazzteam.model.persistence.HibernateUtil;

public class Transaction {
    private static Session session;

    public static Session getSession() {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        getSession().getTransaction().rollback();
        getSession().close();
        Transaction.session=null;
    }


}
