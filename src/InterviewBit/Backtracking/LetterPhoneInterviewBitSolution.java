package InterviewBit.Backtracking;

import java.util.*;

public class LetterPhoneInterviewBitSolution {
    public static void main(String[] args){
        LetterPhoneInterviewBitSolution a = new LetterPhoneInterviewBitSolution();

        a.letterCombinations("02");
    }
    private static Map<Character,List<Character>> map = new HashMap<>();

    static{
        map.put('0', Arrays.asList('0'));
        map.put('1',Arrays.asList('1'));
        map.put('2',Arrays.asList('a','b','c'));
        map.put('3',Arrays.asList('d','e','f'));
        map.put('4',Arrays.asList('g','h','i'));
        map.put('5',Arrays.asList('j','k','l'));
        map.put('6',Arrays.asList('m','n','o'));
        map.put('7',Arrays.asList('p','q','r','s'));
        map.put('8',Arrays.asList('t','u','v'));
        map.put('9',Arrays.asList('w','x','y','z'));
    }

    public ArrayList<String> letterCombinations(String A) {

        ArrayList<String> res = new ArrayList<>();

        letters(A,0,res,new StringBuilder());

        return res;
    }

    private void letters(String A, int index, ArrayList<String> res, StringBuilder cur){
        if(A.length() <= index){
            res.add(cur.toString());
            return;
        }
        for(Character c: map.get(A.charAt(index))){
            StringBuilder sb = new StringBuilder(cur);
            sb.append(c);
            letters(A,index+1,res, sb);
        }
    }
}
