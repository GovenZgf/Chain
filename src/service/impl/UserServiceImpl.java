package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findUserByUsernameAndPassword(String id, String password) {
        User user = userDao.findUserByUsernameAndPassword(id,password);
        return user;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public ArrayList<User> selectAllUsers() {
        return userDao.selectALLUsers();
    }

    @Override
    public void deleteUser(String uid) {
        userDao.deleteUser(uid);
    }

    @Override
    public void modifyUserInfo(String id, String cun, String cup, String cUid) {
        userDao.modifyUser(id,cun,cup,cUid);
    }
}
