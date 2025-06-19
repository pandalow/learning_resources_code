package com.rental.view;

import com.rental.domain.House;
import com.rental.service.HouseService;
import com.rental.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key;

    private HouseService houseService = new HouseService(2);

    public void listHouses() {
        System.out.println("=============House list=============");
        System.out.println("id\t\tname\t\tphone\t\taddress\t\trent\t\tstate");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                System.out.println("no House exists");
            } else {
                System.out.println(houses[i]);
            }
        }
    }

    public void updateHouse() {
        System.out.println("Please ensure your modify ID: ");
        int updateID = Utility.readInt();
        if (updateID == -1) {
            System.out.println("Give up");
            return;
        }
        // 返回引用类型，所以set就会影响到后面的house数组元素；
        House house = houseService.searchHouse(updateID);
        System.out.println("Name(" + house.getName() + "):");
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.println("Name(" + house.getPhone() + "):");
        String phone = Utility.readString(8, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.println("Name(" + house.getAddress() + "):");
        String address = Utility.readString(8, "");
        if (!"".equals(address)) {
            house.setName(address);
        }
        System.out.println("Name(" + house.getCost() + "):");
        int rental = Utility.readInt(-1);
        if (rental != -1) {
            house.setCost(rental);
        }
        System.out.println("Name(" + house.getState() + "):");
        String state = Utility.readString(5, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("Modify successfully");
    }

    public void deleteHouse() {
        System.out.println("=============Delete House=============");
        System.out.println("Please Enter the house number(-1 exit)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("You give up");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("Delete successfully");
            } else {
                System.out.println("Delete failure");
            }
        } else {
            System.out.println("You give up");
        }
    }

    public void exit() {
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {
            loop = false;
        }
    }

    public void addHouse() {
        System.out.println("=============Add House=============");
        System.out.println("Name:");
        String name = Utility.readString(8);
        System.out.println("Phone:");
        String phone = Utility.readString(12);
        System.out.println("Address");
        String address = Utility.readString(16);
        System.out.println("Rental:");
        int rent = Utility.readInt();
        System.out.println("State:");
        String state = Utility.readString(6);

        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.addHouse(newHouse)) {
            System.out.println("add success");
        } else {
            System.out.println("add failure");
        }
    }

    public void search() {
        System.out.println("Please Enter your id:");
        int sid = Utility.readInt();
        House house = houseService.searchHouse(sid);
        if (house == null) {
            System.out.println("Nothing find");
        } else {
            System.out.println(house);
        }

    }

    public void mainMenu() {

        do {
            System.out.println("============System=============");
            System.out.println("\t\t\t1.Add house");
            System.out.println("\t\t\t2.Search house");
            System.out.println("\t\t\t3.Delete house");
            System.out.println("\t\t\t4.Modify house information");
            System.out.println("\t\t\t5.Display list");
            System.out.println("\t\t\t6.Quit");

            System.out.println("Enter your choice");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    search();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }

        } while (loop);
    }
}
