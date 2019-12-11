package service.impl;


import dao.ChainDao;
import dao.impl.ChainDaoImpl;
import pojo.Chain;
import service.ChainService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChainServiceImpl implements ChainService {
    private ChainDao chainDao = new ChainDaoImpl();
    @Override
    public void addChain(Chain chain) {
        chainDao.addChain(chain);
    }
    public ArrayList<Chain> selectAllChain(){
        return chainDao.SelectAllChain();
    }

    @Override
    public void deleteChain(String id) {
        chainDao.deleteChain(id);
    }

    public Chain selectChainById(String id){
        return chainDao.selectChainById(id);
    }
    public void updateChain(String id,Timestamp ctime){
        chainDao.updateChain(id,ctime);
    }

    @Override
    public double getPrice(String seatType, String chainId) {
        return chainDao.getPrice(seatType,chainId);
    }

    @Override
    public ArrayList<Chain> selectChainByStation(String start, String end) {
        return chainDao.selectChainsByStation(start,end);
    }

    @Override
    public ArrayList<Chain> selectChainBySaT(String start, String end, String date) {
        return chainDao.selectChainsBySaT(start,end,date);
    }

}
