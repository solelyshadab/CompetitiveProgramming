package InterviewBit.DynamicProgramming.GreedyOrDP;

import java.util.ArrayList;
import java.util.Arrays;

public class JumpGameArray {
    public static void main(String[] args){
        JumpGameArray a = new JumpGameArray();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3,1,1,4));
        System.out.println(a.isPossible(A));
    }

    public int isPossible(ArrayList<Integer> A){
        int counter = 0;

        for(int i = 0 ; i < A.size(); i++){
            counter--;

            int value = A.get(i);
            if(value > counter)
            counter = value;
            if(counter <= 0 && i != A.size()-1)
                return -1;
        }

            return 1;


    }
}
