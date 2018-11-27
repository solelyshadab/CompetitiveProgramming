package InterviewBit.Arrays;
import java.util.*;

public class SetMatrixToZero {
    public static void main(String[] args){
        SetMatrixToZero a = new SetMatrixToZero();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(0,0,0));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(0,0,1));
        //ArrayList<Integer> D = new ArrayList<>(Arrays.asList(1,1,0));
        A.add(B);A.add(C);//A.add(D);
        for(ArrayList<Integer> list : a.solve(A))
        System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A){
        boolean[] row = new boolean[A.size()];
        boolean[] col = new boolean[A.get(0).size()];

        for(int i = 0; i < A.size(); i++){
            for(int j =0; j < A.get(0).size(); j++){
                int value = A.get(i).get(j);

                if(value == 1){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < A.size(); i++){
            for(int j =0; j < A.get(0).size(); j++){
                int value = A.get(i).get(j);

                if(value == 0 && (row[i] || col[j])){
                    ArrayList<Integer> temp = A.get(i);
                    temp.set(j, 1);
                    A.set(i, temp);
                }
            }
        }

        return A;
    }
}
