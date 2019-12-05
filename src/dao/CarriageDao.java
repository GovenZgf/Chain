package dao;

import pojo.ChainCarriage;

public interface CarriageDao {
    void addCarriages(ChainCarriage chainCarriage);
    void addManyCarriages(ChainCarriage[] chainCarriages);
}
