package InterviewBit.DynamicProgramming.TwoDStringDP;

public class InterLeavingStrings {
    public static void main(String[] args) {
        InterLeavingStrings a = new InterLeavingStrings();
        System.out.println(a.isInterleaving("aab","axy","aaxaby"));
    }
//s1 = "aabcc",
//s2 = "dbbca",
//s3 =aadbbcbcac(true) , aadbbbaccc(false)
    public boolean isInterleaving(String A, String B, String C) {
        int s1 = A.length();
        int s2 = B.length();
        int s3 = C.length();

        if (s1 + s2 != s3)
            return false;

        boolean[][] memo = new boolean[s1+1][s2+1];


        for(int i = 0; i <= s1; i++){
            for(int j =0; j <= s2; j++){
                if(i==0 && j ==0)
                    memo[i][j] =true;

                else if(i ==0) {
                    if (C.charAt(j - 1) == B.charAt(j - 1))
                        memo[i][j] = memo[i][j - 1];
                }

                else if(j==0) {
                    if (C.charAt(i - 1) == A.charAt(i - 1))
                        memo[i][j] = memo[i - 1][j];
                }

                else if(C.charAt(i+j-1) == A.charAt(i-1) && C.charAt(i+j-1) != B.charAt(j-1))
                    memo[i][j] = memo[i-1][j];
                else if(C.charAt(i+j-1) == B.charAt(j-1) && C.charAt(i+j-1) != A.charAt(i-1))
                    memo[i][j] = memo[i][j-1];

                else if (C.charAt(i+j-1) == A.charAt(i-1) && C.charAt(i+j-1) == B.charAt(j-1) )
                    memo[i][j] = memo[i-1][j] || memo[i][j-1];

            }
        }
        printTable(memo);

        return memo[s1][s2];
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
