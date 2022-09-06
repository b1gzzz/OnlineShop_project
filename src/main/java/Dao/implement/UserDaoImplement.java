package Dao.implement;

import Dao.UserDao;
import Essences.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UserDao {

    private static UserDaoImplement INSTANCE_DAO_USER;
    public List<User> users = new ArrayList<>();

    private UserDaoImplement() {
        init();
    }

    public static UserDaoImplement getInstance() {
        if (INSTANCE_DAO_USER == null) {
            INSTANCE_DAO_USER = new UserDaoImplement();
        }
        return INSTANCE_DAO_USER;
    }

    @Override
    public List<User> init() {
        users.add(new User(0, "Josh", "1111", true));
        users.add(new User(1, "Mike", "2222", true));
        users.add(new User(2, "Alice", "3333", true));
        users.add(new User(3, "Bob", "4444", true));
        users.add(new User(4, "Carl", "5555", false));

        return users;
    }
}
