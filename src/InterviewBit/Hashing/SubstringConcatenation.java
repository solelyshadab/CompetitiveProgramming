package InterviewBit.Hashing;

import java.util.*;

public class SubstringConcatenation {
    public static void main(String[] args){
        SubstringConcatenation a = new SubstringConcatenation();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("foo", "bar"));
        System.out.println(a.solution("barfoofoobarman",words ));

    }

    public ArrayList<Integer> solution(String A, ArrayList<String> words){
        ArrayList<Integer> ansList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int wordLength = words.get(0).length();

        for(int i =0; i < words.size(); i++){
            if(map.containsKey(words.get(i))){
                map.put(words.get(i), map.get(words.get(i)) +1 );
            }else{
                map.put(words.get(i), 1);
            }
        }

        for(int i = 0; i < wordLength ; i++){
            int count = 0; int l = i;
            HashMap<String, Integer> currMap = new HashMap<>();
            for(int j = i; j < A.length() - wordLength + 1; j += wordLength){
                String substring = A.substring(j, j + wordLength);
                if(map.containsKey(substring)){
                    if(currMap.containsKey(substring)){
                        currMap.put(substring, currMap.get(substring) + 1);
                    }else{
                        currMap.put(substring, 1);
                    }
                    count++;

                    while(currMap.get(substring) > map.get(substring)){
                        String temp = A.substring(l, l + wordLength);
                        if(currMap.containsKey(temp)){
                            currMap.put(temp, currMap.get(temp) - 1);
                            count--;
                        }
                        l = l + wordLength;
                    }
                    if(count == words.size()){
                        ansList.add(l);
                        String temp = A.substring(l, l + wordLength);
                        if(currMap.containsKey(temp)){
                            currMap.put(temp, currMap.get(temp)-1);
                            count--;
                        }
                        l = l + wordLength;
                    }
                }
                else{
                    currMap.clear();
                    count = 0;
                    l = j + wordLength;
                }

            }
        }

        return ansList;
    }

}
