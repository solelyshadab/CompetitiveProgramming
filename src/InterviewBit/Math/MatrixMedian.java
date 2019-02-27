package InterviewBit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {
    public static void main(String[] args){
        MatrixMedian a = new MatrixMedian();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5,5,5));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(5,5,5));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(5,5,5));
        A.add(B); A.add(C); A.add(D);
        System.out.println("Median is: " + a.findMatrixMedian(A));
    }

    public int findMatrixMedian(ArrayList<ArrayList<Integer>> A){
        if(A==null)
            return -1;

        int n = A.size();
        if(n==0)
            return -1;

        int m = A.get(0).size();

        int lo = 0; int hi = Integer.MAX_VALUE;

        int ans = 1;

        while(lo <=hi) {
            int mid = lo + ((hi - lo) /2);

            if(isLessThanHalf(A, mid))
                lo = mid +1;
            else {
                ans = mid;
                hi = mid -1;
            }
        }

        return ans;
    }

    private boolean isLessThanHalf(ArrayList<ArrayList<Integer>> A, int num){
        int n = A.size(); int m = A.get(0).size();
        int count = 0;

        for(int i = 0; i < n; i++){
            count += getCount(A.get(i), num);
        }

        return count < (n * m) / 2 + 1;

    }

    private int getCount(ArrayList<Integer> A, int num){
        int l = 0; int r = A.size()-1;

        while(l<=r){
            int mid = l + ((r-l)/2);

             if(A.get(mid) > num)
                r = mid -1;
            else
                l = mid +1;
        }

        return l;
    }
}
