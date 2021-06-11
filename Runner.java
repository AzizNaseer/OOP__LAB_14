package lab14;

import java.io.*;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        ArrayList<Account> arrayList;
        Account account= new Account(999999,"111");
        Account account1= new Account(9993499,"222");
        Account account2= new Account(9992399,"333");
        Account account3= new Account(99345999,"444");
        ATM atm= new ATM();
        atm.addAcc(new Account(99999,"111"));
        atm.addAcc(new Account(88888,"222"));
        atm.addAcc(new Account(7777,"333"));
        atm.addAcc(new Account(6666,"444"));
        System.out.println("**  Checking balance  **");
        atm.balanceInquiry();
        System.out.println("**  withdrawing money  **");
        atm.withdraw();
        System.out.println("**  Transferring money  **");
        atm.transfer();
        System.out.println("**  Depositing cash  **");
        atm.deposit();
    }
}
