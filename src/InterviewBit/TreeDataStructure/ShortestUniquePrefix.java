package InterviewBit.TreeDataStructure;

import java.util.*;

public class ShortestUniquePrefix {
    private static TrieNode root;
    public ShortestUniquePrefix(){
        root = new TrieNode();
    }
    public static void main(String[] args){
        ShortestUniquePrefix a = new ShortestUniquePrefix();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"));
        System.out.println(a.prefix(A));
    }


    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> ansList = new ArrayList<>();

        for(int i =0; i < A.size(); i++){
            insert(A.get(i));
        }

        for(int i =0; i < A.size();i++){
            String key = A.get(i);

            String prefix = findPrefix(key);
            ansList.add(prefix);
        }

        return ansList;
    }

    private String findPrefix(String key){
        StringBuilder ans = new StringBuilder();
        TrieNode pCrawl = root;
        int i =0;
        int index;
        while(i < key.length() ){
            index = key.charAt(i) - 'a';
            ans.append(key.charAt(i));
            pCrawl = pCrawl.children[index];
            if(pCrawl.freq ==1)
                break;
            i++;
        }

        return ans.toString();
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int freq;
        boolean isEndOfWord;

        public TrieNode(){
            for(int i =0; i < 26; i++){
                children[i] =null;
            }
            freq = 1;
            isEndOfWord = false;
        }

    }

    private void insert(String key){
        int level;
        int index;
        int length = key.length();

        TrieNode pCrawl = root;

        for(level =0; level < length; level++ ){
            index = key.charAt(level) - 'a';

            if(pCrawl.children[index]==null){
                pCrawl.children[index] = new TrieNode();
            }else{
                pCrawl.children[index].freq++;
            }

            pCrawl = pCrawl.children[index];

        }

        pCrawl.isEndOfWord = true;
    }
}
