package dao;

import pojo.Chain;
import pojo.ChainCarriage;

public interface ChainDao {
    void addChain(Chain chain);
    void deleteChain(String id);
    void updateChain(String id);
}
