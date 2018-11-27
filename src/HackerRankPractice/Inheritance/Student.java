package HackerRankPractice.Inheritance;

import java.util.Scanner;

public class Student extends Person {
    private int[] testScores;

    public Student(String firstName,String lastName, int id, int[] testScores ){
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    public char calculate(){
        int sum = 0;
        for(int i = 0; i< testScores.length; i++){
            sum += testScores[i];
        }
        int avg = sum / testScores.length;
        if(avg <= 100 && avg >=90)
            return 'O';
        if(avg < 90 && avg >=80)
            return 'E';
        if(avg < 80 && avg >=70)
            return 'A';
        if(avg < 70 && avg >=55)
            return 'P';
        if(avg <55 && avg >=40)
            return 'D';
        if(avg < 40)
            return 'T';
        else return 'T';
    }

    public static void main(String args[]){

            Scanner scan = new Scanner(System.in);
            String firstName = scan.next();
            String lastName = scan.next();
            int id = scan.nextInt();
            int numScores = scan.nextInt();
            int[] testScores = new int[numScores];
            for(int i = 0; i < numScores; i++){
                testScores[i] = scan.nextInt();
            }
            scan.close();

            Student s = new Student(firstName, lastName, id, testScores);
            s.test();
            s.printPerson();
            System.out.println("Grade: " + s.calculate() );
        }

}

