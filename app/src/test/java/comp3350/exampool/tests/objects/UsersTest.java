package comp3350.exampool.tests.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.exampool.objects.User;

public class UsersTest {
    private User user;
    @Test
    public void CreateUsersTest(){
        System.out.println("\nStarting Create Users Test");

        user = new User("100", "Teacher", "Harry Potter");
        assertNotNull(user);
        assertTrue("100".equals(user.getUserID()));
        assertTrue("Teacher".equals(user.getAccountType()));
        assertTrue("Harry Potter".equals(user.getUserName()));

        System.out.println("Finished Create Notes Test");
    }

}