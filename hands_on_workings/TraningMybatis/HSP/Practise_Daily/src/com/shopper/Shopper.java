package com.shopper;

public interface Shopper {
    static void printShoppingInstructions(){
        System.out.println("Some Instructions...");
    }

    default void printInvoice(){
        System.out.println("Printing default invoice");
    }
}

