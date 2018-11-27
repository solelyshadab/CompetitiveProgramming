package InterviewBit.Math.Buffer;

import java.util.ArrayList;
import java.util.Arrays;

public class LeastPrimeFactorsOfNumbersTillN {
    public static void main(String[] args){
        LeastPrimeFactorsOfNumbersTillN a = new LeastPrimeFactorsOfNumbersTillN();
        ArrayList<Integer> ansList = a.leastPrimeFactors(12);
        for(int i = 1; i < ansList.size(); i++){
            System.out.println("Least PF of "+ i + " is: " + ansList.get(i) );
        }
    }

    public ArrayList<Integer> leastPrimeFactors(int A){
        ArrayList<Integer> ansList = new ArrayList<>();

        int[] leastFactors = new int[A+1];
        leastFactors[1] = 1;

        for(int p = 2 ; p < leastFactors.length; p++){
            if(leastFactors[p] ==0){
                for(int i = p ; i < leastFactors.length ; i += p  ){
                    if(leastFactors[i] ==0) {
                        leastFactors[i] = p;
                    }
                }
            }
        }

        for(int i = 0; i < leastFactors.length; i++){
            ansList.add(leastFactors[i]);
        }

        return ansList;
    }
}
