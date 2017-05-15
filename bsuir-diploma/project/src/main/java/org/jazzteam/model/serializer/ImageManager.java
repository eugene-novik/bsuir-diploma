package org.jazzteam.model.serializer;

import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.Image;

public class ImageManager extends Transaction {

    public ImageManager() {

    }

    public void addImage(Image image, Apartment apartment) throws Exception {
        begin();
        try {
            image.setApartment(apartment);
            apartment.getImages().add(image);
            getSession().save(image);
            getSession().save(apartment);
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        } finally {
            commit();
        }
    }

    public void updateImage(Image image) throws Exception {
        begin();
        try {
            getSession().update(image);
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        } finally {
            commit();

        }
    }

    public void removeImage(Image image) throws Exception {
        begin();
        try {
            getSession().update(image);
        } catch (Exception e) {
            rollback();
            throw new Exception("Error");
        } finally {

            commit();
        }
    }


}
