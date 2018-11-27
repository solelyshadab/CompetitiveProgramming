package InterviewBit.Backtracking;
import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args){
        PalindromePartitioning a = new PalindromePartitioning();
        ArrayList<ArrayList<String>> ansList =a.partition("ABAAB");
        for(ArrayList<String> i:ansList) {
//            for(String x:i) {
//                System.out.print(x+" ");
//            }
            System.out.println(i);
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> partition(String A){
    ArrayList<ArrayList<String>>  ansList = new ArrayList<>();
        if(A == null || A.length() ==0)
            return ansList;

        ansList = solution(A,0, new ArrayList<>(),ansList);
        return ansList;
    }

    private static ArrayList<ArrayList<String>>  solution(String s,int start, ArrayList<String> list , ArrayList<ArrayList<String>> ansList){
        if(start == s.length()){
            ArrayList<String> ans = new ArrayList<>(list);
            ansList.add(ans);
            return ansList;
        }
        //ArrayList<String> temp=new ArrayList<>(list);
        for(int i =start; i < s.length() ; i++){

            if(isPalindrome(s.substring(start, i+1))) {
                list.add(s.substring(start, i + 1));
                ansList = solution(s, i + 1, list, ansList);
                //list = new ArrayList<>(temp);
                list.remove(list.size()-1);
            }
        }

        return ansList;
    }
    // Using backtrack + DP, but answer has all combinations space separated...
    private static ArrayList<String> getAllPalindromes(String A, int start, Map<Integer,ArrayList<String>> map){
        if(start==A.length()){
            ArrayList<String> x = new ArrayList<>();
            x.add("");
            return x;
        }

        if(map.containsKey(start))
            return map.get(start);

        ArrayList<String> ansList = new ArrayList<>();
        for(int i = start; i < A.length(); i++){
            String newWord = A.substring(start, i+1);

            if(isPalindrome(newWord)){
                ArrayList<String> result = getAllPalindromes(A,i+1,map);
                for(String word : result) {
                    String space = word.length()==0 ? "" : " ";
                    ansList.add(newWord + space + word);
                }
            }


        }
        map.put(start,ansList);
        return ansList;
    }


    private static boolean isPalindrome(String A){
        if(A == null || A.length() == 0)
            return false;

        int l = 0;
        int r = A.length()-1;
        while(l < r){
            if(A.charAt(l) != A.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
