package InterviewBit.TwoPointers;

import java.util.*;

public class CountingTriangles {
    public static void main(String[] args){
        CountingTriangles a = new CountingTriangles();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(14,6,13,16,20,3,1,12));
        System.out.println(a.nTriang(A));
    }

    public int nTriang(ArrayList<Integer> A) {
        if(A==null || A.size() < 3)
            return 0;
        long ans = 0;
        Collections.sort(A);

        for(int i = 0; i < A.size()-2; ++i){
            int k = i+2;

            for(int j = i+1; j < A.size(); ++j){

                while(k < A.size() && A.get(i) + A.get(j) > A.get(k)){
                    ++k;
                }

                ans += k - j -1;
            }
        }

        return (int) (ans % 1000000007);
    }
}
