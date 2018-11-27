package CourseEra.Month1;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyTwoNumbersUsingMergeSort {

    public static void main(String[] args) {

        System.out.println("Main method started!");
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the first no to multiply:  ");
        BigInteger T1 = in.nextBigInteger();
        System.out.printf("Enter the second no to multiply:  ");
        BigInteger T2 = in.nextBigInteger();

        //List<Integer> list1 = intToArray(T1);
        //List<Integer> list2 = intToArray(T2);
        MultiplyTwoNumbersUsingMergeSort multiplynos = new MultiplyTwoNumbersUsingMergeSort();
        //BigInteger ans = multiplynos.multiply(T1, T2);
        BigInteger ans = multiplynos.karatsuba3(T1, T2);

        System.out.printf("Answer is : "+ ans);
    }

    public BigInteger karatsuba3(BigInteger T1, BigInteger T2) {

        // cutoff to brute force
        int N = Math.max(T1.bitLength(), T2.bitLength());
        if (N <= 2) return T1.multiply(T2);                // optimize this parameter

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // T1 = a + 2^N b,   T2 = c + 2^N d
        BigInteger b = T1.shiftRight(N);
        BigInteger a = T1.subtract(b.shiftLeft(N));
        BigInteger d = T2.shiftRight(N);
        BigInteger c = T2.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac    = karatsuba3(a, c);
        BigInteger bd    = karatsuba3(b, d);
        BigInteger abcd  = karatsuba3(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }



    private BigInteger multiply(BigInteger T1, BigInteger T2 ){
        String T1string = T1.toString();
        String T2string = T2.toString();
        int N = Math.max(T1string.length(), T2string.length());
        if(N <8)
        return T1.multiply(T2);
        {
            BigInteger a = new BigInteger(T1string.substring(0, (T1string.length()/2)));
            BigInteger b = new BigInteger(T1string.substring((T1string.length()/2)));
            BigInteger c = new BigInteger(T2string.substring(0, (T2string.length()/2)));
            BigInteger d = new BigInteger(T2string.substring((T2string.length()/2)));

            BigInteger ac = multiply(a,c);
            BigInteger bd = multiply(b,d);
            BigInteger ad = multiply(a, d);
            BigInteger bc = multiply(b,c);
            BigInteger adbc = ad.add(bc);

            BigInteger first = ac.multiply(BigInteger.valueOf((long) Math.pow(10, N)));
            BigInteger second = adbc.multiply(BigInteger.valueOf((long) Math.pow(10, N)));

            return first.add(second).add(bd);

            //return (multiply(a,c).multiply(BigInteger.valueOf((long) Math.pow(10, T1string.length()))).add ((multiply(a,d).add(multiply(b,c)).multiply(BigInteger.valueOf((long) Math.pow(10, T1string.length()/2)))) ).add(multiply(b, d)));

        }

    }



}


