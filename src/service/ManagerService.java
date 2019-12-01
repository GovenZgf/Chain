package service;

import pojo.Manager;

public interface ManagerService {
    Manager findManagerByIdAndPassword(String id,String pass);
}
