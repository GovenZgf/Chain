package dao.impl;

import dao.PassengerDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.Passenger;
import utils.C3P0Utils;

import java.sql.SQLException;

public class PassengerDaoImpl implements PassengerDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
    public Passenger selectOnePassenger(String IDcard) {
        String sql = "select * from passenger_info where passengerIDcard = ?";
        Passenger passenger = null;
        try {
                passenger = queryRunner.query(sql, new BeanHandler<>(Passenger.class),IDcard);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public void updatePassengerType(String IDcard,String type) {
        String sql = "update passenger_info set passengerType = ? where passengerIDcard = ?";
        Object[] params = new Object[]{type,IDcard};
        try{
            queryRunner.update(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
