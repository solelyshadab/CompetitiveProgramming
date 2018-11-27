package CourseEra.Month3.DynamicProgramming.KnapsackProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SingleSackSmallDataSet {
    private int W;
    private int N;
    private int[] valueArray;
    private int[] weightArray;
    private int[][] A;

    public static void main(String[] args){
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/KnapSack1_LargeData.txt");
        SingleSackSmallDataSet singleSackSmallDataSet = new SingleSackSmallDataSet();
        singleSackSmallDataSet.readFile(file);
        singleSackSmallDataSet.mainLoop();
        System.out.println("Optimal Solution : " + singleSackSmallDataSet.A[singleSackSmallDataSet.N][singleSackSmallDataSet.W]);
    }

    private void mainLoop(){
        A = new int[N+1][W+1];
        for(int i = 0; i<= W; i++) {
            A[0][i] = 0;
        }

        for(int i = 1; i <= N; i++){
            for(int x = 0; x <= W; x++){
                if(x>= weightArray[i])
                A[i][x] = Math.max(A[i-1][x], A[i-1][x-weightArray[i]] + valueArray[i]);
                else
                    A[i][x] = A[i-1][x];
            }
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
