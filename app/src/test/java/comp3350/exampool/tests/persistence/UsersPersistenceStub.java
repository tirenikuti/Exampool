package comp3350.exampool.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.exampool.objects.User;
import comp3350.exampool.persistence.NotesPersistence;

public class UsersPersistenceStub {
    private List<User> users;

    public UsersPersistenceStub(){
        this.users = new ArrayList<>();

        users.add(new User("200", "Student", "John Green"));
    }
}
