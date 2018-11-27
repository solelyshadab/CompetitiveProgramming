package com.topcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountingSheep {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the no of test cases:  ");
        int T = in.nextInt();
        int[] testCases = new int[T];
        for (int i = 0; i < T ; i++) {
            System.out.printf("Enter the value of N for Case #" + (i+1) +" :  ");
            int K = in.nextInt();
            testCases[i] = K;
        }

        for(int j = 0 ; j< T ; j++) {
            int ans = getCountOfNames(testCases[j]);
            if(ans == -1)
                System.out.printf("\n Output of Case #" + (j+1) +" :  " + "INSOMNIA");
            else
                System.out.printf("\n Output of Case #" + (j+1) +" :  " + ans);
        }

    }

    private static int getCountOfNames(int K){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<10 ; i++){
            list.add(i);
        }
        if(K==0)
            return -1;

        int cur =0;
        int multiplier = 1;
        while (true){

            int L = K * multiplier;
            int N = String.valueOf(L).length();
            char[] a = new char[N];

            for(int i=0; i<N ; i++){
                a[i] = String.valueOf(L).charAt(i);
            }

            for(int i = 0 ; i<N ; i++){
                int x = Character.getNumericValue(a[i]);
                    if(list.contains(x))
                        list.remove(list.indexOf(x));
            }
            if(list.size()==0)
                return L;
            cur++;
            multiplier++;
           }

        }

    }

