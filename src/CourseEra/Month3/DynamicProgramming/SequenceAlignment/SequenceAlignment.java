package CourseEra.Month3.DynamicProgramming.SequenceAlignment;


public class SequenceAlignment {
    private int[][] A;
    //TODO: Answer is not correct, need to debug.
    public static void main(String[] args){
        String X = "ACGTCATCA";
        String Y = "TAGTGTCA";
        //String X = "CTTCA";
        //String Y = "CTACA";

        int PGap = -2;
        int Pxy = -1;
        
        SequenceAlignment sequenceAlignment = new SequenceAlignment();
        sequenceAlignment.mainLoop(X, Y, PGap, Pxy);

        System.out.println("Answer is: " + sequenceAlignment.A[X.length()][Y.length()]);
        sequenceAlignment.reconstruct(X, Y, PGap, Pxy);
    }

    private void reconstruct(String X, String Y, int PGap, int Pxy) {
        String X1 = "";
        String Y1 = "";
        int i = X.length();
        int j = Y.length();

        while (i > 0 && j > 0){
            int case1;
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                case1 = A[i - 1][j - 1] + 5;
            }else {
                case1 = A[i - 1][j - 1] + Pxy;
            }

        if (A[i][j] == case1) {
            X1 = Character.toString(X.charAt(i - 1)) + X1;
            Y1 = Character.toString(Y.charAt(j - 1)) + Y1;
                i--;
                j--;
            continue;
        }

        int case2 = A[i - 1][j] + PGap;
        int case3 = A[i][j - 1] + PGap;

        if (A[i][j] == case2) {
            X1 = Character.toString(X.charAt(i - 1)) + X1;
            Y1 = Character.toString('_') + Y1;
            i--;
            continue;
        }

        if (A[i][j] == case3) {
            X1 = Character.toString('_') + X1;
            Y1 = Character.toString(Y.charAt(j - 1)) + Y1;
            j--;
        }
    }

    while (i==1 && j >1){

        X1 = Character.toString('_') + X1;
        Y1 = Character.toString(Y.charAt(j - 1)) + Y1;
        j--;
    }

        while (j==1 && i >1){

            X1 = Character.toString(X.charAt(i - 1)) + X1;
            Y1 = Character.toString('_') + Y1;
            i--;
        }

        System.out.println("X1 is : " + X1);
        System.out.println("Y1 is : " + Y1);
    }

    private void mainLoop(String X, String Y, int PGap, int Pxy){
        int m = X.length();
        int n = Y.length();
        A = new int[m+1][n+1];
        A[0][0] = 0;
        for(int i = 0; i<= m; i++) {
            A[i][0] = i * PGap;
        }

        for(int i = 0; i<= n; i++) {
            A[0][i] = i * PGap;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j<=n ; j++){
                int case1;
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    case1 = A[i - 1][j - 1] + 5;
                }else {
                    case1 = A[i - 1][j - 1] + Pxy;
                }
                int case2 = A[i-1][j] + PGap;
                int case3 = A[i][j-1] + PGap;

                A[i][j] = Math.max( Math.max(case1, case2), case3);
            }
        }
        printTable(A);
    }

    private void printTable(int[][] table){
        for(int[] row : table){
            for(int value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
