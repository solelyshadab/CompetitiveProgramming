package InterviewBit.DynamicProgramming.TwoDStringDP;
// Also known as Wildcard Pattern Matching
public class RegularExpressionMatch {
    public static void main(String[] args){
        RegularExpressionMatch a = new RegularExpressionMatch();
        a.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","a**************************************************************************************");
    }
    public int isMatch(final String A, final String B) {

        char[] string = A.toCharArray();
        char[] pattern = B.toCharArray();

        boolean isFirst = true;
        int index = 0;
        for(int i =0; i < pattern.length ; i++){
            if(pattern[i]=='*'){
                if(isFirst){
                    pattern[index++] = pattern[i];
                    isFirst = false;
                }
            }else{
                pattern[index++] = pattern[i];
                isFirst = true;
            }
        }

        boolean[][] memo = new boolean[string.length+1][index+1];
        memo[0][0] = true;
        if(index > 0 && pattern[0]=='*')
            memo[0][1] = true;

        for(int i = 1 ; i < memo.length; i++){
            for(int j =1; j < memo[0].length ; j++ ){

                if(pattern[j-1] == string[i-1] || pattern[j-1]=='?')
                    memo[i][j] = memo[i-1][j-1];

                else if(pattern[j-1] == '*')
                    memo[i][j] = memo[i-1][j] || memo[i][j-1];

            }
        }

        if(memo[string.length][index])
            return 1;
        else
            return 0;

    }
}
