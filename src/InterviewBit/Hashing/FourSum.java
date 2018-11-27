package InterviewBit.Hashing;
import java.util.*;

public class FourSum {
    public static void main(String[] args){
        FourSum a = new FourSum();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2));
        for(ArrayList<Integer> list : a.fourSum1(A, 0)){
            System.out.println(list);
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum1(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i =0; i < A.size()-1; i++){
            for(int j = i+1; j < A.size(); j++){
                int sum = A.get(i) + A.get(j);
                if(!map.containsKey(sum)){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);list.add(j);
                    map.put(sum, list );
                }else{
                    ArrayList<Integer> list = map.get(sum);
                    list.add(i); list.add(j);
                    map.put(sum, list);
                }

            }
        }

        for(int i = 0; i < A.size()-1; i++){
            for(int j = i+1; j< A.size(); j++){

                int sum = A.get(i) + A.get(j);
                int value =  B - sum;

                if(map.containsKey(value)){
                    ArrayList<Integer> list = map.get(value);

                    for(int l =0; l < list.size(); l+= 2){
                        int i2 = list.get(l);
                        int j2 = list.get(l+1);

                        if(isValidIndices(i,j, i2, j2)){
                            ArrayList<Integer> ans = new ArrayList<>();
                            ans.add(A.get(i)); ans.add(A.get(j));
                            ans.add(A.get(i2)); ans.add(A.get(j2));
                            Collections.sort(ans);
                            String string = "";
                            for(int s = 0; s < ans.size(); s++){
                                string += ans.get(s);
                            }
                            if(!set.contains(string)) {
                                ansList.add(ans);
                                set.add(string);
                            }
                        }

                    }

                }

            }
        }

        return ansList;
    }

    private boolean isValidIndices(int i1, int j1, int i2, int j2){
        return (i1 !=i2 && i1 !=j2 && j1 !=i2 && j1 != j2);
    }
    
}
