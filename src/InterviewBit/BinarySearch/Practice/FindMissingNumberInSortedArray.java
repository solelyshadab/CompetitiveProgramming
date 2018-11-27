package InterviewBit.BinarySearch.Practice;
import java.util.*;

public class FindMissingNumberInSortedArray {
    public static void main(String[] args){
        FindMissingNumberInSortedArray a = new FindMissingNumberInSortedArray();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(a.solve(A));
    }

    public int solve(ArrayList<Integer> A){
        int mid;
        int l = 0; int r = A.size()-1;
        while(l<r){
            mid = (l+r) /2;

            if((A.get(mid) - mid) == 1)
                l = mid+1;
            else
                r = mid;
        }

        return A.get(l)-1;
    }

}
