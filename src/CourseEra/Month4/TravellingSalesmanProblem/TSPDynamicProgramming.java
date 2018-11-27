package CourseEra.Month4.TravellingSalesmanProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TSPDynamicProgramming {
    private int numberOfNodes;
    private Stack<Integer> stack;
    ArrayList<int[]> subsetList;

    public TSPDynamicProgramming() {
        stack = new Stack<>();
        subsetList = new ArrayList<>();
    }

    public static void main(String[] arg) {
        int number_of_nodes;
        try (Scanner scanner = new Scanner(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/TSP_Week2Data.txt"))) {
            number_of_nodes = scanner.nextInt();

            double coordinatesArray[][] = new double[number_of_nodes + 1][2];
            for (int i = 1; i <= number_of_nodes; i++) {
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                coordinatesArray[i][0] = x;
                coordinatesArray[i][1] = y;
            }

            scanner.close();
            TSPDynamicProgramming tspDynamicProgramming = new TSPDynamicProgramming();
            double ans = tspDynamicProgramming.tsp(coordinatesArray);
            System.out.println("Min distance travelled is : " + ans);
        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong Input format");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private double tsp(double coordinatesArray[][]) {
        numberOfNodes = coordinatesArray.length - 1;
        //Array A is indexed by subset S and destination j
        double A[][] = new double[numberOfNodes + 1][numberOfNodes + 1];

        for (int i = 1; i < A.length; i++) {
            if (i == 1) {
                A[i][1] = 0;
            } else {
                A[i][1] = Integer.MAX_VALUE;
            }
        }

        // Array of vertices to give as input to getSubsetList
        int[] nodesArray = new int[numberOfNodes-1];
        for(int k = 0; k < nodesArray.length; k++)
            nodesArray[k] = k + 2;

        // m = subproblem size
        for (int m = 2; m < numberOfNodes + 1; m++) {
            // each set S of size m that contains 1
            getsubsetList(nodesArray, m);
            for (int i = 0; i < subsetList.size(); i++) {
                int setSize = subsetList.get(i).length;
//                for (int a = 0; a <setSize; a++) {
//                    double temp = Integer.MAX_VALUE;
//                    int k = subsetList.get(i)[a];
//                        if (k ==  )
//                            continue;
//
//                        double Ckj = getDistance(coordinatesArray, k,j);
//                        if (A[ - j][k] + Ckj < temp) {
//                            temp = A[i - j][k] + Ckj;
//                        }
//
//                A[i][j] = temp;
//                }
            }
        }
        double ans = Integer.MAX_VALUE;
        //find the min distance now
        for(int j = 2 ; j < numberOfNodes + 1 ; j++ ){
            double Cj1 = getDistance(coordinatesArray,j,1);
            if(A[numberOfNodes][j] + Cj1 < ans){
                ans = A[numberOfNodes][j] + Cj1;
            }
        }
     return ans;
    }

    private double getDistance(double coordinatesArray[][], int city1, int city2){
        double x1 = coordinatesArray[city1][0];
        double y1 = coordinatesArray[city1][1];
        double x2 = coordinatesArray[city2][0];
        double y2 = coordinatesArray[city2][1];
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private void getsubsetList(int[] A, int k){
        subsetList.clear();
        boolean[] usedArray = new boolean[A.length];
        subset(A, k-1, 0, 0, usedArray);

    }

    private void subset(int[] A, int k, int start, int currLen, boolean[] usedArray ) {

        if (currLen == k) {
            int[] arr = new int[k+1];
            arr[0] = 1;
            int j = 1;
            for (int i = 0; i < A.length; i++) {
                if (usedArray[i] == true) {
                    arr[j] = A[i];
                    j++;
                    System.out.print(A[i] + " ");
                }
            }
            subsetList.add(arr);
            System.out.println();
            return;
        }
        if (start == A.length) {
            return;
        }
        // For every index we have two options,
        // 1.. Either we select it, means put true in used[] and make currLen+1
        usedArray[start] = true;
        subset(A, k, start + 1, currLen + 1, usedArray);
        // 2.. OR we dont select it, means put false in used[] and dont increase
        // currLen
        usedArray[start] = false;
        subset(A, k, start + 1, currLen, usedArray);
    }
}
