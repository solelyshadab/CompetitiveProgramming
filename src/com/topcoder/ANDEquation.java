package com.topcoder;

import java.util.ArrayList;

public class ANDEquation {

    public static void main(String[] args){
    //int[] A = {191411,256951,191411,191411,191411,256951,195507,191411,192435,191411, 191411,195511,191419,191411,256947,191415,191475,195579,191415,191411, 191483,191411,191419,191475,256947,191411,191411,191411,191419,256947, 191411,191411,191411};
    //int[] A = {1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211};
     int[] A = {2, 3, 7, 19};
        // int[] A = {1};
     ANDEquation andEquation = new ANDEquation();
    System.out.println(andEquation.restoreY(A));

    }
// MySolution, not able to identify NotPossible scenario.
//    public int restoreY(int[] A){
//        ArrayList<Integer> list = new ArrayList<>();
//        if(A.length < 2)
//            return -1;
//
//        int Y = -1;
//
//        for(int i = 0; i < A.length-1; i++){
//            Y = A[i] & A[i+1];
//            list.add(A[i]);
//            list.add(A[i+1]);
//        }
//
//        return Y;
//    }


    //Solution from TopCoder
    public int restoreY(int[] A) {
        for(int i=0; i<A.length; i++){
            int val=-1;;
            for(int j=0; j<A.length; j++){
                if(j!=i)
                    if(val==-1)
                        val=A[j];
                    else
                        val &= A[j];
            }
            if(val==A[i])
                return val;
        }

        return -1;
    }
}
