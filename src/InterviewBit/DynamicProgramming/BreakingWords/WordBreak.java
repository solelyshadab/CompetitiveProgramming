package InterviewBit.DynamicProgramming.BreakingWords;

import InterviewBit.DynamicProgramming.Practice.LongestCommonSubsequence;

import java.io.StringWriter;
import java.util.*;

public class WordBreak {
    public static void main(String[] args){
        WordBreak a = new WordBreak();
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("I","a","am","ace"));
        System.out.println(a.wordbreak("Iamace",dict));
    }
    // Partially correct, TLE
    public int isWord(String s, ArrayList<String> dict){
        boolean[][] memo = new boolean[s.length()][s.length()];

        for(int l =1; l <= s.length();l++){
            for(int i = 0; i < s.length()-l+1; i++){
                int j = i + l-1;
                String str = s.substring(i, j+1);
                if(dict.contains(str))
                    memo[i][j] = true;
                else{
                    for(int k = i+1; k <=j;k++){
                        if(memo[i][k-1] && memo[k][j]) {
                            memo[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        LongestCommonSubsequence.printTable(memo);
        return memo[0][s.length()-1]? 1 : 0;
    }

    // InterviewBit Solution
    static int[] dp = null;
    public int wordBreak(String a, ArrayList<String> b) {

        dp = new int[a.length()+1];

        if(b.isEmpty() || a.length()==0){
            return 0;
        }
        Arrays.fill(dp,-1);

        int res = process(a,b,0);

        return res;
    }

    public static int process(String a, ArrayList<String> b, int index){

        if(index==a.length()){
            return 1;
        }
        if(index>a.length()){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        for(String str : b){

            if(index+str.length() <= a.length()){

                String sub = a.substring(index,index+str.length());

                if(sub.equals(str)){
                    if(process(a,b,index + str.length())==1){
                        dp[index] = 1;
                        return 1;
                    }
                }
            }
        }
        dp[index] = 0;
        return 0;
    }

    // Accepted Solution
    public boolean wordbreak(String A, ArrayList<String> B){
        boolean[] memo = new boolean[A.length() + 1];
        memo[0] = true;

        for(int i = 0; i < A.length(); i++){
            if(!memo[i])
                continue;
            for(String word : B){
                int length = word.length();
                int end = i + length;
                if(end > A.length())
                    continue;
                if(memo[end])
                    continue;
                if(A.substring(i, end).equals(word))
                    memo[end] = true;
            }
        }
        return memo[A.length()];
    }



    //Tushar Roy's Solution
    public String breakWordDP(String word, Set<String> dict){
        int T[][] = new int[word.length()][word.length()];

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }

        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }

        //create space separate word from string is possible
        StringWriter sw = new StringWriter();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                sw.append(word.substring(i, j+1));
                break;
            }
            sw.append(word.substring(i,k) + " ");
            i = k;
        }

        return sw.toString();
    }
}
