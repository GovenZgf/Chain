package service.impl;

import dao.PassengerDao;
import dao.impl.PassengerDaoImpl;
import pojo.Passenger;
import service.PassengerService;

public class PassengerServiceImpl implements PassengerService {
    PassengerDao passengerDao = new PassengerDaoImpl();
    @Override
    public Passenger selectOnePassenger(String IDcard) {
        return passengerDao.selectOnePassenger(IDcard);
    }

    @Override
    public void updatePassengerType(String IDcard, String type) {
        passengerDao.updatePassengerType(IDcard,type);
    }
}
