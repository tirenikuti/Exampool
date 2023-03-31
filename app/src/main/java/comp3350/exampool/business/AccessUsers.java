////used to access the users from the database - using services to get the persistence.
package comp3350.exampool.business;

import java.util.Collections;
import java.util.List;

import comp3350.exampool.application.Services;
import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.UserPersistence;

public class AccessUsers {
    //Class Variables
    private UserPersistence userPersistence;
    private List<User> users;
    private User user;
    private int currentUser;

    /**
     * Blank constructor for AccessUsers
     */
    public AccessUsers()
    {
        userPersistence = Services.getUserPersistence();
        users = null;
        user = null;
        currentUser = 0;
    }

    /**
     * Constructor for AccessUsers
     * @param userPersistence userPersistence
     */
    public AccessUsers(final UserPersistence userPersistence){
        this();
        this.userPersistence = userPersistence;
    }

    /**
     * Gets a List of the Users from the persistence variable.
     * @return List of users
     */
    public List<User> getUsers()
    {
        users = userPersistence.getUserSequential();
        return Collections.unmodifiableList(users);
    }

    /**
     *
     * @return
     */
    public User getSequential()
    {
        if (users == null){
            users = userPersistence.getUserSequential();
            currentUser = 0;
        }
        if (currentUser < users.size())
        {
            user = users.get(currentUser);
            currentUser++;
        }
        else
        {
            users = null;
            user = null;
            currentUser = 0;
        }
        return user;
    }

    public User getRandom(String userID)
    {
        user = null;
        if (userID.trim().equals(""))
        {
            System.out.println("*** Invalid User ID ***");
        }
        else
        {
            users = userPersistence.getUserRandom(new User(userID));
            if (users.size() == 1)
            {
                user = (User) users.get(0);
            }
        }
        return user;
    }

    public User insertUser(User currentUser)
    {
        return userPersistence.insertUser(currentUser);
    }

    public User updateUser(User currentUser)
    {
        return userPersistence.updateUser(currentUser);
    }

    public void deleteUser(User currentUser)
    {
        userPersistence.deleteUser(currentUser);
    }
}
