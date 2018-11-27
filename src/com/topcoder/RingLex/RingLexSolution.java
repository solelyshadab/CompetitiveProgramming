package com.topcoder.RingLex;

import java.util.*;
import java.math.*;
import java.util.stream.*;
import static java.lang.Math.*;

public class RingLexSolution {

    public static void main(String[] args){
        String s = "cba";
        String s1 = "acb";
        String a= "abacaba";
        String b = "fsdifyhsoe";
        String c = "nimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpva";
        String d = "busbmborxtl";
        String e = 	"smpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjd";
        String f = 	"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String g = 	"bcabcbbbcbbcbcbcbcbbcbaaabcbacbaaca";
        RingLexSolution ringLexSolution = new RingLexSolution();
        System.out.println(ringLexSolution.getmin(s));
    }

    boolean prime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num; i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }

    public String getmin(String s) {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 2; j < s.length(); j++) {
                if (prime(j)) {
                    String ns = "";

                    for (int k = 0; k < s.length(); k++) {
                        ns += s.charAt( (i + j*k) % s.length());
                    }
                    strings.add(ns);
                }
            }
        }
        List<String> sl = new ArrayList<>(strings);
        Collections.sort(sl);

        if (sl.size() > 0) return sl.get(0);
        return s;
    }
}
