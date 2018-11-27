package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.*;

public class SmallestSequenceWithGivenPrimes {
    public static void main(String[] args){
        SmallestSequenceWithGivenPrimes a = new SmallestSequenceWithGivenPrimes();
        System.out.println(a.solve(19,31,31,9));

    }

    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>() ;

        TreeSet<Integer> set = new TreeSet<>() ;
        set.add(A) ;
        set.add(B) ;
        set.add(C) ;

        for(int i = 0; i < D; i++) {
            int temp = set.first() ;
            set.remove(temp) ;
            //int temp = set.pollFirst();
            res.add(temp) ;

            set.add(temp*A) ;
            set.add(temp*B) ;
            set.add(temp*C) ;

        }
        return res ;
    }


}

