package dao.impl;

import dao.CarriageDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Chain;
import pojo.ChainCarriage;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.ArrayList;

public class CarriageDaoImpl implements CarriageDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public void addCarriages(ChainCarriage chainCarriage) {
        String sql = "insert into carriage_info(carriageId,carriageTypes,seatNum,chainId,price) values (?,?,?,?,?)";
        Object[] params = new Object[]{chainCarriage.getCarriageId(),chainCarriage.getCarriageTypes(),chainCarriage.getSeatNum(),chainCarriage.getChainId(),chainCarriage.getPrice()};
        try{
            queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addManyCarriages(int num,ChainCarriage[] chainCarriages) {
        String id = chainCarriages[0].getChainId();
        Double priceZp = chainCarriages[3].getPrice();
        for(int i =0;i<num;i++){
            addCarriages(chainCarriages[i]);
        }
        String sql2 = "insert into carriage_info(carriageId,carriageTypes,seatNum,chainId,price) values (?,?,?,?,?)";
        Object[] params = new Object[]{String.valueOf((int)(Math.random()*100000)),"站票",80,id,priceZp};
        try{
            queryRunner.update(sql2,params);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ChainCarriage> selectChainCarriage(String id) {
        String sql = "select * from carriage_info where chainId = ?";
        ArrayList<ChainCarriage> chainCarriages = null;
        try{
                chainCarriages = (ArrayList<ChainCarriage>) queryRunner.query(sql,new BeanListHandler<>(ChainCarriage.class),id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return chainCarriages;
    }

    @Override
    public ArrayList<ChainCarriage> selectAllChainCarriage(ArrayList<Chain> chains) {
        ArrayList<ChainCarriage> lists = new ArrayList<>();
        for(Chain chain:chains){
         lists.addAll(selectChainCarriage(chain.getChainId()));
        }
        return lists;
    }

    @Override
    public void deleteCarriage(String cid) {
        String sql = "delete from carriage_info where chainId = ?";
        try{
            queryRunner.update(sql,cid);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getSeatNum(String type,String cid) {
        String sql = "select sum(seatNum) from carriage_info where carriageTypes = ? and chainId = ?";
        int num = 0;
        Object[] params = new Object[]{type,cid};
        try {
            num =  Integer.parseInt(queryRunner.query(sql,new ScalarHandler<>(),params).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public void updatePrice(double one, double two, double soft, double hard, double left) {
        String sql ="update carriage_info set price = ?";
        Object[][] params = new Object[5][];
        params[0] = new Object[]{one};
        params[1] = new Object[]{two};
        params[2] = new Object[]{soft};
        params[3] = new Object[]{hard};
        params[4] = new Object[]{left};
        try{
        queryRunner.batch(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
