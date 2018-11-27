package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class NByThreeRepeatNumber {
    public static void main(String[] args){
        NByThreeRepeatNumber a = new NByThreeRepeatNumber();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(30, 2, 21, 30, 30, 30));
        System.out.println(a.NByTwoRepeatNumber(A));
    }

    public int solve(ArrayList<Integer> A){

        int count1 = 0; int count2 = 0;
        int first = Integer.MAX_VALUE; int second = Integer.MAX_VALUE;

        for(int i =0; i < A.size(); i++){
            if(A.get(i).equals(first)){
                count1++;
            }
            else if(A.get(i).equals(second)){
                second++;
            }
            else if(count1==0){
                first = A.get(i);
                count1++;
            }
            else if(count2 == 0){
                second = A.get(i);
                count2++;
            }else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2=0;
        for(int i = 0; i < A.size(); i++){
            if(A.get(i).equals(first))
                count1++;
            else if(A.get(i).equals(second))
                count2++;
        }

        if(count1 > A.size()/3)
            return first;
        else if (count2 > A.size()/3)
            return second;

        return -1;

    }

    public int NByTwoRepeatNumber(ArrayList<Integer> A){

        int count = 0;
        int first = Integer.MAX_VALUE;

        for(int i =0; i < A.size(); i++){
            if(A.get(i).equals(first)){
                count++;
            }else {
                count--;
            }

            if(count<=0){
                count= 0;
                first = A.get(i);
            }
        }

        count = 0;
        for(int i = 0; i < A.size(); i++){
            if(A.get(i).equals(first))
                count++;
        }

      if(count> A.size()/2)
          return first;

        return -1;

    }
}
