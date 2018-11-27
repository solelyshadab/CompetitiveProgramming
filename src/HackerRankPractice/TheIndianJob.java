package HackerRankPractice;

import java.io.*;
import java.util.*;

public class TheIndianJob {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String result[] = new String[T];
        for(int i = 0; i < T ; i++){
            int N = scanner.nextInt();
            int G = scanner.nextInt();
            int arr[] = new int[N];
            for(int j = 0; j< N; j++){
                arr[j] = scanner.nextInt();
            }
            if(isPossible(arr, G))
                result[i] ="YES" ;
            else
                result[i] ="NO";
        }
        for(int t =0; t< T; t++){
            System.out.println(result[t]);
        }
    }

    private static boolean isPossible(int[] arr, int G){
        int  remainingTimeSlot1 = G;
        int remainingTimeSlot2 = G;
        for(int i = 0; i < arr.length; i++){
           if(remainingTimeSlot1 > remainingTimeSlot2)
               remainingTimeSlot1 -= arr[i];
           else
               remainingTimeSlot2 -= arr[i];

           if(remainingTimeSlot1 < 0 || remainingTimeSlot2 <0)
            return false;


        }
        return true;

    }
}

