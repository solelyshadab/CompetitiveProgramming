package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.*;

public class ValidPath {
    public static void main(String[] args) {
        ValidPath a = new ValidPath();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3,3));

        System.out.println(a.isPath(A,B,1,5,5));
    }


    public int isPath(ArrayList<Integer> E, ArrayList<Integer> F, int D, int A, int B) {
        int[][] table = new int[A][B];

        table = fillTable(table,E,F,D);
        if(table[0][0] == -1 || table[A-1][B-1]==-1)
            return 0;

        Queue<int[]> q = new LinkedList<>();
        int[] arr = {0,0};
        table[0][0] = 1;
        q.add(arr);

        while (!q.isEmpty()){
            int[] point = q.poll();

            if(point[0] -1 >= 0 && point[1]- 1 >=0 && table[point[0] -1][point[1]-1] == 0) {
                table[point[0] - 1][point[1]-1] = 1;
                int[] point1 = {point[0] -1, point[1]-1};
                q.add(point1);
            }
            if(point[0] + 1 < A && point[1] + 1 < B && table[point[0] + 1][point[1]+ 1] == 0) {
                table[point[0] + 1][point[1] + 1] = 1;
                int[] point1 = {point[0] + 1, point[1] + 1};
                q.add(point1);
            }
            if(point[0] - 1 >=0 && point[1] + 1 < B && table[point[0] - 1][point[1] + 1] == 0) {
                table[point[0] - 1][point[1] + 1] = 1;
                int[] point1 = {point[0] - 1, point[1] + 1};
                q.add(point1);
            }
            if(point[0] + 1 < A && point[1] - 1 >= 0 && table[point[0] + 1][point[1]- 1] == 0) {
                table[point[0] + 1][point[1] - 1] = 1;
                int[] point1 = {point[0] + 1, point[1] - 1};
                q.add(point1);
            }
            if(point[1] - 1 >= 0 && table[point[0]][point[1]- 1] == 0) {
                table[point[0]][point[1] - 1] = 1;
                int[] point1 = {point[0], point[1] - 1};
                q.add(point1);
            }
            if(point[1] + 1 <B && table[point[0]][point[1] + 1] == 0) {
                table[point[0]][point[1] + 1] = 1;
                int[] point1 = {point[0], point[1] + 1};
                q.add(point1);
            }
            if(point[0] + 1 < A && table[point[0] + 1][point[1]] == 0) {
                table[point[0] + 1][point[1]] = 1;
                int[] point1 = {point[0] + 1, point[1]};
                q.add(point1);
            }
            if(point[0] - 1 >= 0 && table[point[0] - 1][point[1]] == 0) {
                table[point[0] - 1][point[1]] = 1;
                int[] point1 = {point[0] - 1, point[1]};
                q.add(point1);
            }

        }

        return table[A - 1][B - 1] == 1 ? 1 : 0;
    }

    private static int[][] fillTable(int[][] table,ArrayList<Integer> x, ArrayList<Integer> y, int r ){

        for(int i =0; i < table.length; i++){
            for(int j = 0; j < table[0].length;j++){

                for(int k = 0; k < x.size(); k++){
                    int x1 = x.get(k)-1;
                    int y1 = y.get(k)-1;

                    int xD = Math.abs(x1-i);
                    int yD = Math.abs(y1-j);

                    double dist = Math.sqrt((xD*xD) + (yD*yD));

                    if(dist <= r)
                        table[i][j] = -1;
                }

            }
        }

        return table;
    }
}
