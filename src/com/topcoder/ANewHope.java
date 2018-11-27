package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class ANewHope {
    public static void main(String[] args){
        int[] firstWeek = {1,2,3,4};
        int[] lastWeek = {4,3,2,1};
        ANewHope aNewHope = new ANewHope();
        int ans = aNewHope.count(firstWeek, lastWeek, 3);
        System.out.println(ans);
    }
// My method: Not working
//    public int count(int[] firstWeek, int[] lastWeek, int D){
//        int count = 1;
//        if(Arrays.equals(firstWeek, lastWeek))
//            return count;
//
//        int[] compare = new int[firstWeek.length];
//
//        while (!Arrays.equals(compare, lastWeek)) {
//            boolean newArray = false;
//            for (int i = 0; i < lastWeek.length; i++) {
//                for (int j = firstWeek.length-1; j >= 0; j--) {
//                    if (lastWeek[i] != firstWeek[j])
//                        continue;
//
//                    if (firstWeek.length - j + 1 < D) {
//                        if(j + D - firstWeek.length >= 0)
//                        compare[j + D - firstWeek.length] = firstWeek[j];
//                        else
//                            compare[j + D] = firstWeek[j];
//                        newArray = true;
//                        break;
//                    }
//                }
//            }
//            firstWeek = Arrays.copyOf(compare, compare.length);
//            count++;
//        }
//
//        return count;
//    }


// TopCoder Solution: https://apps.topcoder.com/wiki/display/tc/SRM+678
    int ceildiv(int p, int q)
    {
        // a way to find ceil(p,q) using only integer operations
        return (p + q - 1) / q;
    }

    int count(int[] firstWeek, int[] lastWeek, int D)
    {
        int n = firstWeek.length;
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (lastWeek[j] == firstWeek[i]) {
                    // round (i - j) / (n - D) up:
                    res = Math.max(res, ceildiv( (i - j) , (n - D) ) + 1 );
                }
            }
        }
        return res;
    }

    //TopCoder Solution: Not able to understand, look above for simpler solution.
//    public static int count(int[] firstWeek, int[] lastWeek, int d)
//    {
//        int n = firstWeek.length;
//        boolean same = true;
//        for(int i = 0; i<n; i++) same &= firstWeek[i] == lastWeek[i];
//        if(same) return 1;
//        int[] as = new int[n], bs = new int[n];
//        for(int i = 0; i<n; i++)
//        {
//            as[firstWeek[i]-1] = i;
//            bs[lastWeek[i]-1] = i;
//        }
//        int min = 0;
//        for(int i = 0; i<n; i++)
//        {
//            min = Math.min(min, bs[i] - as[i]);
//        }
//        System.out.println(min);
//
//        return (-min+(n-d-1))/(n-d)+1;
//    }


}
