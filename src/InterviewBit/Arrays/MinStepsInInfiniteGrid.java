package InterviewBit.Arrays;

import java.util.*;


public class MinStepsInInfiniteGrid {

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(-3); A.add(0);A.add(3);
        B.add(-3); B.add(4);B.add(3);
        System.out.println(coverPoints(A,B));

    }

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 0;

        for(int i = 0; i < A.size()-1; i++){
            int x1 = A.get(i);
            int y1 = B.get(i);
            int x2 = A.get(i+1);
            int y2 = B.get(i+1);

            int x = Math.abs(x2 - x1);
            int y = Math.abs(y2 - y1);

            if(x==y) {
                ans += x;
            }
            else if(x > y){
                ans += x;
            }
            else {
                ans += y;
            }

        }
        return ans;
    }
}
