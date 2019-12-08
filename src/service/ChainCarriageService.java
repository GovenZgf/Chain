package service;

import pojo.Chain;
import pojo.ChainCarriage;

import java.util.ArrayList;

public interface ChainCarriageService {
    void addChainCarriages(int num,ChainCarriage[] chainCarriages);
    ArrayList<ChainCarriage> selectAllCarriage(String id);
    ArrayList<ChainCarriage> selectAllChainCarriage(ArrayList<Chain> chains);
    int getSeatNum(String type,String cid);
    void deleteCarriage(String cid);
    void updatePrice(double one, double two, double soft, double hard, double left);
}
