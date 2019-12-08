package dao;

import pojo.Chain;
import pojo.ChainCarriage;

import java.util.ArrayList;

public interface CarriageDao {
    void addCarriages(ChainCarriage chainCarriage);
    void addManyCarriages(int num ,ChainCarriage[] chainCarriages);
    ArrayList<ChainCarriage> selectChainCarriage(String id);
    ArrayList<ChainCarriage> selectAllChainCarriage(ArrayList<Chain> chains);
    void deleteCarriage(String cid);
    int getSeatNum(String type,String cid);
    void updatePrice(double one,double two,double soft,double hard,double left);
}
