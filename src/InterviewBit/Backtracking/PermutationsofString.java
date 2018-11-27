package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsofString {
    public static void main(String[] args){
        PermutationsofString a = new PermutationsofString();
        System.out.println(Arrays.toString(a.permutationsUtil("tpsasurl").toArray()));
    }
    public ArrayList<String> permutationsUtil(String A){
        ArrayList<String> ansList = new ArrayList<>();
        return permutations(A,ansList, 0, A.length()-1);

    }

    private static ArrayList<String> permutations(String A, ArrayList<String> ansList, int l, int r){
        if(l ==r) {
            ansList.add(A);
            return ansList;
        }else {

            for (int i = l; i <= r; i++) {
                A = swap(A, l, i);
                permutations(A, ansList, l + 1, r);
                A = swap(A, l, i);
            }
        }
        return ansList;
    }

    private static String swap(String A, int a, int b){
       StringBuilder sb = new StringBuilder(A);
       char chA = sb.charAt(a);
       char chB = sb.charAt(b);
       sb.setCharAt(a, chB);
       sb.setCharAt(b, chA);

       return sb.toString();

    }
}
