package InterviewBit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchForARange {
    public static void main(String[] args){
        SearchForARange a = new SearchForARange();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
        System.out.println(a.solve(A,10));
    }
    // [5, 7, 7, 8, 8, 10], 3,4
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B){
        ArrayList<Integer> ans = new ArrayList<>();
        int left =-1; int right = -1;

        int l = 0; int r = A.size()-1;
        while(l<=r){
           int mid = (l+r) /2;
           if(A.get(mid).equals(B) && ( mid<=0 || A.get(mid) > A.get(mid-1))){
               left = mid;
               break;
           }

           else if(A.get(mid) >= B){
               r = mid-1;
           }
           else
           l = mid+1;

        }

        l = 0; r = A.size()-1;
        while(l<=r){
            int mid = (l+r) /2;
            if(A.get(mid).equals(B) && ( mid>= A.size()-1 || A.get(mid) < A.get(mid+1))){
                right = mid;
                break;
            }

            else if(A.get(mid) <= B){
                l = mid+1;
            }
            else
                r = mid-1;

        }
        ans.add(left);ans.add(right);
        return ans;
    }
}
