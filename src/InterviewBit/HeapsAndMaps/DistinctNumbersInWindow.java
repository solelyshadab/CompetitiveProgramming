package InterviewBit.HeapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public static void main(String[] args){
        DistinctNumbersInWindow a = new DistinctNumbersInWindow();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,1,3,3,7,22,25,25,25,26,26,26,26,26,26,26,26,40,40,42,42,42,61,61,61,61,61,61,61,61,63,74,74,76,81,81,81,84,84,84,86,86,86,95,95,95,95,95,95));
        System.out.println(a.solution(A, 7));

    }
    public ArrayList<Integer> solution(ArrayList<Integer> A, int B){
        ArrayList<Integer> ansList = new ArrayList<>();
        if(B > A.size())
            return ansList;

        HashMap<Integer, Integer> map = new HashMap<>();
        int i;
        for(i =0; i < B; i++){
            if(map.containsKey(A.get(i))){
                map.put(A.get(i), map.get(A.get(i)) +1 );
            }else{
                map.put(A.get(i), 1);
            }
        }
        ansList.add(map.size());
        int index = 0;
        for(; i < A.size(); i++ ){

            int removeKey = A.get(index);
            index++;
            if(map.containsKey(removeKey)){
                int value = map.get(removeKey);
                if(value ==1)
                    map.remove(removeKey);
                else
                    map.put(removeKey, value -1 );
            }
            int addKey = A.get(i);
            if(map.containsKey(addKey))
                map.put(addKey, map.get(addKey) + 1 );
            else
                map.put(addKey, 1);


            ansList.add(map.size());


        }

        return ansList;
    }
}
