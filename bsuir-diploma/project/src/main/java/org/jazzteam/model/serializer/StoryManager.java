package org.jazzteam.model.serializer;

import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.Story;
import org.jazzteam.model.table.User;

public class StoryManager extends Transaction {

    public void addStory(Apartment apartment, User user) throws Exception {
        if (user.getControl().getType().equals("Арендатор")) {
            begin();
            try {
                Story story = new Story();
                story.setUser(user);
                story.setApartment(apartment);
                apartment.getStories().add(story);
                user.getStories().add(story);
                getSession().save(story);
                getSession().save(user);
                getSession().save(apartment);
            } catch (Exception e) {
                rollback();
                throw new Exception("Error");
            } finally {
                commit();
            }
        } else {
            throw new Exception(user.getControl().getType() + "can not live in the apartment");
        }

    }
}
