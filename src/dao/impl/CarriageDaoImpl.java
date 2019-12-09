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
import java.util.HashMap;

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
    public void addManyCarriages(int num,HashMap<String,ChainCarriage> map) {
        if(num==8) {
                ChainCarriage firstClassCarriage = map.get("一等座");
                ChainCarriage standingCarriage = map.get("站票");
                ChainCarriage secondClassCarriage = map.get("二等座");
                ChainCarriage hardCarriage = map.get("硬卧");
                ChainCarriage softCarriage = map.get("软卧");
                addCarriages(standingCarriage);
                firstClassCarriage.setCarriageId(standingCarriage.getCarriageId()+0);
                addCarriages(firstClassCarriage);
                firstClassCarriage.setCarriageId(standingCarriage.getCarriageId()+1);
                addCarriages(firstClassCarriage);
                secondClassCarriage.setCarriageId(standingCarriage.getCarriageId()+2);
                addCarriages(secondClassCarriage);
                secondClassCarriage.setCarriageId(standingCarriage.getCarriageId()+3);
                addCarriages(secondClassCarriage);
                hardCarriage.setCarriageId(standingCarriage.getCarriageId()+4);
                addCarriages(hardCarriage);
                hardCarriage.setCarriageId(standingCarriage.getCarriageId()+5);
                addCarriages(hardCarriage);
                softCarriage.setCarriageId(standingCarriage.getCarriageId()+6);
                addCarriages(softCarriage);
                softCarriage.setCarriageId(standingCarriage.getCarriageId()+7);
                addCarriages(softCarriage);
        }else if(num == 16){
                ChainCarriage firstClassCarriage = map.get("一等座");
                ChainCarriage standingCarriage = map.get("站票");
                ChainCarriage secondClassCarriage = map.get("二等座");
                ChainCarriage hardCarriage = map.get("硬卧");
                ChainCarriage softCarriage = map.get("软卧");
                standingCarriage.setSeatNum(160);
                addCarriages(standingCarriage);

                firstClassCarriage.setCarriageId(standingCarriage.getCarriageId()+0);
                addCarriages(firstClassCarriage);

                firstClassCarriage.setCarriageId(standingCarriage.getCarriageId()+1);
                addCarriages(firstClassCarriage);

                firstClassCarriage.setCarriageId(standingCarriage.getCarriageId()+2);
                addCarriages(firstClassCarriage);

                firstClassCarriage.setCarriageId(standingCarriage.getCarriageId()+3);
                addCarriages(firstClassCarriage);

                secondClassCarriage.setCarriageId(standingCarriage.getCarriageId()+4);
                addCarriages(secondClassCarriage);

                secondClassCarriage.setCarriageId(standingCarriage.getCarriageId()+5);
                addCarriages(secondClassCarriage);

                secondClassCarriage.setCarriageId(standingCarriage.getCarriageId()+6);
                addCarriages(secondClassCarriage);

                secondClassCarriage.setCarriageId(standingCarriage.getCarriageId()+7);
                addCarriages(secondClassCarriage);

                hardCarriage.setCarriageId(standingCarriage.getCarriageId()+8);
                addCarriages(hardCarriage);

                hardCarriage.setCarriageId(standingCarriage.getCarriageId()+9);
                addCarriages(hardCarriage);

                hardCarriage.setCarriageId(standingCarriage.getCarriageId()+10);
                addCarriages(hardCarriage);

                hardCarriage.setCarriageId(standingCarriage.getCarriageId()+11);
                addCarriages(hardCarriage);

                softCarriage.setCarriageId(standingCarriage.getCarriageId()+12);
                addCarriages(softCarriage);

                softCarriage.setCarriageId(standingCarriage.getCarriageId()+13);
                addCarriages(softCarriage);

                softCarriage.setCarriageId(standingCarriage.getCarriageId()+14);
                addCarriages(softCarriage);

                softCarriage.setCarriageId(standingCarriage.getCarriageId()+15);
                addCarriages(softCarriage);
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
    public void updatePrice(HashMap<String,Double> priceMap, String chainId) {
        String sql ="update carriage_info set price = ? where chainId = ? and carriageTypes=?";
        Object[][] params = new Object[5][];
        params[0] = new Object[]{priceMap.get("一等座"),chainId,"一等座"};
        params[1] = new Object[]{priceMap.get("二等座"),chainId,"二等座"};
        params[2] = new Object[]{priceMap.get("硬卧"),chainId,"硬卧"};
        params[3] = new Object[]{priceMap.get("软卧"),chainId,"软卧"};
        params[4] = new Object[]{priceMap.get("站票"),chainId,"站票"};
        try{
        queryRunner.batch(sql,params);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
