package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findUserByUsernameAndPassword(String id, String password) {
        User user = userDao.findUserByUsernameAndPassword(id,password);
        return user;
    }
}
