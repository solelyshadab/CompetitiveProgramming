package com.topcoder;

import java.util.Scanner;

public class LargePieFlipper {

    public static void main(String[] args) {
        System.out.println("Main method started!");
//taking value as command line argument.
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter input String:  ");
        String inputString = in.next();
        System.out.printf("Enter Flipper value:  ");
        int K = in.nextInt();
        int ans = getNofoFlips(inputString, K);
        if(ans == -1)
            System.out.printf("\n No of flips required: " + "IMPOSSIBLE");
        else
        System.out.printf("\n No of flips required: " + ans);
    }

    private static int getNofoFlips(String input, int K){
        int N = input.length();
        char[] a = new char[N];

        for(int i=0; i<N ; i++){
            a[i] = input.charAt(i);
        }
        int cur =0;
        int noOfLoops =0;
        while(true){
            boolean isAllHappySide = true;
            for(int i=0; i<N ; i++){
                if (a[i] == '-')
                    isAllHappySide = false;
            }
            if(isAllHappySide)
                return cur;
            //return impossible once one loop is over..Need to verify this..
            if(noOfLoops > 0)
                return -1;

            for(int i=0; i < N ; i++){
                if(a[i] == '-'){
                   for(int j = i; j < i + K ; j++)
                   if(a[j] == '-')
                       a[j] = '+';
                   else a[j] = '-';

                   cur++;
                   if(i==i+K-1)
                       break;
                }
            }
            noOfLoops++;
        }

    }

}
