package org.jazzteam.model.serializer;

import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StoryManagerTest {
    private UserManager userManager;
    private ApartmentManager apartmentManager;

    @Before
    public void setUp() throws Exception {
        userManager = new UserManager();
        apartmentManager = new ApartmentManager();

    }

    @After
    public void remove() throws Exception {
        userManager.removeUser("john93");
        userManager.removeUser("eugene");
    }

    @Test
    public void createStory() throws Exception {
        User john = new User("john93", "qwerty", "trespass@gmail.com", "Гуштын", "Борис", "Сергеевич", 336311348);
        userManager.addUser(john, "Арендодатель");
        Apartment apartment = new Apartment("doc", 100, "free", 0,"cool");
        apartmentManager.addApartment(apartment, john);
        User eugene = new User("eugene", "sql", "genesis.sebp@gmail.com", "Новик", "Евгений", "Михайлович", 296561148);
        userManager.addUser(eugene, "Арендатор");
        StoryManager storyManager=new StoryManager();
        storyManager.addStory(apartment,eugene);
    }
}
