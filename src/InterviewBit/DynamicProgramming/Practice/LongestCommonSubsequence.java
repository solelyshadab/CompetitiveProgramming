package InterviewBit.DynamicProgramming.Practice;

public class LongestCommonSubsequence {
    public static void main(String[] args){
        LongestCommonSubsequence a = new LongestCommonSubsequence();
        System.out.println(a.lcs("AGGTAB", "GXTXAYB"));
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

    }

    public int lcs(String A, String B){
        int m = A.length(), n = B.length();
        int[][] lcs = new int[m+1][n+1];

        for(int i = 0; i <=m; i++){
            for(int j =0; j <=n; j++){
                if(i==0 || j ==0)
                    lcs[i][j] = 0;

                else if (A.charAt(i-1) == B.charAt(j-1))
                    lcs[i][j]= lcs[i-1][j-1] + 1;

                else{
                    int case1 = lcs[i-1][j];
                    int case2 = lcs[i][j-1];

                    lcs[i][j] = Math.max(case1,case2);

                }

            }
        }

        printTable(lcs);

return lcs[m][n];

    }

    public static void printTable(boolean[][] table){
        for(boolean[] row : table){
            for(boolean value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void printTable(int[][] table){
        for(int[] row : table){
            for(int value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

}
