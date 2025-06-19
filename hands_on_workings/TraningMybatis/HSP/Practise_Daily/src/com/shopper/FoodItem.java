package com.shopper;

import java.util.function.Predicate;

public class FoodItem implements Shopper{
    private String name;

    public FoodItem(String s) {
        name = s;
    }

    public static void main(String[] args) {
        Shopper.printShoppingInstructions();

         FoodItem item1 = new FoodItem("apple");
         item1.printInvoice();
    }

    @Override
    public void printInvoice() {
        System.out.println("Printing class invoice");
    }
}



