package InterviewBit.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Fraction {
    public static void main(String[] args) {
        Fraction a = new Fraction();
        System.out.println("Correct: " + fractionToDecimal(-1,-2147483648));
        System.out.println("Mine:    " + a.fraction(-1,-2147483648));
    }

    public String fraction(int A, int B) {
        if(A == 0)
            return "0";
        if(B ==0)
            return "";
        StringBuilder ansSB = new StringBuilder();
        Long numerator = (long) A;
        numerator = Math.abs(numerator);
        Long denominator = (long) B;
        denominator = Math.abs(denominator);

        Long quotient = numerator /denominator;
        if(A > 0 && B < 0 || B > 0 && A < 0)
            ansSB.append("-");

        ansSB.append(quotient);

        HashMap<Long, Integer> map = new HashMap<>();

        long rem = numerator % denominator;
        if (rem ==0)
            return ansSB.toString();
        rem = rem * 10;
        StringBuilder decSoFarSB = new StringBuilder();

        while (!map.containsKey(rem)) {
            map.put(rem, decSoFarSB.length());
            decSoFarSB.append(rem / denominator);
            rem = rem % denominator;
            rem = rem * 10;

            if(rem == 0)
                return ansSB.append("."+ decSoFarSB).toString();

        }

    decSoFarSB.insert(map.get(rem),"(");
    ansSB.append("." +decSoFarSB + ")");

        return ansSB.toString();
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long a=numerator,b=denominator;
        if(a%b==0)
            return String.valueOf(a/b);


        Map<Long,Integer> map=new HashMap<>();
        StringBuilder result=new StringBuilder();

        if((a>0&&b<0)||(a<0&&b>0))
            result.append("-");
        a=Math.abs(a);
        b=Math.abs(b);
        result.append(a/b+".");

        a=(a%b)*10;

        while(!map.containsKey(a)){
            map.put(a,result.length());
            result.append(String.valueOf(a/b));
            a=(a%b)*10;
            if(a==0)
                return result.toString();
        }
        return result.insert(map.get(a),"(").append(")").toString();

    }

}
