package CourseEra.Month4.TwoSATProblem;

import java.io.*;
import java.util.Scanner;

public class TwoSATPapadimitrouAlgo {

    public static void main(String[] args){

        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/TwoSAT_SmallData.txt");
        TwoSATPapadimitrouAlgo twoSAT = new TwoSATPapadimitrouAlgo();
        twoSAT.readFile(file);
    }

    private void readFile(File file){
        try(Scanner scanner = new Scanner(file)){
            int total = scanner.nextInt();
            while (scanner.hasNext()){
                int value1 = scanner.nextInt();
                int value2 = scanner.nextInt();
                TwoSATPapadimitrouAlgo.X X1 = new X();
                if(value1 < 0){

                }

            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public class X{
        public int value;
        public boolean bool;
    }
}
