package dao.impl;

import dao.ChainDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Chain;
import utils.C3P0Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChainDaoImpl implements ChainDao {
    private QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public void addChain(Chain chain) {
        String sql1 = "insert into chain_info(chainId,startStation,endStation,departureTime,time) values (?,?,?,?,?)";
        Object[] params = new Object[]{chain.getChainId(),chain.getStartStation(),chain.getEndStation(),chain.getDepartureTime(),chain.getTime()};
        try{
            queryRunner.update(sql1,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Chain> SelectAllChain(){
        String sql = "select * from chain_info";
        ArrayList<Chain> chainList = new ArrayList<>();
        try {
            chainList = (ArrayList<Chain>) queryRunner.query(sql, new BeanListHandler(Chain.class));
            return chainList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deleteChain(String id) {
        String sql = "delete from chain_info where chainId = ?";
        try{
            queryRunner.update(sql,id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateChain(String id, Timestamp ctime) {
        String sql = "update chain_info set departureTime = ? where chainId = ?";
        Object[] params = new Object[]{ctime,id};
        try{
            queryRunner.update(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Chain selectChainById(String id) {
        String sql = "select * from chain_info where chainId = ?";
        Chain chain = null;
        try {
            chain = queryRunner.query(sql, new BeanHandler<>(Chain.class),id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return chain;
    }

    @Override
    public double getPrice(String seatType,String chainId) {
        String sql = "select distinct price from carriage_info where carriageTypes=? and chainId =?";
        Object[] params = new Object[]{seatType,chainId};
        double price = 0;
        try{
            price = Double.parseDouble(queryRunner.query(sql, new ScalarHandler<>(),params).toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return price;
    }
}
