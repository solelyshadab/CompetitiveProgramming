package CourseEra.Month4.TravellingSalesmanProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TSPDynamicProgrammingusingBitMask {
    private static int number_of_nodes;
    private static int VISITED_ALL;
    private static int A[][];
    public static void main(String[] args){
        TSPDynamicProgrammingusingBitMask tsp = new TSPDynamicProgrammingusingBitMask();
        double distanceArray[][] = tsp.readFile(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/TSP_Week2Data.txt"));
//        double distanceArray[][] = {
//                {0,20,42,25},
//                {20,0,30,34},
//                {42,30,0,10},
//                {25,34,10,0}
//        };
//        number_of_nodes = 4;
        number_of_nodes = distanceArray.length;

        VISITED_ALL = (1<<number_of_nodes) -1;
        int N = 1 << number_of_nodes;
        A = new int[N][number_of_nodes];

        for(int i = 0;i<(1<<number_of_nodes); i++){
            for(int j =0; j < number_of_nodes; j++){
                A[i][j] = -1;
            }
        }
        System.out.println(tsp.tsp(distanceArray, 1,0));
    }

    private int tsp(double[][] distanceArray, int mask, int pos){
        if(mask == VISITED_ALL){
            return(int) distanceArray[pos][0];
        }
        //Lookup for previous calculated ans
        if(A[mask][pos] != -1){
            return A[mask][pos];
        }

        int ans = Integer.MAX_VALUE;
        //Try to go to an unvisited city
        for(int city = 0; city < number_of_nodes; city++){
            if((mask & (1 <<city)) == 0 ){
                int newAns =(int) distanceArray[pos][city] + tsp(distanceArray, mask | (1<<city), city);
                ans = Math.min(ans, newAns);
            }
        }
    return A[mask][pos] = ans;
    }

    private double[][] readFile(File file){

        try(Scanner scanner = new Scanner(file))
        {
            number_of_nodes = scanner.nextInt();

            double coordinatesArray[][] = new double[number_of_nodes][2];
            for(int i = 0; i < number_of_nodes;i++){
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                coordinatesArray[i][0] = x;
                coordinatesArray[i][1] = y;
            }
            scanner.close();
            double distanceArray[][] = new double[number_of_nodes] [number_of_nodes];
            for(int i = 0; i < number_of_nodes; i++){
                for(int j =0; j< number_of_nodes ; j++){
                    distanceArray[i][j] = getDistance(coordinatesArray, i,j);
                }
            }
            return distanceArray;
        }
    catch (FileNotFoundException e){
            System.out.println(e);
        }
        return null;
    }

    private double getDistance(double coordinatesArray[][], int city1, int city2){
        double x1 = coordinatesArray[city1][0];
        double y1 = coordinatesArray[city1][1];
        double x2 = coordinatesArray[city2][0];
        double y2 = coordinatesArray[city2][1];
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
