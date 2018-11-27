package InterviewBit.Hashing;
import java.util.*;

public class Anagrams {
    public static void main(String[] args){
        Anagrams a = new Anagrams();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("cat","dog", "god", "tca"));
        for(ArrayList<Integer> list : a.anagrams(A))
            System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        if(A==null || A.size() ==0)
            return ansList;

        Word[] wordArray = new Word[A.size()];

        for(int i = 0 ; i < A.size(); i++){
            char[] wordChar = A.get(i).toCharArray();
            Arrays.sort(wordChar);
            Word word = new Word(String.valueOf(wordChar), i);
            wordArray[i] = word;
        }

        Arrays.sort(wordArray, Comparator.comparing(w -> w.word));

        ArrayList<Integer> ans = new ArrayList<>();
        String w1 = wordArray[0].word;
        int index1 = wordArray[0].index;
        ans.add(index1);
        for(int i =1; i < wordArray.length ; i++ ){
            String w2 = wordArray[i].word;
            int index2 = wordArray[i].index;

            if(w1.equals(w2)){
                ans.add(index2);
            }else{
                w1 = w2;
                ansList.add(ans);
                ans = new ArrayList<>();
                ans.add(index2);
            }
        }
        ansList.add(ans);
        return ansList;

    }

    class Word{
        String word;
        int index;
        public Word(String word, int index){
            this.word = word;
            this.index = index;
        }
    }
}
