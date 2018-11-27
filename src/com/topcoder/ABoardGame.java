package com.topcoder;

import java.util.ArrayList;
import java.util.Scanner;

// All tests running successfully!!
public class ABoardGame {
    public static void main(String[] args) {
        System.out.println("Main method started!");
        //String[] input = {".....A", "......", "..A...", "...B..", "......", "......"};
        //String[] input = {"AAAA", "A.BA", "A..A", "AAAA"};
        //String[] input ={"..", ".."};
        //String[] input={"BBB..BAB...B.B", ".AAAAAAAAAAAA.","AA.AA.AB..A.AB","..........B.AB",".A..BBAB.A.BAB",".AB.B.......A.",".A..A.AB.A..AB",".ABAA.BA...BA.","BAAAB.....ABA.",".A....B..A..B.","B...B....B..A.","BA.B..A.ABA.A.","BAAAA.AAAAA.A.","B.B.B.BB.B...."};
        //String[] input = {"..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBA.", "AABBBABABBAA", "...BABABABBA", "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A", "A..AAA.AAA.A"};
        String[] input = {"B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A", "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A"};
        ABoardGame aBoardGame = new ABoardGame();
        System.out.println("Winner is: "+aBoardGame.whoWins(input));
    }

    public String whoWins(String[] board){

        ArrayList<String> seen = new ArrayList<>();

        int N = board.length /2;
        int x = N-1;
        int y =0;
        while (x >=0 ){
            int AScore =0;
            int BScore =0;
            y = y+2;
            for(int i = x; i < x+y; i++) {
                for(int j = x; j < x+y; j++) {
                    String a = i + "_"+ j;
                    if (seen.contains(a))
                        continue;

                    if (board[i].charAt(j) == 'A')
                        AScore++;
                    else if(board[i].charAt(j) == 'B')
                        BScore++;

                    seen.add(a);
                }
            }
            if(AScore > BScore)
                return "Alice";
            if(BScore > AScore)
                return "Bob";
            x--;
        }
    return "Draw";
    }
}
