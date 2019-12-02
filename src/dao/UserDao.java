package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    User findUserByUsernameAndPassword(String id,String password);
    void updateUser(User user);
    void saveUser(User user);
}
