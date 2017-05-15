package org.jazzteam.model.serializer;

import org.jazzteam.model.table.LikeHouse;
import org.jazzteam.model.table.User;

public class LikeHouseManager extends Transaction {

    public void like(User landlord, User lessee) throws Exception {
        begin();
        try {
            LikeHouse likeHouse = new LikeHouse();
            likeHouse.setLessee(lessee);
            likeHouse.setLandlord(landlord);
            landlord.getProposals().add(likeHouse);
            lessee.getBids().add(likeHouse);
            getSession().save(likeHouse);
            getSession().save(landlord);
            getSession().save(lessee);
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        } finally {
            commit();
        }
    }

    public void update(LikeHouse likeHouse) throws Exception {
        begin();
        try {
            getSession().update(likeHouse);
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        } finally {
            commit();
        }
    }


}
