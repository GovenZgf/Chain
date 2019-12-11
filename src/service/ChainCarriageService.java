package service;

import pojo.Chain;
import pojo.ChainCarriage;

import java.util.ArrayList;
import java.util.HashMap;

public interface ChainCarriageService {
    void addChainCarriages(int num,HashMap<String,ChainCarriage> map);
    ArrayList<ChainCarriage> selectAllCarriage(String id);
    ArrayList<ChainCarriage> selectAllChainCarriage(ArrayList<Chain> chains);
    int getSeatNum(String type,String cid);
    void deleteCarriage(String cid);
    void updatePrice(HashMap<String,Double> hp,String id);
    double getSeatPrice(String cid,String type);
    void updateSeatNum(String cid,String type);
}
