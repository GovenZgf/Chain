package dao.impl;

import dao.ChainDao;
import org.apache.commons.dbutils.QueryRunner;
import pojo.Chain;
import utils.C3P0Utils;

public class ChainDaoImpl implements ChainDao {
    private QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public void addChain(Chain chain) {
        String sql1 = "insert into chain_info(chainId,startStation,endStation,departureTime,price) values (?,?,?,?,?)";
        Object[] params = new Object[]{chain.getChainId(),chain.getStartStation(),chain.getEndStation(),chain.getDepartureTime(),chain.getPrice()};
        try{
            queryRunner.update(sql1,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteChain(String id) {

    }

    @Override
    public void updateChain(String id) {

    }
}
