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

    @Override
    public void updateUser(User user) {
        String sql = "update user_info set userId=?,userPassword=?,userPhoneNum=?,userIDcard=?,userName=?";
    }
    public void saveUser(User user){
        String sql = "insert into user_info(userId,userPassword,userName,userPhoneNum) values (?,?,?,?)";
        Object[] params = new Object[]{user.getUserId(),user.getUserPassword(),user.getUserName(),user.getPhoneNumber()};
        try{
                queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
