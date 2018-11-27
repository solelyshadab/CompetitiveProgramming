package InterviewBit.TreeDataStructure;

import java.lang.reflect.Array;
import java.util.*;

public class HotelReviews {
    public static void main(String[] args){
        HotelReviews a = new HotelReviews();
        String A = "cool_ice_wifi";
        ArrayList<String> B = new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
        ArrayList<Integer> result = a.solve(A,B);
        System.out.println(result);
    }

    private static TrieNode root;

    public HotelReviews(){
        root = new TrieNode();
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        ArrayList<Reviews> ansList = new ArrayList<>();

        for(String word : A.split("_")){
            insert(word);
        }

        for(int i =0 ; i < B.size() ; i++){
            Reviews review = new Reviews();
            for(String reviewWord : B.get(i).split("_")){

                if(search(reviewWord))
                    review.count++;

            }
            review.index = i;
            ansList.add(review);
        }


        Collections.sort(ansList, Comparator.comparing(Reviews::getCount).
                thenComparing(Comparator.comparing(Reviews::getIndex, Collections.reverseOrder())));

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i =ansList.size()-1; i >=0 ; i--){
            ans.add(ansList.get(i).index);
        }

        return ans;
    }



    class Reviews{
        int index;
        int count;
        public Reviews(){
            index = 0;
            count = 0;
        }

        public int getCount(){
            return count;
        }

        public int getIndex(){
            return index;
        }
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        public TrieNode(){
            for(int i =0; i < 26 ; i++){
                children[i] = null;
            }
            isEndOfWord = false;
        }
    }


    public void insert(String key){
        int length = key.length();
        int level;
        int index;
        TrieNode pCrawl = root;

        for(level =0; level < length; level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] ==null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;

    }


    public boolean search(String key){
        int length = key.length();
        int level;
        int index;
        TrieNode pCrawl = root;
        for(level =0; level < length; level++){
            index = key.charAt(level) -'a';
            if(pCrawl.children[index] == null){
                return false;
            }
            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }



}

