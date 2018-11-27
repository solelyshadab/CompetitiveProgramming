package com.topcoder.ABBADiv1;


import java.util.*;

public class ABBADiv1Solved {
    public static HashSet<String> seen;

    public static void main(String[] args) {
        System.out.println("Main method started!");
//taking value as command line argument.
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter initial String:  ");
        String initial = in.next();
        System.out.printf("Enter target String:  ");
        String target = in.next();
        ABBADiv1Solved abbaDiv1Solved = new ABBADiv1Solved();
        String ans = abbaDiv1Solved.canObtain(initial, target);

        System.out.printf("\n Answer is: " + ans);
    }


    public String canObtain(String initial, String target) {
        seen = new HashSet<>();
        return can(initial, target) ? "Possible" : "Impossible";
    }

    public boolean can(String a, String b) {
        if (a.equals(b)) return true;
        if (b.length() == a.length()) return false;
        if (seen.contains(b)) return false;
        seen.add(b);
        if (b.endsWith("A") && can(a, b.substring(0, b.length()-1))) return true;
        if (b.startsWith("B") && can(a, reverse(b.substring(1)))) return true;

        return false;
    }

    public String reverse(String m) {
        char[] ret = new char[m.length()];
        for (int i = 0; i < m.length(); i++) {
            ret[i] = m.charAt(m.length()-i-1);
        }
        return new String(ret);
    }
}
