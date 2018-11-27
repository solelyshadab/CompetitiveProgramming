package InterviewBit.Strings;
import java.util.*;

public class LongestCommonPrefix {
    public static void main(String[] args){
        LongestCommonPrefix a = new LongestCommonPrefix();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("a", "ab"));
        System.out.println(a.longestCommonPrefix1(A));
    }

    //Solution1: Works fine, running time of O(n * m)
    public String longestCommonPrefix(ArrayList<String> A) {
        if(A==null || A.size()==0)
            return null;
        String ans = A.get(0);
        for(int i = 1; i < A.size(); i++){
            ans = prefix(ans, A.get(i));
        }

        return ans;
    }
    // Solution2: Better running time O(s1Length * sLastLength) + nLogn for sorting
    public String longestCommonPrefix1(ArrayList<String> A) {
        if(A==null || A.size()==0)
            return null;
        Collections.sort(A);

        return prefix(A.get(0), A.get(A.size()-1));
    }

    private String prefix(String s1, String s2){
        int n = s1.length(); int m = s2.length();
        int L = Math.min(m,n);

        for(int i = 0; i < L ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0,i);
            }
        }

        return s1.substring(0,L);
    }
}
