package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.*;

public class WordLadderI {
    public static void main(String[] args){
        WordLadderI a = new WordLadderI();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"));
        System.out.println(a.ladderLength("TOON","PLEA",A));
    }

    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        queue.add(start);
        map.put(start,1);

        while(!queue.isEmpty()){
            String word = queue.poll();

            for(int i =0; i < dictV.size(); i++){
                String temp = dictV.get(i);

                if(isDiffOne(word, temp)){
                    if(temp.equals(end))
                        return map.get(word)+1;

                    map.put(temp, map.get(word) + 1);
                    queue.add(temp);
                    dictV.remove(temp);
                }
            }
        }

        return 0;

    }

    private static boolean isDiffOne(String A, String B){
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i)!= B.charAt(i))
                count++;

            if(count>1)
                return false;
        }

        return true;
    }



}
