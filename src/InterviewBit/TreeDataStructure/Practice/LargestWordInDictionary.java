package InterviewBit.TreeDataStructure.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestWordInDictionary {
    private static Trie root = new Trie();

    public static void main(String[] args){
       List<String> dictionary = new ArrayList<>(Arrays.asList("a", "banana", "app", "appl", "ap", "apply", "apple"));
        System.out.println(longestWord(dictionary));
    }

    private static String longestWord(List<String> dictionary){


        for(int i =0; i < dictionary.size(); i++){
            addToTrie(dictionary.get(i));
        }
        String ans = "";

        for(int i = 0; i < dictionary.size(); i++){
            String word = dictionary.get(i);
            
            if (word.length() < ans.length()
                    || (word.length()== ans.length() && word.compareTo(ans) > 0))
                continue;

            if(hasAllPrefixes(word)){
               ans = word;
            }
        }
        return ans;
    }

    private static boolean hasAllPrefixes(String word){

        Trie pCrawl = root;
        int index;
        for(int i = 0; i < word.length(); i++){
            index = word.charAt(i) - 'a';

            pCrawl = pCrawl.children[index];

            if(pCrawl == null || !pCrawl.isEndOfWord)
                return false;
        }

        return true;
    }


    private static void addToTrie(String word){

        Trie pCrawl = root;
        int index;
        for(int i = 0; i < word.length(); i++){
            index = word.charAt(i) - 'a';

            if(pCrawl.children[index] == null)
            pCrawl.children[index] = new Trie();

            pCrawl = pCrawl.children[index];

        }
        pCrawl.isEndOfWord = true;
    }

    static class Trie {
        Trie[] children;
        boolean isEndOfWord;

        public Trie(){
            children = new Trie[26];
            isEndOfWord = false;
        }
    }
}
