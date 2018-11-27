package InterviewBit.Backtracking;
import java.util.*;

public class CombinationSumII {
    HashSet<String> set = new HashSet<>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        if(a == null || a.isEmpty())
            return ansList;

        Collections.sort(a);
        return util(a,0,b,new ArrayList<>(), new ArrayList<>());
    }

    private ArrayList<ArrayList<Integer>> util (ArrayList<Integer> a, int start, int sum,
                                                ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> ansList){
        if(sum <= 0){
            if(sum==0){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < ans.size(); i++)
                    sb.append(ans.get(i));
                if(!set.contains(sb.toString())){
                    ArrayList<Integer> temp = new ArrayList<>(ans);
                    ansList.add(temp);
                    set.add(sb.toString());
                }
            }
            return ansList;
        }

        for(int i =start; i < a.size(); i++){
            ans.add(a.get(i));
            ansList = util(a,i+1,sum - a.get(i), ans, ansList);
            ans.remove(ans.size()-1);
        }
        return ansList;
    }
}
