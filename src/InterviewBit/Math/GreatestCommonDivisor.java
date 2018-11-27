package InterviewBit.Math;
import java.util.*;

public class GreatestCommonDivisor {
    public static void main(String[] args){
        GreatestCommonDivisor a = new GreatestCommonDivisor();
        System.out.println(a.solve(6,9));
    }

    public int solve(int A, int B){
        int ans = 0;

        int smaller = 0; int bigger =0;
        if(A<B){
            smaller = A; bigger = B;
        }else{
            smaller = B; bigger =A;
        }

        ArrayList<Integer> factors = factors(smaller);
        Collections.sort(factors);

        for(int i = factors.size()-1; i>=0; i--){
            int factor = factors.get(i);
            if(bigger % factor==0) {
                ans = factor;
                break;
            }
        }

        return ans;

    }

    public ArrayList<Integer> factors(int A){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= (int) Math.sqrt(A); i++){
            if(A% i ==0){
                ans.add(i);
                if(i*i != A)
                    ans.add(A/i);
            }
        }

       return ans;
    }
}
