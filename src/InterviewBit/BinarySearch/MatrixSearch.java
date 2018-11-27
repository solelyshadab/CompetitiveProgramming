package InterviewBit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,3,5,7));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(10,11,16,20));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(23,30,34,50));
        ArrayList<Integer> E = new ArrayList<>(Arrays.asList(52,60,67,75));
        A.add(B);A.add(C);A.add(D);A.add(E);

        System.out.println(isPresent(A,62));

    }

    public static int isPresent(ArrayList<ArrayList<Integer>> a, int b){
        if(a==null)
            return 0;
        int n = a.size(); int m = a.get(0).size();
        if(a.get(0).get(0) > b || a.get(n-1).get(m-1) < b)
            return 0;

        int l = 0; int r = n-1;
        int row = -1;
        while (l <= r){
            int mid = (l +r) /2;

            if(a.get(mid).get(0) <= b && a.get(mid).get(m-1) >=b){
                row = mid;
                break;
            }else if(a.get(mid).get(0) > b){
                r = mid -1;
            }else
                l = mid +1;
        }

        if(row == -1)
            return 0;

        ArrayList<Integer> list = a.get(row);
        l = 0; r = list.size()-1;

        while(l <=r){
            int mid = (l +r) /2;

            if(list.get(mid).equals(b))
                return 1;

            else if(list.get(mid) > b)
               r = mid -1;
            else
                l = mid +1;

        }

        return 0;
    }
}
