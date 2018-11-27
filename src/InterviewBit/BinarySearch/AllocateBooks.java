package InterviewBit.BinarySearch;
import java.util.*;

public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        if(A==null || A.size()==0 || A.size() < B )
            return -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);
        }
        int l =0; int r = sum;
        while(l<=r){
            int mid = l + ((r-l)/2);

            if(isPossible(A,mid,B)){
                min = Math.min(min, mid);
                r = mid-1;
            }else{
                l = mid+1;
            }

        }

        return min == Integer.MAX_VALUE ? -1 : min ;

    }

    private boolean isPossible(ArrayList<Integer> A, int curr_min, int B){
        int count = 0; int noOfStudents = 1;
        for(int i = 0; i < A.size(); i++){
            if( A.get(i) > curr_min)
                return false;

            count += A.get(i);

            if(count > curr_min){

                count = A.get(i);
                noOfStudents++;

                if(noOfStudents > B)
                    return false;
            }

        }
        return true;
    }

}
