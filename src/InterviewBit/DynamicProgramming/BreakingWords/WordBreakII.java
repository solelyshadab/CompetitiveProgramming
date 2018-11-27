package InterviewBit.DynamicProgramming.BreakingWords;

import java.util.*;

public class WordBreakII {
    public static void main(String args[]){
        String[] words = {"mobile","samsung","sam","sung",
                "man","mango", "icecream","and",
                "go","i","love","ice","cream"};

        HashSet<String> dict = new HashSet<String>();
        for(String w: words)
            dict.add(w);

        String str1 = "iloveicecreamandmango";
        //ALLwordBreakTopDown(str1, dict);

        String str2 = "ilovesamsungmobile";
        //ALLwordBreakTopDown(str2, dict);

        String str3 = "iloveyou";
        ALLwordBreakTopDown(str3, dict);

    }
    //Solution 1: Correct answer
    static void ALLwordBreakTopDown(String s, Set<String> wordDict) {
        Map<Integer, ArrayList<String>> dp = new HashMap<>();
        int max = 0;
        /* Max length is calculated to save computation later*/
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        /* The result is obtained as an Arraylist of strings, print the answers */
        for(String ans : ALLwordBreakREC(s, wordDict, dp, 0, max)){
            System.out.println(ans);
        }
        System.out.println();
    }


    static ArrayList<String> ALLwordBreakREC(String s, Set<String> wordDict, Map<Integer, ArrayList<String>> dp, int start, int max) {
        if(start == s.length()){
            /* If last word, send back a list of one empty word  */
            ArrayList<String> x = new ArrayList<>();
            x.add("");
            return x;
        }
        /* Send the memo if already computed for this position*/
        if(dp.containsKey(start)){

            return dp.get(start);
        }

        ArrayList<String> words = new ArrayList<>();
        /* Only check till max length from a certain start position.*/
        for(int i = start ; i< start + max && i < s.length(); i++){
            String newWord = s.substring(start, i+1);
            /* Find the first word from start that belongs in the dictionary,
             and recursively search from the next index as a start point*/
            if(!wordDict.contains(newWord))
                continue;

            /* returns the various methods possible to break the further string */
            ArrayList<String> result = ALLwordBreakREC(s, wordDict, dp, i+1, max);

            for(String word : result){
                /* to each of the brought in strings(methods), we adjoin our newWord as a prefix */
                String space = word.length()==0 ? "" : " ";

                words.add(newWord + space + word);
            }
        }
        dp.put(start, words);
        return words;
    }
}
