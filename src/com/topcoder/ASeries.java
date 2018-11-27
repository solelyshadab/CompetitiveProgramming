package com.topcoder;

import java.util.Arrays;

public class ASeries {
    public static void main(String[] args) {
        //int[] values = {3, 8, 4, 5, 6, 2, 2};
        //int[] values = {-1,-5,1,3};
        int[] values = {-20,-10,-10,-10};
        //int[] values = {-1000000,-100000, -10000, -2000, -1800,-1700,-1600,-1400,-1300, -1200,-100,100,2000,3000,5000,6000,-100,100,2000,3000,5000,6000,7000,4000,50000,70000,80000,90,60,1,50,70,  1000000};
        System.out.println(longest(values));
    }

    public static int longest(int[] values) {
        int max = 0;
        Arrays.sort(values);

        for (int a = 0; a < values.length - 1; a++) {
            for (int b = a; b < values.length; b++) {
                int range = values[b] - values[a];
                int count = 0;
                int i = a;
                int j = i+1;
                while (j < values.length) {
                    if (values[j] - values[i] == range) {

                        count++;
                        i = j;
                        j = i + 1;
                        continue;
                    }
                    j++;
                }
                if(count >=max)
                    max = count;
            }
        }

        return max+1;
    }
}
