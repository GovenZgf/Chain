package service;

import pojo.User;

public interface UserService {
    User findUserByUsernameAndPassword(String id, String password);
}
