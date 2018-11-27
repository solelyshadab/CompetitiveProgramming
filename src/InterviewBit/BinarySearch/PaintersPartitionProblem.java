package InterviewBit.BinarySearch;
import java.util.*;

public class PaintersPartitionProblem {
    public static void main(String[] args){
        PaintersPartitionProblem a = new PaintersPartitionProblem();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10,20,30,40));
        System.out.println(a.solve(A,2));
    }

    public int solve(ArrayList<Integer> A, int B){

        int l = max(A); int r = sum(A);

        while(l<r){

            int mid = (l+r) /2;
            int noOfPainters = noOfPaintersRequired(A,mid);

            if(noOfPainters <= B)
                r = mid;
            else
                l = mid+1;
        }

        return l;
    }

    private int noOfPaintersRequired(ArrayList<Integer> A, int unitWork){
        int count = 0; int noOfPaintersRequired =1;
        for(int i = 0 ; i < A.size(); i++){
            count += A.get(i);

            if(count > unitWork){
                count = A.get(i);
                noOfPaintersRequired++;
            }
        }

        return noOfPaintersRequired;
    }


    private int max(ArrayList<Integer> A){
        int max = A.get(0);
        for (int i =1; i < A.size(); i++)
            max = Math.max(max,A.get(i));

        return max;
    }

    private int sum(ArrayList<Integer> A){
        int sum = 0;
        for(int i =0; i < A.size(); i++)
            sum += A.get(i);

        return sum;
    }
}
