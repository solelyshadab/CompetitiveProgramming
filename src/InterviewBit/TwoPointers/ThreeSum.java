package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {
    public static void main(String[] args){
        ThreeSum a = new ThreeSum();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);A.add(0);A.add(5);A.add(3);A.add(2);A.add(1);
        System.out.println(a.threeSum(A, 9));
    }

    public int threeSum(ArrayList<Integer> A, int B){
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Collections.sort(A);
        for(int i =0; i < A.size()-2; i++){
            int l = i+1;
            int r = A.size()-1;
            while(l<r){
                int tempSum = A.get(i) + A.get(l) + A.get(r);
                if(tempSum - B == 0)
                    return B;

                if(Math.abs(tempSum - B) < diff) {
                    ans = tempSum;
                    diff = Math.abs(tempSum-B);
                }
                if(tempSum < B){
                    l++;
                }
                else if(tempSum > B){
                    r--;
                }
            }
        }
        return ans;
    }
}
