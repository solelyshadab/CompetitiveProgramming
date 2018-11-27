package InterviewBit.Backtracking;
import java.util.*;

public class GenerateAllParenthesesII {
    public static void main(String[] args){

    }
    //Solution 1: My solution, accepted..
    public ArrayList<String> generateParenthesis1(int A) {
        ArrayList<String> ansList = new ArrayList<>();
        ansList =  solution(A, new char[2*A], 0,0,0, ansList);
        return ansList;
    }

    private ArrayList<String> solution(int A, char[] str, int pos,
                                       int open, int close, ArrayList<String> ansList){
        if(pos == 2 * A){
            String ans = String.valueOf(str);
            ansList.add(ans);
            return ansList;
        }

        if(open < A){
            str[pos] = '(';
            solution(A,str, pos+1, open+1, close, ansList);

        }
        if(open > close){
            str[pos] = ')';
            solution(A,str, pos+1, open, close+1, ansList);

        }

        return ansList;
    }



    // Solution2: InterviewBit solution..
    public ArrayList<String> generateParenthesis(int a) {
        ArrayList<String> ansList = new ArrayList<>();

        char[] arr= new char[2*a];
        recurse(arr,0,0,a, ansList);
        return ansList;
    }

    public void recurse(char[] arr,int open,int close,int A, ArrayList<String> ansList) {

        int pos = open + close;
        if(pos == 2*A) {
            String s = new String(arr);
            ansList.add(s);
        }

        if(open < A) {
            arr[pos] = '(' ;
            recurse(arr,open+1,close,A , ansList);
        }
        if(close < open) {
            arr[pos] = ')';
            recurse(arr,open,close+1,A, ansList);
        }



    }

}
