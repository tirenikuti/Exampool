package comp3350.exampool.persistence;

import java.util.List;

import comp3350.exampool.objects.User;

public interface UserPersistence {
    List<User> getUserSequential();

    List<User> getUser(final User currentUser);

    User insertUser(final User currentUser);

    void deleteUser(final User currentUser);
}
