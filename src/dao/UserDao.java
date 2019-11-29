package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    User findUserByUserIdAndPassword(String userId, String password);
    void saveUser(User user);
    List findAllUsers();
    User findUserById(String id);
    void updateUser(User user);
    void delete(String id,String userIDcard);
}
