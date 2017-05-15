package org.jazzteam.model.serializer;

import org.jazzteam.model.table.*;
import org.junit.Before;
import org.junit.Test;


public class CommentManagerTest {
    private CommentManager manager;
    private UserManager userManager;
    @Before
    public void setUp() throws Exception {
        manager= new CommentManager();
        userManager=new UserManager();
    }
    @Test
    public void insert() throws Exception {
//        User eugene = new User("admin", "admin", "genesis.sebp@gmail.com", "Новик", "Евгений", "Минск", 336311348);
//        User john = new User("john93", "qwerty", "trespass@gmail.com", "Гуштын", "Борис", "Минск", 336311348);
//        userManager.addUser(eugene, "Арендодатель");
//        userManager.addUser(john, "Арендатор");
//        manager.addComment(eugene,john,"Коментирую");
        User user=userManager.getUser("Eugene");
        System.out.println(user.getNikname());

//        System.out.println(manager.getComments("Eugene"));

        System.out.println(user.getComments().get(0).getComment());

    }
}
