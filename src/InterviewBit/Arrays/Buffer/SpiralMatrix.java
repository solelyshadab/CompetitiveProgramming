package InterviewBit.Arrays.Buffer;

import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args){
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
       ArrayList<Integer> a = new ArrayList<>();
       a.add(1);a.add(2);a.add(3);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(7);b.add(8);b.add(9);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(13);c.add(14);c.add(15);
        ArrayList<Integer> d = new ArrayList<>();
        d.add(16);d.add(17);d.add(18);
        A.add(a);A.add(b);A.add(c);A.add(d);
        System.out.println(Arrays.toString(spiralMatrix.spiral(A).toArray()));
        int arr[][] = { {1,  2,  3,  4,  5,  6},
                        {7,  8,  9,  10, 11, 12},
                        {13, 14, 15, 16, 17, 18}};
       //spiralPrint(3,6,arr);
    }

    // Function print matrix in spiral form
    static void spiralPrint(int n, int m, int a[][])
    {
        int i, row = 0, col = 0;
        /*  k - starting row index
        m - ending col index
        l - starting column index
        n - ending row index
        i - iterator
        */

        while (row < n && col < m)
        {
            // Print the first row from the remaining rows
            for (i = col; i < m; ++i)
            {
                System.out.print(a[row][i]+" ");
            }
            row++;
            // Print the last column from the remaining columns
            for (i = row; i < n; ++i)
            {
                System.out.print(a[i][m-1]+" ");
            }
            m--;
            // Print the last row from the remaining rows */
            if ( row < n)
            {
                for (i = m-1; i >= col; --i)
                {
                    System.out.print(a[n-1][i]+" ");
                }
                n--;
            }
            // Print the first column from the remaining columns */
            if (col < m)
            {
                for (i = n-1; i >= row; --i)
                {
                    System.out.print(a[i][col]+" ");
                }
                col++;
            }
        }
    }

    public ArrayList<Integer> spiral(ArrayList<ArrayList<Integer>> A){
        ArrayList<Integer> ansList = new ArrayList<>();

        int i = A.size();
        int j = A.get(0).size();

        int counter = 0;
        while(ansList.size() < i * j ){

        for(int k = counter; k < j - counter; k++) {
            int value = A.get(counter).get(k);
            ansList.add(value);
        }
        if(ansList.size()>= i * j)
            break;

        for(int l = counter +1; l < i - counter; l++) {
            int value = A.get(l).get(j-1-counter);
            ansList.add(value);
        }
            if(ansList.size()>= i * j)
                break;

        for(int m = j - counter-2; m >= counter; m-- ){
            int value = A.get(i-1-counter).get(m);
            ansList.add(value);
        }
            if(ansList.size()>= i * j)
                break;
        for(int n = i - counter - 2; n >= counter+1; n--){
            int value = A.get(n).get(counter);
            ansList.add(value);
        }
            if(ansList.size()>= i * j)
                break;


        counter++;
        }

        return ansList;
    }




}
