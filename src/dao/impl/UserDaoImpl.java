package dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.User;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public void updateUser(String uid) {
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

    @Override
    public ArrayList<User> selectALLUsers() {
        String sql = "select * from user_info";
        ArrayList<User> UserList = null;
        try {
                UserList = (ArrayList<User>) queryRunner.query(sql,new BeanListHandler(User.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return UserList;
    }

    @Override
    public void deleteUser(String uid) {
        String sql = "delete from user_info where userId = ?";
        try{
            queryRunner.update(sql,uid);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
