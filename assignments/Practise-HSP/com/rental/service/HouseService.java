package com.rental.service;

import com.rental.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNumbs = 1;
    private int idCounter = 1;

    public HouseService(int size){
        houses = new House[size];
        houses[0] = new House(1,"jack","112,","Duirling",2000,"Unassigned");
    }

    public House[] list(){
        return houses;
    }

    public boolean addHouse(House house){
        if(houseNumbs == houses.length){
            House[] newHouse = new House[houses.length+1];
            for (int i = 0; i < houses.length; i++) {
                newHouse[i] = houses[i];
            }
            houses = newHouse;
            System.out.println("Array extend + 1 successfully");
        }
        houses[houseNumbs++] = house;
        house.setId(++idCounter);
        return true;
    }

    public House searchHouse(int sid){
        for (int i = 0; i < houseNumbs; i++) {
            if(sid == houses[i].getId()){
                return houses[i];
            }
        }return null;
    }
    public boolean del(int delId){
        int index = -1;
        for (int i = 0; i < houseNumbs; i++) {
            if(delId ==  houses[i].getId()){
                index = i;
            }
        }
        if(index == -1){
            return false;
        }

//        House[] newHouse = new House[houses.length-1];
//            for (int i = 0; i < houses.length - 1; i++) {
//                if(i < index){
//                    newHouse[i] = houses[i];
//                }else if (i > index){
//                    newHouse[i] = houses[i+1];
//                }
//            }

        for (int i = index; i < houseNumbs-1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNumbs] = null;
        return true;
    }

}
