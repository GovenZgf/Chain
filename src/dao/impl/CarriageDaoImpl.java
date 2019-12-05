package dao.impl;

import dao.CarriageDao;
import org.apache.commons.dbutils.QueryRunner;
import pojo.ChainCarriage;
import utils.C3P0Utils;

public class CarriageDaoImpl implements CarriageDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public void addCarriages(ChainCarriage chainCarriage) {
        String sql = "insert into carriage_info(carriageId,carriageTypes,seatNum,chainId) values (?,?,?,?)";
        Object[] params = new Object[]{chainCarriage.getCarriageId(),chainCarriage.getSeatType(),chainCarriage.getNumberOfSeat(),chainCarriage.getBelongToChain()};
        try{
            queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addManyCarriages(ChainCarriage[] chainCarriages) {
        for(ChainCarriage chainCarriage :chainCarriages){
            addCarriages(chainCarriage);
        }
    }
}
