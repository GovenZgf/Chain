package service.impl;

import dao.ManagerDao;
import dao.impl.ManagerDaoImpl;
import pojo.Manager;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    private  ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public Manager findManagerByIdAndPassword(String id, String pass) {
        Manager manager = managerDao.findManagerByIdAndPassword(id, pass);
        return manager;
    }
}
