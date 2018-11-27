package InterviewBit.DynamicProgramming.SimpleArrayDP;

public class WaysToDecode {

    public int numDecodings(String A) {
        int[] memo = new int[A.length() +1];
        memo[0] = 1;
        memo[1] = 1;

        for(int i = 2; i < memo.length ; i++){
            if(A.charAt(i-1) !='0')
                memo[i] = memo[i-1];


            if(A.charAt(i-2) == '1' ||
                    (A.charAt(i-2) == '2' && (A.charAt(i-1) - '0') < 7) ){
                memo[i] += memo[i-2];
            }

        }

        return memo[memo.length-1];

    }
}
