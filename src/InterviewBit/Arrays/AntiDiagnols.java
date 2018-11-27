package InterviewBit.Arrays;
import java.util.*;

public class AntiDiagnols {
    public static void main(String[] args){
        AntiDiagnols a = new AntiDiagnols();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(5,6,7,8));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(9,10,11,12));
        ArrayList<Integer> E = new ArrayList<>(Arrays.asList(13,14,15,16));
        A.add(B); A.add(C); A.add(D);A.add(E);
        ArrayList<ArrayList<Integer>> ans = a.solve(A);
        for(ArrayList<Integer> list : ans)
            System.out.println(list);
    }
    //1 2 3
    //4 5 6
    //7 8 9

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A){
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        int n = A.size();
        // Retrieve first half of anti diagnol elements
        for(int j =0; j < n; j++){
            ArrayList<Integer> ans = new ArrayList<>();
            int k = j;
            for(int i = 0; i <= j; i++){
                int value = A.get(i).get(k);
                ans.add(value);
                k--;
            }
            ansList.add(ans);
        }
        // Get the other half now
        for(int i = 1; i < n; i++){
            int k = i;
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j = n-1; j>=i; j--){
                int value = A.get(k).get(j);
                ans.add(value);
                k++;
            }
            ansList.add(ans);
        }

        return ansList;
    }

}
