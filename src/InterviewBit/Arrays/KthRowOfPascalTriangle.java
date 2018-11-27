package InterviewBit.Arrays;

import java.util.ArrayList;

public class KthRowOfPascalTriangle {
    public static void main(String[] args){
        KthRowOfPascalTriangle a = new KthRowOfPascalTriangle();
        System.out.println(a.solve(6));
    }

    public ArrayList<Integer> solve(int A){
            ArrayList<Integer> ans = new ArrayList<>();
            int i = A-1;
            for(int j =0; j <= i ; j++){
                if(j==0)
                    ans.add(1);
                else {
                    int value = ans.get(j-1) * (i-j +1) / j;
                    ans.add(value);
                }
            }

        return ans;
    }
}
