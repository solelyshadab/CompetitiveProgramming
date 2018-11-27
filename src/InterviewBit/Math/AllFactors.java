package InterviewBit.Math;
import java.util.*;

public class AllFactors {
    public static void main(String[] args){
        AllFactors a = new AllFactors();
        System.out.println(a.allFactors(6));
    }

    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i <= (int)Math.sqrt(A) ; i++){
            if(A%i == 0){
                ans.add(i);
                if(i * i != A){
                    ans.add(A/i);
                }
            }
        }
        Collections.sort(ans);
        return ans ;
    }
}
