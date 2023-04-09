package comp3350.exampool.tests.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.business.AccessUsers;
import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.UserPersistence;

public class AccessUsersTest {
    private AccessUsers accessUsers;
    private UserPersistence userPersistence;

    @Before
    public void setUp(){
        userPersistence = mock(UserPersistence.class);
        accessUsers = new AccessUsers(userPersistence);
    }

    @Test
    public void test(){
        final User user;

        System.out.println("\nStarting test AccessUsers");
        final List<User> users = new ArrayList<>();
        users.add(new User("200","Student","Hermoine Granger"));
        when(userPersistence.getUserSequential()).thenReturn(users);

        user = accessUsers.getSequential();
        assertNotNull("first sequential course should not be null", user);
        assertTrue("200".equals(user.getUserID()));

        verify(userPersistence).getUserSequential();

        System.out.println("Finished test AccessUsers");
    }
}
