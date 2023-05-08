package com.class2;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class TypeTaskManagement {
    HashMap<Integer, Task> mapTask;

    public TypeTaskManagement() {
        mapTask= new HashMap<>();
        this.readAllObjectFromFileMap();

    }
    public boolean addTypeTask(Task task) throws Exception {

        if(this.mapTask.containsKey(task.getID())) {
            throw new Exception("Task existing");
        }
        this.mapTask.put(task.getID(), task);

        return true;
    }
    Task findTypeTaskById() {
        System.out.print("Enter id to find: ");
        Scanner input = new Scanner(System.in);
        int findId = input.nextInt();
        for (Task item : mapTask.values()) {
            if (findId == item.getID()) {
                item.displayAll();
                return item;
            }
        }
        return null;
    }
    public void deleteTypeTask(int id) throws Exception{
        if (mapTask == null) {
            throw new Exception("Database doesn't exist");
        }
        if (!mapTask.containsKey(id)) {
            throw new Exception("Task doesn't exist");
        }
        this.mapTask.remove(id).getID();
    }
    public void writeAllObject2FileMap() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("map", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this.mapTask);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void readAllObjectFromFileMap() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("map");
            ois = new ObjectInputStream(fis);

            this.mapTask = (HashMap<Integer, Task>) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(ois != null )
                    ois.close();
                if(fis != null)
                    fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
