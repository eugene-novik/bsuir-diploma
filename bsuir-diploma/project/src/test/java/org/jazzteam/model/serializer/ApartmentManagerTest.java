package org.jazzteam.model.serializer;

import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ApartmentManagerTest {
    private UserManager userManager;
    private ApartmentManager apartmentManager;

    @Before
    public void setUp() throws Exception {
        userManager = new UserManager();
        apartmentManager = new ApartmentManager();
        User john = new User("john93", "qwerty", "trespass@gmail.com", "Гуштын", "Борис", "Сергеевич", 336311348);
        userManager.addUser(john, "Арендодатель");
        Apartment apartment = new Apartment("doc", 100, "free", 0, "клевая квартира");
        apartmentManager.addApartment(apartment, john);
    }

    @After
    public void tearDown() throws Exception {
        userManager.removeUser("john93");
    }
    @Test
    public void update() throws Exception {
        User user = userManager.getUser("john93");
        Apartment apartment = apartmentManager.getApartment(user);
        assertEquals(apartment.getRating(), 0);

        apartment.setRating(5);
        apartmentManager.updateApartment(apartment);

        user = userManager.getUser("john93");
        apartment = apartmentManager.getApartment(user);
        assertEquals(apartment.getRating(), 5);

    }
}
