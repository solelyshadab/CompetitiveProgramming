package InterviewBit.TwoPointers;
import java.util.*;

public class DiffK {
    public static void main(String[] args){
        DiffK a = new DiffK();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,5,9,12));
        System.out.println(a.diffK(A,2));

    }
    // 1,3,5 K=4 , 5-1
    public int diffK(ArrayList<Integer> A , int K){

      int i = 0; int j = 0;
      while(i < A.size() && j < A.size()){
          int diff = A.get(j) - A.get(i);

          if(diff == K && i !=j){
              return 1;
          }else if(diff < K)
              j++;
          else
              i++;

      }

      return 0;
    }
}
