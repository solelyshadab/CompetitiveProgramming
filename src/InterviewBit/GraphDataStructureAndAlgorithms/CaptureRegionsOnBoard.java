package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class CaptureRegionsOnBoard {
    public static void main(String[] args){
        CaptureRegionsOnBoard a = new CaptureRegionsOnBoard();
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        ArrayList<Character> B = new ArrayList<>(Arrays.asList('X','X','X','X'));
        ArrayList<Character> C = new ArrayList<>(Arrays.asList('X','O','O','X'));
        ArrayList<Character> D = new ArrayList<>(Arrays.asList('X','X','O','X'));
        ArrayList<Character> E = new ArrayList<>(Arrays.asList('X','O','X','X'));
        A.add(B);A.add(C);A.add(D);A.add(E);
        a.solve(A);
        for(ArrayList<Character> list : A)
            System.out.println(list);
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();

        // convert all 'O' to '-'
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a.get(i).get(j) == 'O'){
                    floodFill(a,'O', '-', i, j, n, m);
                }
            }
        }

        //Convert top edge to 'O'
        for(int j = 0; j < m ; j++ ){
            if(a.get(0).get(j) == '-')
            floodFill(a, '-', 'O', 0, j, n,m);
        }

        // bottom edge to 'O'
        for(int j = 0; j < m ; j++ ){
            if(a.get(n-1).get(j) == '-')
                floodFill(a, '-', 'O', n-1, j, n,m);
        }

        // left edge to 'O'
        for(int i = 0; i < n ; i++ ){
            if(a.get(i).get(0) == '-')
                floodFill(a, '-', 'O', i, 0, n,m);
        }

        // right edge to 'O'
        for(int i = 0; i < n ; i++ ){
            if(a.get(i).get(m-1) == '-')
                floodFill(a, '-', 'O', i, m-1, n,m);
        }

        //change back middle '- to 'X'
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a.get(i).get(j) == '-'){
                    floodFill(a,'-', 'X', i, j, n, m);
                }
            }
        }

    }

    private void floodFill(ArrayList<ArrayList<Character>> A, Character from, Character to, int i, int j,
    int n, int m){

        if(i < 0 || j < 0 || i >= n || j >= m)
            return;

        if(A.get(i).get(j) != from)
            return;

        A.get(i).set(j, to);

        floodFill(A,from,to,i +1, j, n,m);
        floodFill(A,from,to,i -1, j, n,m);
        floodFill(A,from,to,i , j+1, n,m);
        floodFill(A,from,to,i, j-1, n,m);
    }
}
