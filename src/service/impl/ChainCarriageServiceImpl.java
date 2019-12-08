package service.impl;

import dao.CarriageDao;
import dao.impl.CarriageDaoImpl;
import pojo.Chain;
import pojo.ChainCarriage;
import service.ChainCarriageService;

import java.util.ArrayList;

public class ChainCarriageServiceImpl implements ChainCarriageService {
    CarriageDao carriageDao = new CarriageDaoImpl();
    @Override
    public void addChainCarriages(int num , ChainCarriage[] chainCarriages) {
        carriageDao.addManyCarriages(num,chainCarriages);
    }

    @Override
    public ArrayList<ChainCarriage> selectAllCarriage(String id) {
        return  carriageDao.selectChainCarriage(id);
    }

    @Override
    public ArrayList<ChainCarriage> selectAllChainCarriage(ArrayList<Chain> chains) {
        return carriageDao.selectAllChainCarriage(chains);
}

    @Override
    public int getSeatNum(String type,String cid) {
        return carriageDao.getSeatNum(type,cid);
    }

    @Override
    public void deleteCarriage(String cid) {
        carriageDao.deleteCarriage(cid);
    }

    @Override
    public void updatePrice(double one, double two, double soft, double hard, double left) {
        carriageDao.updatePrice(one, two, soft, hard, left);
    }
}
