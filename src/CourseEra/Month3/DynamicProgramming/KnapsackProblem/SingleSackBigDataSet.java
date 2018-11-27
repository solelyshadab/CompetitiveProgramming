package CourseEra.Month3.DynamicProgramming.KnapsackProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SingleSackBigDataSet {
    private int W;
    private int N;
    private int[] valueArray;
    private int[] weightArray;
    private int[] A;
    private int[] A0;

    public static void main(String[] args){
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/KnapSack_Big_LargeData.txt");
        SingleSackBigDataSet singleSackBigDataSet = new SingleSackBigDataSet();
        singleSackBigDataSet.readFile(file);
        singleSackBigDataSet.mainLoop();
        System.out.println("Optimal Solution : " + singleSackBigDataSet.A0[singleSackBigDataSet.W]);
    }

    private void mainLoop(){
        A = new int[W+1];
        A0 = new int[W+1];
        for(int i = 0; i<= W; i++) {
            A0[i] = 0;
        }

        for(int i = 1; i <= N; i++){
            for(int x = 0; x <= W; x++){
                if(x>= weightArray[i]) {
                    int a = A0[x];
                    int b1 = A0[x - weightArray[i]];
                    int b2 =  valueArray[i];
                    int b = b1 + b2;
                    A[x] = Math.max(a, b);
                }
                else
                    A[x] = A0[x];
            }
            A0 = Arrays.copyOf(A, A.length);
        }
    }

    private void readFile(File file){
        try(Scanner scanner = new Scanner(file)){
            W = scanner.nextInt();
            N = scanner.nextInt();
            valueArray = new int[N+1];
            weightArray = new int[N+1];
            int i = 1;
            while (scanner.hasNext()){
                valueArray[i] = scanner.nextInt();
                weightArray[i] = scanner.nextInt();
                i++;
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
