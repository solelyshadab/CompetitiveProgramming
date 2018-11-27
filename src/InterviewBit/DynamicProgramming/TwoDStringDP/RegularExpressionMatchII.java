package InterviewBit.DynamicProgramming.TwoDStringDP;

public class RegularExpressionMatchII {
    public static void main(String[] args){
        RegularExpressionMatchII a = new RegularExpressionMatchII();
        System.out.println(a.isMatch("ablmy","a*b.*y"));
    }

    public int isMatch(String A, String B){
        int n = A.length(); int m = B.length();
        boolean[][] memo = new boolean[n+1][m+1];

        memo[0][0] = true;
        //Deals with patterns like a* a*b* a*b*c*
        for(int j =1; j <=m; j++){
            if (B.charAt(j-1) == '*')
            memo[0][j] = memo[0][j-2];
        }


        for(int i = 1 ; i <=n; i++){
            for(int j = 1; j <=m;j++){
                if(B.charAt(j-1) == '.' || A.charAt(i-1) == B.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1];
                else if(B.charAt(j-1) == '*'){
                    boolean case1 = memo[i][j-2];

                    boolean case2 = false;
                    if(B.charAt(j-2) =='.' || A.charAt(i-1)==B.charAt(j-2))
                        case2 = memo[i-1][j];

                    memo[i][j] = case1 || case2;

                }
            }

        }
        printTable(memo);
        if(memo[n][m])return 1;
        else return 0;

    }

    private static void printTable(boolean[][] table){
        for(boolean[] row : table){
            for(boolean value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }


}
