package com.class2;

import java.io.Serializable;
import java.util.Scanner;

public class Task implements Serializable {
    private int ID;
    private String name;
    public Task() {
    }
    public Task(int ID, String name) {
        this.ID = ID;
        this.name = name;

    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void displayAll() {
        System.out.println("ID : " + this.ID);
        System.out.println("Name : " + this.name);

    }

    public String getName() {
        return name;
    }
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        int id=sc.nextInt();
        setID(id);
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        setName(name);

    }

}
