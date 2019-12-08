package service;

import pojo.Passenger;

public interface PassengerService {
    Passenger selectOnePassenger(String IDcard);
    void updatePassengerType(String IDcard,String type);
}
