package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findUserByUsernameAndPassword(String id, String password) {
        User user = userDao.findUserByUsernameAndPassword(id,password);
        return user;
    }
}
