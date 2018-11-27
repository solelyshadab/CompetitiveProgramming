package com.topcoder.ABBADiv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// This solution although passed few Test Cases, it faied for some, hence new Solution written on ABBADiv1MySoln(which is also not 100% correct)
// This solution is not 100% correct, ABBADiv1Solved is the correct solution.
public class ABBADiv1 {
    public static void main(String[] args) {
        System.out.println("Main method started!");
//taking value as command line argument.
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter initial String:  ");
        String initial = in.next();
        System.out.printf("Enter target String:  ");
        String target = in.next();
        ABBADiv1 abbaDiv1 = new ABBADiv1();
        String ans = abbaDiv1.canObtain(initial, target);

        System.out.printf("\n Answer is: " + ans);
    }

    public String canObtain(String initial, String target){

        int N0 = initial.length();
        List<Character> a = new ArrayList<>();

        for(int i=0; i<N0 ; i++){
            a.add(initial.charAt(i)) ;
        }

        int N1 = target.length();
        List<Character> b = new ArrayList<>();

        for(int i=0; i<N1 ; i++){
            b.add(target.charAt(i));
        }


        while (true){
            int x = 0;
            boolean isMatching = false;
            String listString = "";

            for (Character s : a)
            {
                listString += s.toString();
            }

            if(target.equals(listString))
                return "Possible";

            for (int i = 0; i< N1-a.size();i++) {
                if(isMatching)
                    break;
                char t = b.get(i);
                char w = a.get(0);
                if (t == w){
                    x = i;
                    for (int j = 0; j < N0; j++) {

                            char l = b.get(i + j);
                            char k = a.get(j);
                            if (l != k) {
                                isMatching = false;
                                break;
                            } else isMatching = true;
                    }
                    if(isMatching)
                        break;
                }
            }
            boolean isReversed = false;
            if(!isMatching){
                    Collections.reverse(b);
                String bList = "";

                for (Character s : b)
                {
                    bList += s.toString();
                }
                //System.out.printf(bList);
                    isReversed = true;
                for (int i = 0; i< N1 - a.size();i++) {
                    if(isMatching)
                        break;
                    char t = b.get(i);
                    char w = a.get(0);
                    if (t == w){
                        x = i;
                        for (int j = 0; j < a.size(); j++) {
                            char l = b.get(i+j);
                            char k = a.get(j);
                            if (l!= k) {
                                isMatching = false;
                                break;
                            }
                            else isMatching = true;
                        }
                    }
                }

            }

            if(isMatching){
                int index = 0;
                if(x+ a.size() < b.size()) {
                    index = x + a.size();
                }
                else return "Impossible";
                char v = b.get(index);
                if(v =='B'){
                    a.add('B');
                    Collections.reverse(a);
                }
                else a.add('A');
            }
            else return "Impossible";

            if(isReversed)
                Collections.reverse(b);
        }

    }

}
