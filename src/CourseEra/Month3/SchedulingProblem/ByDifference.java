package CourseEra.Month3.SchedulingProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ByDifference {
    private  static int[][] arr;
    private static int[] weightArray;
    private static int[] lengthArray;
    private static long sum;
    private static long runningLength;

    public static void main(String[] args){
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Scheduling_LargeData.txt");
        readFile(file);
        arr = SortTwoDArrayForInt.sort(arr, 0, arr[0].length-1, "x" );
        System.out.println(Arrays.deepToString(arr));
        schedule();
        System.out.println("Sum is : " + sum);
    }

    private static void schedule(){
        for(int a = arr[0].length -1; a >= 0; a--){
            int count = 0;
            int startA = a;
            while(a > 0) {
                if (arr[0][a] != arr[0][a - 1])
                break;
                else{
                    arr[0][a] = weightArray[arr[1][a]];
                    count++;
                    a--;
                }
            }
            if(count !=0){
                //for the last one which has identical value as it was not considered above
                arr[0][a] = weightArray[arr[1][a]];
                //count++;
//                if(a>0)
//                a--;
                arr = SortTwoDArrayForInt.sort(arr,startA - count , startA, "x" );
                for(int z = startA; z >= startA - count; z-- ){
                    int k = arr[1][z];
                    runningLength += lengthArray[k];
                    int x = weightArray[k];
                    long y = runningLength;
                    sum +=  x * y;
                    System.out.println("Sum so far: " + sum);
                    }
                    continue;
                }

        int k = arr[1][a];
            runningLength += lengthArray[k];
            int x = weightArray[k];
            long y = runningLength;
            sum +=  x * y;
            System.out.println("Sum so far: " + sum);
        }
    }

    private static void readFile (File file){
        try (Scanner scanner = new Scanner(file)) {
            int total = scanner.nextInt();
            arr = new int[2][total];
            lengthArray = new int[total];
            weightArray = new int[total];
            int i =0;
            while(scanner.hasNext()){

                int weight = scanner.nextInt();
                int length = scanner.nextInt();
                arr[0][i] = weight-length;
                arr[1][i] = i;
                lengthArray[i] = length;
                weightArray[i] = weight;
                i++;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}


