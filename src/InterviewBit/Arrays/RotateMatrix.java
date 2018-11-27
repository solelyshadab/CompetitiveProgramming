package InterviewBit.Arrays;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args){
        RotateMatrix a = new RotateMatrix();
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}, {11, 12 , 13}};
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(a.rotateMatrix(arr)));
    }

    public int[][] rotateMatrix(int[][] arr){
        int i = arr.length;
        int j = arr[0].length;
        int[][] ansArray = new int[j][i];
        // 90 degrees anti clockwise
//        for(int a = 0 ; a < i ; a++ ){
//            for(int b = 0 ; b < j ; b++){
//                ansArray[j-1-b][a] = arr[a][b];
//            }
//        }

        // 90 degrees clockwise
        for(int a = 0 ; a < i ; a++ ){
            for(int b = 0 ; b < j ; b++){
                ansArray[b][i-1 - a] = arr[a][b];
            }
        }


        return ansArray;
    }
}
