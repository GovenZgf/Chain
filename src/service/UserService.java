package service;

import pojo.User;

import java.util.ArrayList;

public interface UserService {
    User findUserByUsernameAndPassword(String id, String password);
    void saveUser(User user);
    ArrayList<User> selectAllUsers();
    void deleteUser(String uid);
    void modifyUserInfo(String id,String cun,String cup,String cuid);
}
