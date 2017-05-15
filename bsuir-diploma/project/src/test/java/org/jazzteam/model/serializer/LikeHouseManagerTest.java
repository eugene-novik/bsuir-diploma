package org.jazzteam.model.serializer;

import org.jazzteam.model.table.Apartment;
import org.jazzteam.model.table.LikeHouse;
import org.jazzteam.model.table.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LikeHouseManagerTest {
    private UserManager userManager;
    private LikeHouseManager likeHouseManager;
    private User john;
    private User eugene;
    private User george;

    @Before
    public void setUp() throws Exception {
        userManager = new UserManager();
        likeHouseManager=new LikeHouseManager();
        ApartmentManager apartmentManager = new ApartmentManager();
        john = new User("john93", "qwerty", "trespass@gmail.com", "Гуштын", "Борис", "Сергеевич", 336311348);
        userManager.addUser(john, "Арендодатель");
        Apartment apartment = new Apartment("doc", 100, "free", 0,"cool");
        apartmentManager.addApartment(apartment, john);
        eugene = new User("eugene", "sql", "genesis.sebp@gmail.com", "Новик", "Евгений", "Михайлович", 296561148);
        george = new User("george", "sql", "ge3is.sebp@gmail.com", "Борадач", "Борадач", "Борадач", 296561148);
        userManager.addUser(eugene, "Арендатор");
        userManager.addUser(george, "Арендатор");

        likeHouseManager.like(john,eugene);
        likeHouseManager.like(john,george);
        System.out.println(john.getProposals().get(0).getResponse());
    }

    @After
    public void remove() throws Exception {
        userManager.removeUser("john93");
        userManager.removeUser("eugene");
        userManager.removeUser("george");
    }

    @Test
    public void testLike() throws Exception {

    }

}
