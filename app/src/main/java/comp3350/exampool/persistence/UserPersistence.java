package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.User;

public interface UserPersistence {
    /**
     * Gets all the users in the database
     * @return list of users
     */
    List<User> getUserSequential();

    /**
     * Gets a specific user from the database
     * @param currentUser user needed from DB
     * @return user if it exists
     */
    List<User> getUserRandom(final User currentUser);

    /**
     * Method to insert a new user to the database
     * @param currentUser user to be inserted
     * @return user if it is inserted successfully
     */
    User insertUser(final User currentUser);

    /**
     * Method to update a user in the database
     * @param currentUser user to be updated
     * @return user if it is updated successfully
     */
    User updateUser(final User currentUser);

    /**
     * Method to delete user from the database
     * @param currentUser user to be deleted
     */
    void deleteUser(final User currentUser);
}
