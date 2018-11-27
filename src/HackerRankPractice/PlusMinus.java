package HackerRankPractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {
    static void plusMinus(int[] arr) {
        // Complete this function
        float N = arr.length;
        float posNos = 0;
        float negNos = 0;
        float zero = 0;
        for(int i =0; i< N; i++){
            if(arr[i]> 0)
                posNos++;
            if(arr[i] <0)
                negNos++;
            if(arr[i] == 0)
                zero++;
        }
        System.out.println(posNos / N);
        System.out.println(negNos / N);
        System.out.println(zero / N);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
