package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrixWithoutExtraSpace {
    public static void main(String[] args){
        RotateMatrixWithoutExtraSpace A = new RotateMatrixWithoutExtraSpace();
        //ArrayList<>
        //int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        //int[][] arr = {{1,2},{3,4}};
        //int[][] arr = {{1}};
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(3);
        c.add(4);
        a.add(b);
        a.add(c);
        //System.out.println(Arrays.deepToString(arr));
       // System.out.println(Arrays.deepToString(A.rotateMatrix(a).toArray()));
    }

    public void rotateMatrix(ArrayList<ArrayList<Integer>> a){
        int i = a.size();
        int j = a.get(0).size();
        if(i ==1)
            return;

        // 90 degrees anti clockwise
        //First transpose
//        for(int a = 0 ; a < i ; a++ ){
//            for(int b = a ; b < j ; b++){
//                int temp = arr[a][b];
//                arr[a][b] = arr[b][a];
//                arr[b][a] = temp;
//            }
//        }
//        // Now reverse each column
//        for(int a = 0; a < i ; a++ ){
//            for(int b  = 0 ; b < j/2 ; b++){
//                int temp = arr[b][a];
//                arr[b][a] = arr[i-1 -b][a];
//                arr[i-1 -b][a] = temp;
//            }
//        }

        // 90 degrees clockwise
        //First transpose
        for(int y = 0 ; y < i ; y++ ){
            for(int z = y ; z < j ; z++){
                //int temp = arr[y][z];
                int temp = a.get(y).get(z);
                //arr[y][z] = arr[z][y];
                int temp1 = a.get(z).get(y);
                a.get(y).set(z, temp1);
                //arr[z][y] = temp;
                a.get(z).set(y, temp);
            }
        }
        // Now reverse each row
        for(int y = 0; y < i/2 ; y++ ){
            for(int z  = 0 ; z < i ; z++){
                //int temp = arr[z][y];
                int temp = a.get(z).get(y);
                //arr[z][y] = arr[z][i-1-y];
                int temp1 = a.get(z).get(i-1-y);
                a.get(z).set(y, temp1);
                //arr[z][i-1-y] = temp;
                a.get(z).set(i-1-y, temp);
            }
        }

        //return a;
    }
}
