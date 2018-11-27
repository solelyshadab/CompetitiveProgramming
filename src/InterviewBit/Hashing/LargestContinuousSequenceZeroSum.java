package InterviewBit.Hashing;
import java.util.*;

public class LargestContinuousSequenceZeroSum {
    public static void main(String[] args){
        LargestContinuousSequenceZeroSum a = new LargestContinuousSequenceZeroSum();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,-2,4,-4));
        System.out.println(a.lszero(A));
    }
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> ansList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int maxLength = 0; int sum = 0; int endIndex = 0; int startIndex = 0;
        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);

            if(A.get(i)==0 && maxLength ==0){
                maxLength = 1;
                startIndex = i;
                endIndex = i;
            }

            if(sum==0){
                startIndex = 0;
                maxLength = i+1;
                endIndex = i;
            }

            Integer previ = map.get(sum);

            if(previ !=null){
                if(maxLength < i - previ){
                    maxLength =  i - previ;
                    endIndex = i;
                    startIndex = previ+1;
                }
            }else{
                map.put(sum, i);
            }

        }
        if(maxLength > 0){
            for(int i = startIndex; i <= endIndex; i++){
                ansList.add(A.get(i));
            }
        }

        return ansList;
    }
}
