package CourseEra.Month1;

import java.util.Arrays;

/**
 * Created by 609112524 on 17/01/2018.
 */
public class ClosestPoints {

    public static void main(String[] args){

        int arr[][] = {{5,7,0,9,3},{7,5,6,7,9}};
        int Px[][] = cloneArray(arr);
        sort(Px,0, 4, "x");
        int Py[][] = cloneArray(arr);
        sort(Py,0,4, "y");
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(Px));
        System.out.println(Arrays.deepToString(Py));
    }

    public static int[][] sort(int[][] arr,int l, int r, String sortBy){
        if(l<r){
            int m = (l+r)/2;
            sort(arr,l, m, sortBy);
            sort(arr,m+1, r, sortBy);
            merge(arr,l, m , r, sortBy);
        }
        return arr;
    }

    private static void merge(int[][] arr, int l, int m, int r,String sortBy){
         int N1 = m - l + 1;
        int N2 = r - m;

        int L[][] = new int[2][N1];
        int R[][] = new int[2][N2];

        for(int i =0; i<N1;i++){
             L[0][i] = arr[0][l+i];
             L[1][i] = arr[1][l+i];
        }

        for(int j =0; j<N2;j++){
            R[0][j] = arr[0][m+1+j];
            R[1][j] = arr[1][m+1+j];
        }

        int k =l;
        int i = 0;
        int j =0;

        while(i< N1 && j< N2){
            if(sortBy.equals("x")) {
                if (L[0][i] <= R[0][j]) {
                    arr[0][k] = L[0][i];
                    arr[1][k] = L[1][i];
                    i++;
                } else {
                    arr[0][k] = R[0][j];
                    arr[1][k] = R[1][j];
                    j++;
                }
                k++;
            }

            if(sortBy.equals("y")) {
                if (L[1][i] <= R[1][j]) {
                    arr[0][k] = L[0][i];
                    arr[1][k] = L[1][i];
                    i++;
                } else {
                    arr[0][k] = R[0][j];
                    arr[1][k] = R[1][j];
                    j++;
                }
                k++;
            }
        }

        /* Copy remaining elements of L[] if any */
        while (i < N1)
        {
            arr[0][k] = L[0][i];
            arr[1][k] = L[1][i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < N2)
        {
            arr[0][k] = R[0][j];
            arr[1][k] = R[1][j];
            j++;
            k++;
        }
    }

    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }

}





