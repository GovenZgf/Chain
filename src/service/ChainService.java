package service;

import pojo.Chain;
import pojo.ChainCarriage;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface ChainService {
    void addChain(Chain chain);
    ArrayList<Chain> selectAllChain();
    void deleteChain(String id);
    Chain selectChainById(String id);
    void updateChain(String id,Timestamp ctime);
    double getPrice(String seatType,String chainId);
}
