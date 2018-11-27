package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumContinuousSeriesOfOnes {
    public static void main(String[] args){
        MaximumContinuousSeriesOfOnes a = new MaximumContinuousSeriesOfOnes();
        ArrayList<Integer> A = new ArrayList<>();
//        A.add(1);A.add(0);A.add(0);A.add(1);
//        A.add(1);A.add(0);A.add(1);A.add(0);A.add(1);A.add(1);A.add(1);
        A.add(0);A.add(0);A.add(0);
        System.out.println(Arrays.toString(a.solution(A, 2).toArray()));
    }

    public ArrayList<Integer> solution(ArrayList<Integer> A, int B){
        int wL =0, wR=0, bestWindow=0, bestL =0;
        int zeroCount = 0;
        while(wR < A.size()){

            if(zeroCount <= B){
                if(A.get(wR).equals(0))
                    zeroCount++;

                wR++;
            }

            if(zeroCount > B){
                if(A.get(wL).equals(0))
                    zeroCount--;

                wL++;
            }

            if(wR - wL > bestWindow){
                bestWindow = wR-wL;
                bestL = wL;
            }

        }
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i = bestL; i < bestL + bestWindow; i++){
            ansList.add(i);
        }
        return ansList;

    }
}
