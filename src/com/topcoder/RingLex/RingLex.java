package com.topcoder.RingLex;

public class RingLex {

    public static void main(String[] args){
        String s = "cba";
        System.out.println(getmin(s));
    }

    public static String getmin(String s){

        int x =0;
        int p = 2;
        int n = s.length();

        String s1 = "";
        int p0 = 0;
        while(s1.length() < n){

            if((x+ (p * p0))> s.length()+1 )
                s += s;

            s1 += s.charAt(x+(p*p0));
            s += s;
            p0++;
        }

            p = 1;
            x = 0;

                while (x++ < n) {
                    String s2 = "";
                    p0 = 0;
                    p++;
                    if(!isPrime(p))
                        continue;
                    while (s2.length() < n) {
                        if ((x + (p*p0) ) > s.length()+1)
                            s += s;

                        s2 += s.charAt(x + (p * p0));
                        p0++;
                    }
                    if (s1.compareTo(s2) < 0)
                        return s2;
                }


        return s1;
    }

    //checks whether an int is prime or not.
    public static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
