package service.impl;


import dao.ChainDao;
import dao.impl.ChainDaoImpl;
import pojo.Chain;
import service.ChainService;

public class ChainServiceImpl implements ChainService {
    private ChainDao chainDao = new ChainDaoImpl();
    @Override
    public void addChain(Chain chain) {
        chainDao.addChain(chain);
    }
}
