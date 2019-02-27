package HackerRankPractice.ExceptionHandlng;

import java.util.Scanner;

public class ExceptionHandling {

    public int power(int a, int b) throws NegativeException{
        if(a < 0 || b < 0)
            throw new NegativeException("n and p should be non-negative");
        if ( b == 0)        return 1;
        if ( b == 1)        return a;
        if (b % 2 == 0)
            //even a=(a^2)^b/2
            return power ( a * a, b/2);
        else
            //odd  a=a*(a^2)^b/2
            return a * power ( a * a, b/2);
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            ExceptionHandling myCalculator = new ExceptionHandling();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (NegativeException e) {
                System.out.println(e);
            }
        }
        in.close();
    }
}
