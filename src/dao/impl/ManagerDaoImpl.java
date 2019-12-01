package dao.impl;

import dao.ManagerDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.Manager;
import utils.C3P0Utils;

public class ManagerDaoImpl implements ManagerDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public Manager findManagerByIdAndPassword(String id,String pass) {
        String sql = "select * from manage_info where managerId = ? and managerPass = ?" ;
        Object[] params = new Object[]{id,pass};
        Manager manager = null;
        try{
            manager = (Manager)queryRunner.query(sql,new BeanHandler(Manager.class),params);
        }catch(Exception e){
            e.printStackTrace();
        }
         return manager;
    }
}
