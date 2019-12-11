package dao;

import pojo.Chain;
import pojo.ChainCarriage;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface ChainDao {
    void addChain(Chain chain);
    ArrayList<Chain> SelectAllChain();
    void deleteChain(String id);
    void updateChain(String id, Timestamp ctime);
    Chain selectChainById(String id);
    double getPrice(String seatType,String chainId);
    ArrayList<Chain> selectChainsByStation(String start,String end);
    ArrayList<Chain> selectChainsBySaT(String start,String end,String departureDate);
}
