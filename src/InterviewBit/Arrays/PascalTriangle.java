package InterviewBit.Arrays;
import java.util.*;

public class PascalTriangle {
    public static void main(String[] args){
        PascalTriangle a = new PascalTriangle();
        ArrayList<ArrayList<Integer>> ans = a.solve(6);
        for(ArrayList<Integer> list : ans)
            System.out.println(list);
    }

    //Solution2 : Takes O ^2 times
    public ArrayList<ArrayList<Integer>> solve(int A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < A; i++){
            ArrayList<Integer> B = new ArrayList<>();
            for(int j =0; j <=i ; j++){
                if(j==0)
                    B.add(1);
                else {
                    int value = B.get(j-1) * (i-j +1) / j;
                    B.add(value);
                }
            }
            ans.add(B);
        }

        return ans;
    }

    //Solution2 : Takes O ^3 times
    public ArrayList<ArrayList<Integer>> solve1(int A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < A; i++){
            ArrayList<Integer> B = new ArrayList<>();
            for(int j =0; j <=i ; j++){
                int value = factorial(i) / (factorial(i - j) * factorial(j));
                B.add(value);
            }
            ans.add(B);
        }

    return ans;
    }

    private int factorial(int n){
        if(n<=1)
            return 1;
        return n * factorial(n-1);
    }
}
