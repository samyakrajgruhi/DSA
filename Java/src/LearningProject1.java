import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int threshold = 45;
    String name;
    int id;
    double marks;

    Student(String name,int id, double marks){
        if(marks > 100){
            System.out.println("Invalid Marks.");
            return;
        }

        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    void display(){
        System.out.print("Student Name : "+this.name);
        System.out.print("Student ID : "+this.id);
        System.out.print("Marks Scored : "+this.marks);
    }
    boolean isPassed(){
        if(this.marks >= threshold ){
            return true;
        }
        return false;
    }
    String grade(){
        if(marks >= 95){
            return "EX";
        }else if(marks >= 85) {
            return "A";
        }else if(marks >= 75){
            return "B";
        }else if(marks >= 65){
            return "C";
        }else if(marks >= 45){
            return "D";
        }else{
            return "Failed";
        }
    }
}

public class LearningProject1 {


    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Students in class :");
        int numOfStudent = sc.nextInt();
        System.out.println();
        for(int i=0;i<numOfStudent;i++){
            System.out.print("Enter Student id :");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println();
            System.out.print("Enter Student name :");
            String name = sc.nextLine();
            System.out.println();
            System.out.print("Enter marks :");
            double marks = sc.nextDouble();
            System.out.println();

            Student st = new Student(name,id,marks);
            students.add(st);
        }

        boolean exit = false;
        while(!exit){
            System.out.println("========== Welcome to Student Mgmt System ==========");
            System.out.println();
            System.out.println("0 - Exit");
            System.out.println("1 - Get all student data.");
            System.out.println("2 - Search by ID");
            System.out.println("3 - Search by Name");
            System.out.println("4 - Show grading criteria");
            
            System.out.println("Please make a choice :");
            int choice = sc.nextInt();

            switch (choice){
                case 0 :
                    exit = true;
                    break;
                case 1 :
                    System.out.println("You chose 1");
                    break;
                case 2 :
                    System.out.println("You chose 2");
                    break;
                case 3 :
                    System.out.println("You chose 3");
                    break;
                case 4 :
                    System.out.println("You chose 4");
                    break;
                default :
                    System.out.println("Invalid choice");
                    break;
            }
        }
        System.out.println("========== Shutting down ==========");
    }
}
