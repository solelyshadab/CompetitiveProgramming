package InterviewBit.Backtracking;

import java.util.ArrayList;

public class GrayCode {
    public static void main(String[] args){
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode1(3));
    }

    public ArrayList<String> grayCode1(int A){
        ArrayList<String> ansList = new ArrayList<>();
        ansList = solution(A,0, ansList,new StringBuilder());
        return ansList;
    }
    //A = 3, 000 001 011 010 110 111 101 100
    //A = 2 00 01 11 10
    // This method is just to get all possible bit  values, it is not the expected Solution..
    private static ArrayList<String> solution(int A,int start, ArrayList<String> ansList, StringBuilder list){
        if(start >= A && list.length() == A ){
           ansList.add(list.toString());
           return ansList;
        }

        for(int i = start; i < A; i++ ){
            list.append("0");
            solution(A,i+1, ansList,list);
            list.deleteCharAt(list.length()-1);
            list.append("1");
            solution(A, i+1,ansList,list );
            list.deleteCharAt(list.length()-1);
        }

        return ansList;
    }
    // Correct Solution..
    public ArrayList<Integer> grayCode(int n, ArrayList<Integer> ansList) {
        if(n==0){
            ansList.add(0);
            return ansList;
        }

        ansList = grayCode(n-1, ansList);
        int numToAdd = 1 << (n-1);

        for(int i=ansList.size()-1; i>=0; i--){
            ansList.add(numToAdd+ansList.get(i));
        }

        return ansList;
    }

}
