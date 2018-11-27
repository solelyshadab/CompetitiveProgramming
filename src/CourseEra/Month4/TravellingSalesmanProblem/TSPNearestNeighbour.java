package CourseEra.Month4.TravellingSalesmanProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
//TODO: Added list nodeSequence to calculate the total distance travelled by the Salesman
public class TSPNearestNeighbour
{
    private int numberOfNodes;
    private Stack<Integer> stack;

    public TSPNearestNeighbour()
    {
        stack = new Stack<>();
    }

    public static void main(String[] arg)
    {
        int number_of_nodes;
        try(Scanner scanner = new Scanner(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/TSP_LargeData.txt")))
        {
            number_of_nodes = scanner.nextInt();

            double coordinatesArray[][] = new double[number_of_nodes+1][2];
            for(int i = 1; i<=number_of_nodes;i++){
                double vertice = scanner.nextDouble();
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                coordinatesArray[i][0] = x;
                coordinatesArray[i][1] = y;
            }

            scanner.close();
            System.out.println("the citys are visited as follows");
            TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
            tspNearestNeighbour.tsp(coordinatesArray);
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void tsp( double coordinatesArray[][])
    {
        numberOfNodes = coordinatesArray.length - 1;
        int[] visited = new int[numberOfNodes + 1];
        int element, nextDestination = 0, i;
        double minDistanceTravelled =0;
        double distance = 0;
        double min = Integer.MAX_VALUE;
        boolean minFlag = false;

        visited[1] = 1;
        stack.push(1);
        System.out.print(1 + "\t");

        while (stack.size() < numberOfNodes )
        {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if ( visited[i] == 0)
                {
                    double x1 = coordinatesArray[stack.peek()][0];
                    double y1 = coordinatesArray[stack.peek()][1];

                    double x2 = coordinatesArray[i][0];
                    double y2 = coordinatesArray[i][1];
                    distance = Math.sqrt((x1-x2)* (x1-x2) + (y1-y2)* (y1-y2));
                    if (min > distance)
                    {
                        min = distance;
                        nextDestination = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[nextDestination] = 1;
                minDistanceTravelled += min;
                stack.push(nextDestination);
                System.out.print(nextDestination + "\t");
                minFlag = false;
            }
        }
        //Calculate and add distance between final destination to first Node to the total distance travelled.
        double x1 = coordinatesArray[stack.peek()][0];
        double y1 = coordinatesArray[stack.peek()][1];

        double x2 = coordinatesArray[1][0];
        double y2 = coordinatesArray[1][1];
        distance = Math.sqrt((x1-x2)* (x1-x2) + (y1-y2)* (y1-y2));
        minDistanceTravelled += distance;
        System.out.print(1 + "\n");
        System.out.println("Total Distance travelled: " +(int) minDistanceTravelled);
    }

}
