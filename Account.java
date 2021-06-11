package lab14;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Account implements Serializable {
   private int currentBalance;
     private String account_no;
    public static int count;

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public Account(int currentBalance, String account_no) {
        this.currentBalance = currentBalance;
        this.account_no = account_no;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}

