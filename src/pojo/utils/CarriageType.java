package pojo.utils;

import pojo.ChainCarriage;
import pojo.chain_info.SeatType;

import java.util.HashMap;

public class CarriageType {
    public CarriageType(){};
    public  ChainCarriage[] chainCarriages_8 = {new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage()};
    public  ChainCarriage[] chainCarriages_16 = {new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage(),new ChainCarriage()};

    public void setChainCarriages_8(String chainId,double[] price) {
        chainCarriages_8[0].setCarriageId(String.valueOf((int)(Math.random()*100000)));
        for(int i =0;i<8;i++) {
            if(i<7)
            chainCarriages_8[i+1].setCarriageId(chainCarriages_8[0].getCarriageId() + i);
            if (i < 2) {
                chainCarriages_8[i].setCarriageTypes(SeatType.一等座.getType());
                chainCarriages_8[i].setSeatNum(SeatType.一等座.getNumOfType());
            }else if(i>=2&&i<4){
                chainCarriages_8[i].setCarriageTypes(SeatType.二等座.getType());
                chainCarriages_8[i].setSeatNum(SeatType.二等座.getNumOfType());
            }else if(i>=4&&i<6){
                chainCarriages_8[i].setCarriageTypes(SeatType.硬卧.getType());
                chainCarriages_8[i].setSeatNum(SeatType.硬卧.getNumOfType());
            }else if(i>=6&&i<8){
                chainCarriages_8[i].setCarriageTypes(SeatType.软卧.getType());
                chainCarriages_8[i].setSeatNum(SeatType.软卧.getNumOfType());
            }
            chainCarriages_8[i].setChainId(chainId);
            chainCarriages_8[i].setPrice(price[i]);
        }
    }

    public void setChainCarriages_16(String chainId,double[] price){
        chainCarriages_16[0].setCarriageId(String.valueOf((int)(Math.random()*100000)));
        for(int i =0;i<16;i++) {
            if(i<15)
                chainCarriages_16[i+1].setCarriageId(chainCarriages_16[0].getCarriageId() + i);
            if (i < 4) {
                chainCarriages_16[i].setCarriageTypes(SeatType.一等座.getType());
                chainCarriages_16[i].setSeatNum(SeatType.一等座.getNumOfType());
            }else if(i>=4&&i<8){
                chainCarriages_16[i].setCarriageTypes(SeatType.二等座.getType());
                chainCarriages_16[i].setSeatNum(SeatType.二等座.getNumOfType());
            }else if(i>=8&&i<12){
                chainCarriages_16[i].setCarriageTypes(SeatType.硬卧.getType());
                chainCarriages_16[i].setSeatNum(SeatType.硬卧.getNumOfType());
            }else if(i>=12&&i<16){
                chainCarriages_16[i].setCarriageTypes(SeatType.软卧.getType());
                chainCarriages_16[i].setSeatNum(SeatType.软卧.getNumOfType());
            }
            chainCarriages_16[i].setChainId(chainId);
            chainCarriages_16[i].setPrice(price[i]);
        }
    }
}
