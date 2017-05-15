package org.jazzteam.model.serializer;

import org.jazzteam.model.table.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

public class UserManagerTest {
    public static final String ACTUAL_EMAIL = "genesis.sebp@gmail.com";
    public static final String NOW_EMAIL = "zhenya.novik@mail.ru";
    private UserManager userManager;

    @Before
    public void setUp() throws Exception {
        userManager = new UserManager();
        User eugene = new User("admin", "admin", "genesis.sebp@gmail.com", "Новик", "Евгений", "Минск", 336311348);
        User john = new User("john93", "qwerty", "trespass@gmail.com", "Гуштын", "Борис", "Минск", 336311348);
        userManager.addUser(eugene, "admin");
        userManager.addUser(john, "Арендатор");
    }

    @After
    public void removeData() throws Exception {
        userManager.removeUser("admin");
        userManager.removeUser("john93");
    }

    @Test
    public void getUser() throws Exception {
        User eugene = userManager.getUser("admin");
        assertEquals(eugene.getEmail(), ACTUAL_EMAIL);
        assertEquals(eugene.getPassword(), "admin");
        assertEquals(eugene.getMobile(), 336311348);

    }

    @Test
    public void update() throws Exception {
        User eugene = userManager.getUser("admin");
        assertEquals(eugene.getEmail(), ACTUAL_EMAIL);

        eugene.setEmail(NOW_EMAIL);
        userManager.update(eugene);

        eugene = userManager.getUser("admin");
        assertEquals(eugene.getEmail(), NOW_EMAIL);
    }

    @Test
    public void getAllUser() throws Exception {
        List<User> allUser = userManager.getAllUser();
        assertEquals(allUser.get(0).getNikname(), "admin");
        assertEquals(allUser.get(1).getNikname(), "john93");
        assertEquals(allUser.size(), 2);

        User george = new User("george21", "qwe", "george23@gmail.com", "Алешко", "Иван", "Минск", 336311348);
        userManager.addUser(george, "Арендодатель");

        allUser = userManager.getAllUser();
        assertEquals(allUser.size(), 3);
        assertEquals(allUser.get(2).getNikname(), "george21");

        userManager.removeUser("george21");
    }

//    @Test
//    public void insertDuplicate() throws Exception {
//        User eugene = new User("admin", "admin", "genesis.sebp@gmail.com", "Новик", "Евгений", "Минск", 336311348);
//        User john = new User("admin", "admin", "genesis.sebp@gmail.com", "Новик", "Евгений", "Минск", 336311348);
//            userManager.addUser(eugene, "admin");
//            try {
//                userManager.addUser(john, "admin");
//
//            }catch (Exception e){
//            }
//            john.setNikname("john");
//            try {
//                userManager.addUser(john, "admin");
//
//            }catch (Exception e){
//            }
//        }



}
