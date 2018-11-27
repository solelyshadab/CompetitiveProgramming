package com.topcoder.ABBADiv1;

import java.util.Scanner;
// This solution is not 100% correct, ABBADiv1Solved is the correct solution.
public class ABBADiv1MySoln {

    public static void main(String[] args) {
        System.out.println("Main method started!");
//taking value as command line argument.
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter initial String:  ");
        String initial = in.next();
        System.out.printf("Enter target String:  ");
        String target = in.next();
        ABBADiv1MySoln abbaDiv1MySoln = new ABBADiv1MySoln();
        String ans = abbaDiv1MySoln.canObtain(initial, target);

        System.out.printf("\n Answer is: " + ans);
    }

    public String canObtain(String initial, String target) {
        System.out.printf("CanObtain Method!");
        while(true){
            if(target.equals(initial))
                return "Possible";
            if(target.length() == initial.length())
                return "Impossible";

            if(target.endsWith("A")) {
                target = target.substring(0, target.length() - 1);

            }
            else if(target.startsWith("B")) {
                target = reverse(target);
                target = target.substring(0, target.length() - 1);

            }
            }
        }

    public String reverse(String m) {
        char[] ret = new char[m.length()];
        for (int i = 0; i < m.length(); i++) {
            ret[i] = m.charAt(m.length()-i-1);
        }
        return new String(ret);
    }

    }

