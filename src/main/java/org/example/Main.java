package org.example;

import java.util.*;

public class Main{

    static int highestGrade = 0;
    static String topStudent = "";

    static int aCount = 0;
    static int bCount = 0;
    static int cCount = 0;
    static int dCount = 0;
    static int fCount = 0;

    public static char checkLetterGrade(int grade){

        char letterGrade = 'W';

        if(grade >= 90 && grade <= 100){
            letterGrade = 'A';
            aCount += 1;
        }
        else if (grade >= 80 && grade <= 89){
            letterGrade = 'B';
            bCount += 1;
        }
        else if (grade >= 70 && grade <= 79){
            letterGrade = 'C';
            cCount += 1;
        }
        else if (grade >= 60 && grade <= 69){
            letterGrade = 'D';
            dCount += 1;
        }
        else if  (grade < 60){
            letterGrade = 'F';
            fCount += 1;
        }

        return letterGrade;
    }

    public static void main(String[] args) {

        float gradeSum = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the number of students: ");
        int studentCount = scanner.nextInt();

        for (int i =0; i < studentCount; i++){

            System.out.printf("\n" + "Enter the name of student %d: ", (i + 1));
            String studentName = scanner.next(); //https://stackoverflow.com/questions/70610885/java-program-skips-over-user-input-using-the-scanner-class-and-print-statements

            System.out.printf("Enter score for " + studentName + ": ");
            int studentGrade = scanner.nextInt();
            gradeSum += studentGrade;
            if(studentGrade > highestGrade){
                highestGrade = studentGrade;
                topStudent = studentName;
            }

            System.out.printf("%s got grade: %c" + "\n", studentName, checkLetterGrade(studentGrade));

        }

        System.out.println("\n" + "----- Class Summary -----");
        System.out.printf("Average Score: %.2f", (gradeSum / studentCount));
        System.out.println("");
        System.out.printf("Grade Counts: A:%d B:%d C:%d D:%d F:%d", aCount, bCount, cCount, dCount, fCount);
        System.out.println("");
        System.out.printf("Top Student(s): %s (%d)", topStudent, highestGrade);
    }
}
