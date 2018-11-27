package InterviewBit.Hashing;
import java.util.*;

public class TwoSum {
    public static void main(String[] args){
        TwoSum a = new TwoSum();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,1));
        System.out.println(a.twoSumSolution(A,2));
    }
    //Solution2: Interviewbit solution, much simpler
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < A.size(); i++){
            int curr = A.get(i);

            if (map.containsKey(B-curr)){
                int index = map.get(B-curr);
                ans.add(index);
                ans.add(i + 1);
                return ans;
            }else if (!map.containsKey(curr)){
                map.put(curr, i + 1);
            }
        }

        return ans;
    }

    // Solution1: My solution, accepted by interviewbit
    public ArrayList<Integer> twoSumSolution(final List<Integer> A, int B) {
        ArrayList<Integer> ansList = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i =0; i < A.size(); i++){
            if(map.get(A.get(i)) !=null ){
                ArrayList<Integer> list = map.get(A.get(i));
                list.add(i);
                map.put(A.get(i), list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(A.get(i), list);
            }

        }
        int index1 = Integer.MAX_VALUE;
        int index2 = Integer.MAX_VALUE;
        for(int i =0; i < A.size(); i++){
            int otherNum = B - A.get(i);

            if(map.get(otherNum) !=null) {
                ArrayList<Integer> ans = map.get(otherNum);
                for(int j = 0; j < ans.size(); j++){
                    if(i<ans.get(j) && ans.get(j) < index2){
                        index1 = i;
                        index2 = ans.get(j);
                    }else if( i < ans.get(j) && ans.get(j) == index2 && i < index1){
                        index1 = i;
                        index2 = ans.get(j);
                    }
                }

            }

        }
        if(index1 !=Integer.MAX_VALUE && index2 != Integer.MAX_VALUE) {
            ansList.add(index1 + 1);
            ansList.add(index2 + 1);
        }
        return ansList;
    }
}
