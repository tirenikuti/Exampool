package comp3350.exampool.tests.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.exampool.business.AccessUsers;
import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.UserPersistence;
import comp3350.exampool.persistence.hsqldb.UserPersistenceHSQLDB;
import comp3350.exampool.tests.utils.TestUtils;

public class AccessUsersIT {
    private AccessUsers accessUsers;
    private File tempDB;

    @Before
    public void setUp() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final UserPersistence persistence = new UserPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessUsers = new AccessUsers(persistence);
    }

    @Test
    public void testListUsers() {
        final User user;

        user = accessUsers.getSequential();
        assertNotNull("first sequential note should not be null", user);
        assertTrue("100".equals(user.getUserID()));

        System.out.println("Finished test AccessUsers");
    }

    @Test
    public void testGetUsers(){
        final List<User> users = accessUsers.getUsers();
        assertEquals(6, users.size());
    }

    @Test
    public void testDeleteNote(){
        final User user = accessUsers.getSequential();
        List<User> users = accessUsers.getUsers();
        assertEquals(6, users.size());
        accessUsers.deleteUser(user);
        users = accessUsers.getUsers();
        assertEquals(5, users.size());
    }

    @Test
    public void testInsertUsers(){
        final User user = new User("400", "Student", "Jerry Smitch");
        accessUsers.insertUser(user);
        assertEquals(7, accessUsers.getUsers().size());
    }

    @Test
    public void testUpdateUsers(){
        final User user = accessUsers.getSequential();
        final User userUpdate = new User(user.getUserID(), "teacher", "Hank Smith");
        accessUsers.updateUser(userUpdate);
        assertEquals(6, accessUsers.getUsers().size());
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
