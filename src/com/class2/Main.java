package com.class2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TypeTaskManagement typeTaskManagement=new TypeTaskManagement();
        int choose;

        do {
            System.out.println("========= Task program =========");
            System.out.println("1. Add Task Type  ");
            System.out.println("2. Delete Task Type ");
            System.out.println("3. Display Task Type ");
            System.out.println("4. Write map to files  ");
            System.out.println("5. Read map from files ");
            System.out.println("6. Display Task ");
            System.out.println("7. Exit");

            System.out.println("Choose menu: ");


            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1: {
                    try {
                        Task task =new Task();
                        task.inputData();
                        typeTaskManagement.addTypeTask(task);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 2: {
                    try{
                        System.out.println("Enter Id:");
                        int  id=sc.nextInt();
                        typeTaskManagement.deleteTypeTask(id);
                        System.out.println("Delete success");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 3: {
                    try{
                        Task task =  typeTaskManagement.findTypeTaskById();
                        if( task != null) {
                            System.out.println("Found");
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 4: {
                    try {
                        typeTaskManagement.writeAllObject2FileMap();
                    } catch (Exception e ) {
                        System.out.println(e.getMessage());
                    }
                }

                break;
                case 5: {
                    try {
                      typeTaskManagement.readAllObjectFromFileMap();
                    } catch (Exception e ) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 7: {
                    return;
                }
            }
        } while(true);
    }
}
