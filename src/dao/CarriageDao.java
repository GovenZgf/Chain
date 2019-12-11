package dao;

import pojo.Chain;
import pojo.ChainCarriage;

import java.util.ArrayList;
import java.util.HashMap;

public interface CarriageDao {
    void addCarriages(ChainCarriage chainCarriage);
    void addManyCarriages(int num ,HashMap<String,ChainCarriage> map);
    ArrayList<ChainCarriage> selectChainCarriage(String id);
    ArrayList<ChainCarriage> selectAllChainCarriage(ArrayList<Chain> chains);
    void deleteCarriage(String cid);
    int getSeatNum(String type,String cid);
    void updatePrice(HashMap<String,Double> priceMap, String chainId);
    double getSeatPrice(String cid,String seatType);
    void updateSeatNum(String cid,String seatType);
}
