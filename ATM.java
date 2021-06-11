package lab14;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM implements Serializable{
    ArrayList<Account> arrayList;
    public ATM() { this.arrayList = new ArrayList<Account>(); }
    public void  addAcc(Account acc){
        for (Account AL:arrayList ){
            if (AL.getAccount_no().equals(acc.getAccount_no())){
                System.out.println("This account number is already exist");
                return;
            }

        }
        arrayList.add(acc);
        updateData();
    }
    public void deposit() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        String an = sc.nextLine();
        for (int i = 0; i < arrayList.size(); i++) {
            if (an.equals(arrayList.get(i).getAccount_no())) {
                System.out.println("your current balance is " + arrayList.get(i).getCurrentBalance());
                System.out.println("Enter the amount of money you want to deposit");
                int depo = sc.nextInt();
                arrayList.get(i).setCurrentBalance(arrayList.get(i).getCurrentBalance()+ depo);
                System.out.println("Now your current balance is "+arrayList.get(i).getCurrentBalance());
                updateData();
            }

        }
    }
    public void withdraw() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        String an = sc.nextLine();
        for (int i = 0; i < arrayList.size(); i++) {
            if (an.equals(arrayList.get(i).getAccount_no())){
                System.out.println("your current balance is " + arrayList.get(i).getCurrentBalance());
                System.out.println("Enter the amount of money you want to withdraw");
                int withdraw = sc.nextInt();
                arrayList.get(i).setCurrentBalance(arrayList.get(i).getCurrentBalance() - withdraw);
                System.out.println("Now your current balance is "+arrayList.get(i).getCurrentBalance());
                updateData();
            }
        }
    }
    public void balanceInquiry() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        String an = sc.nextLine();
        for (int i = 0; i < arrayList.size(); i++) {
            if (an.equals(arrayList.get(i).getAccount_no())) {
                System.out.println("your current balance is " + arrayList.get(i).getCurrentBalance());
            }
        }
    }

    public void transfer() {
        System.out.println("Enter the account number");
        Scanner sc = new Scanner(System.in);
        String to= sc.nextLine();
        System.out.println("enter account number to which you want to transfer money");
        Scanner sc1 = new Scanner(System.in);
        String from=sc1.nextLine(); int t=-1,f=-1,x=0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (to.equals(arrayList.get(i).getAccount_no())) {
                System.out.println("your current balance is " + arrayList.get(i).getCurrentBalance());
                t=i;
            }
             if (from.equals(arrayList.get(i).getAccount_no())){
                System.out.println("Enter the amount you want to transfer");
                x= sc.nextInt();
                f=i;
            }
        }
        if(t!=-1 && f!=-1 && arrayList.get(t).getCurrentBalance()>=x)
        {
            arrayList.get(t).setCurrentBalance(arrayList.get(t).getCurrentBalance()-x);
            arrayList.get(f).setCurrentBalance(arrayList.get(f).getCurrentBalance()-x);
            System.out.println("Amount is transfer");
            updateData();
        }
        else {
            System.out.println("Not enough money");
        }
    }
    private void updateData() {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Data.txt"));
            oos.writeObject(arrayList);
        } catch (IOException e) {
            System.out.println("Fail to save data due to "+e);
        }
    }
    public void saveData() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.txt"));
                this.arrayList= (ArrayList<Account>) ois.readObject();
            }catch (IOException | ClassNotFoundException e) {
                this.arrayList= new ArrayList<Account>();
        }
        }
    }

