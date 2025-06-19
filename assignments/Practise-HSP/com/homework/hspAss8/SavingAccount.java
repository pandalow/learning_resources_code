package com.homework.hspAss8;

public class SavingAccount extends BankAccount {
    int count = 3;
    double rate = 0.1;

    public SavingAccount(int initialBalance) {
        super(initialBalance);
    }

    public void earnMonthlyInterest() {
        count = 3;
        super.deposit(super.getBalance() * rate);
    }




    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }


}
