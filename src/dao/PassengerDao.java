package dao;

import pojo.Passenger;

public interface PassengerDao {
    Passenger selectOnePassenger(String IDcard);
    void updatePassengerType(String IDcard,String type);
}
