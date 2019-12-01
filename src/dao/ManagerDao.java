package dao;

import pojo.Manager;

public interface ManagerDao {
    Manager findManagerByIdAndPassword(String mid,String mpass);
}
