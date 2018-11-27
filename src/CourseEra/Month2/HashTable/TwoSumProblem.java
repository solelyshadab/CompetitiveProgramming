package CourseEra.Month2.HashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class TwoSumProblem {
    private static int count = 0;

    public static void main(String[] args){
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/HashFunction_LargeData.txt");
        MyHashTable myHashtable = new MyHashTable(67867967);
        LoadData(myHashtable, file);
        System.out.println("HashTable data insertion Done");
        int ans = computeTwoSum(myHashtable);
        System.out.println("Count is: " + ans);

    }

    private static int computeTwoSum(MyHashTable myHashTable){

        int t = -10;
        while (t++ <= 10){
            outerLoop:
           for(int j = 0; j < myHashTable.bucketArray.length; j++) {
               LinkedList list = myHashTable.bucketArray[j];
               for(int k = 0; k < list.size(); k++){
                   long x = (long)list.get(k);
                   long y = t - x;
                    if(myHashTable.isPresent(y) && x!=y && t<=10){
                        count++;
                       break outerLoop;

                    }
               }
           }
        }

        return count;
    }



    public static void LoadData(MyHashTable myHashTable,File file){

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()){

                long a = scanner.nextLong();
                if(!myHashTable.isPresent(a))
                myHashTable.insertData(a);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

