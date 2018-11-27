package InterviewBit.GraphDataStructureAndAlgorithms;
import java.util.*;

public class WordSearchBoard {
    public static void main(String[] args){
        WordSearchBoard a = new WordSearchBoard();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("FAAABE", "EDGFED", "GDAGBD", "EBACCE", "DDBCBC", "ACDABD", "FFCFGC", "GDDDFB", "EAGFEF", "AEBGDA" ));
        System.out.println(a.exist(A,"CDDCEFAC"));
    }
    // FAAABE
    // EDGFED
    // GDAGBD
    // EBACCE
    // DDBCBC
    // ACDABD
    // FFCFGC
    // GDDDFB
    // EAGFEF
    // AEBGDA


    // Solution 1 : Accepted answer, uses DFS ans recursion
    public int exist(ArrayList<String> A, String B) {
        int n = A.size(); int m = A.get(0).length();

        for(int i =0; i < n ; i++){
            for(int j = 0; j < m ; j++){

                if(A.get(i).charAt(j) == B.charAt(0) && DFS(A,B,i,j,0, n,m)){
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean DFS(ArrayList<String> A, String B, int i, int j,int index,
                        int n, int m){

        if(i<0 || i >=n || j <0 || j >= m)
            return false;


        if(A.get(i).charAt(j) == B.charAt(index)){

            if(index == B.length() -1)
                return true;

            else if(DFS(A,B,i+1,j,index+1,n,m)
                    || DFS(A,B,i-1,j,index+1,n,m)
                    || DFS(A,B,i,j+1,index+1,n,m)
                    || DFS(A,B,i,j-1,index+1,n,m)){
                return true;
            }

        }

        return false;

    }


}
