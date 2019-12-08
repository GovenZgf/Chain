package dao;

import pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    User findUserByUsernameAndPassword(String id,String password);
    void updateUser(String uid);
    void saveUser(User user);
    ArrayList<User> selectALLUsers();
    void deleteUser(String uid);
}
