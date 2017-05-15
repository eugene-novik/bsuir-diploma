package org.jazzteam.model.serializer;

import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.User;

public class ApartmentManager extends Transaction {

    public ApartmentManager() {
    }

    public void addApartment(Apartment apartment, User user) throws Exception {
        try {
            begin();
            apartment.setUser(user);
            user.setApartment(apartment);
            getSession().save(apartment);
            getSession().save(user);
            commit();
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        }
    }

    public Apartment getApartment(User user) {
        return user.getApartment();
    }

    public void updateApartment(Apartment apartment) throws Exception {
        try {
            begin();
            getSession().update(apartment);
            commit();
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
            throw new Exception("Error");
        }
    }
}
