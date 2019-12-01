package dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.User;
import utils.C3P0Utils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public User findUserByUsernameAndPassword(String id, String password) {
        String sql = "select * from user_info where userId = ? and userPassword = ?";
        Object[] params = new Object[]{id,password};
        User user = null;
        try{
            user = (User) queryRunner.query(sql,new BeanHandler(User.class),params);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
