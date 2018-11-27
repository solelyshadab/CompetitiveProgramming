package InterviewBit.Math.Buffer;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactors {
    public static void main(String[] args){
        PrimeFactors primeFactors = new PrimeFactors();
        System.out.println(Arrays.toString(primeFactors.primeFactors(7).toArray()));
    }

    public ArrayList<Integer> primeFactors(int A){
        ArrayList<Integer> ansList = new ArrayList<>();

        boolean[] isprime = new boolean[A+1];
        isprime[0] = false;
        isprime[1] = false;
        for(int i = 2; i < isprime.length; i++){
            isprime[i] = true;
        }

        for(int p = 2 ; p * p <= A ; p++  ){
            if(isprime[p]){
                //Update all multiples of i
                for(int i = 2*p; i <= A; i+=p ) {
                    isprime[i] = false;
                }
            }
        }

        for(int i = 0; i <= A ;i++ ){
            if(isprime[i]){
                ansList.add(i);
            }
        }

        return ansList;
    }
}
