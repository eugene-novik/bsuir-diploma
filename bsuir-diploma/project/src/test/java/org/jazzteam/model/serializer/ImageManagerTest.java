package org.jazzteam.model.serializer;

import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.Image;
import org.jazzteam.model.table.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ImageManagerTest {
    private UserManager userManager;
    private ImageManager imageManager;
    private ApartmentManager apartmentManager;
    private Image image;

    @Before
    public void setUp() throws Exception {
        userManager = new UserManager();
        imageManager = new ImageManager();
        apartmentManager = new ApartmentManager();
        User john = new User("john93", "qwerty", "trespass@gmail.com", "Гуштын", "Борис", "Сергеевич", 336311348);
        userManager.addUser(john, "Арендодатель");
        Apartment apartment = new Apartment("doc", 100, "free", 0,"cool");
        apartmentManager.addApartment(apartment, john);
        image = new Image("кухня", "7 метров, хорошая обстановка");
        imageManager.addImage(image, apartment);
    }

    @After
    public void tearDown() throws Exception {
        userManager.removeUser("john93");
    }

    @Test
    public void update() throws Exception {
        User user = userManager.getUser("john93");
        assertEquals(user.getApartment().getImages().get(0).getImage(), "кухня");

        image.setImage("ванна");
        imageManager.updateImage(image);

        user = userManager.getUser("john93");
        assertEquals(user.getApartment().getImages().get(0).getImage(), "ванна");
    }
}
