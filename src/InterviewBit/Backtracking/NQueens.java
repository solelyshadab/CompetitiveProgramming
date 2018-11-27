package InterviewBit.Backtracking;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        ArrayList<ArrayList<String>> ansList = nQueens.nQueens(4);
        int i = 1;
        for(ArrayList<String> ans : ansList){
            System.out.print("Solution :" + i++ );
            System.out.println(ans);
        }
    }

    public ArrayList<ArrayList<String>> nQueens(int A) {
        ArrayList<ArrayList<String>> ansList = new ArrayList<>();
        ansList = solution(A, 0, new int[A], ansList);
        return ansList;
    }
    //Solution: This is same as Solution1, but a little simpler to understand...
    private static ArrayList<ArrayList<String>> solution(int A, int row, int[] arr, ArrayList<ArrayList<String>> ansList) {
        if(row == A){
            ArrayList<String> ans = new ArrayList<>();
            for(int i =0; i < arr.length; i++){
                StringBuilder sb = new StringBuilder();
                int k =0;
                while (k < A){
                    if(k == arr[i]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                    k++;
                }
                ans.add(sb.toString());
            }
            ansList.add(ans);
            return ansList;
        }

        for (int i = 0; i < A; i++) {
            if(!isValidCol(arr, i, row))
                continue;
            arr[row] = i;
            solution(A,row+1, arr, ansList);
        }

        return ansList;
    }

    private static boolean isValidCol(int[] arr, int i, int row){
        for(int j =0; j < row; j++){
            int leftDiagnol = row + i;
            int rightDiagnol = row - i;
            if(i == arr[j] || j + arr[j] == leftDiagnol || j - arr[j] == rightDiagnol){
                return false;
            }
        }
        return true;
    }


    // Solution1: This works also...
    private static ArrayList<ArrayList<String>> solution1(int A, int row, int[] arr, ArrayList<ArrayList<String>> ansList) {
        if(row == A){
            ArrayList<String> ans = new ArrayList<>();
            for(int i =0; i < arr.length; i++){
                StringBuilder sb = new StringBuilder();
                int k =0;
                while (k < A){
                    if(k == arr[i]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                    k++;
                }
                ans.add(sb.toString());
            }
            ansList.add(ans);
            return ansList;
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < row; j++) {
                while(i < A) {
                    int leftDiagnol = row + i;
                    int rightDiagnol = row - i;
                    if (i == arr[j] || j + arr[j] == leftDiagnol || j - arr[j] == rightDiagnol) {
                        i++;
                        j =0;
                    }else
                        break;
                }
                if (i >= A)
                    return ansList;
            }
            arr[row] = i;
            solution(A,row+1, arr, ansList);
        }

        return ansList;
    }

}

