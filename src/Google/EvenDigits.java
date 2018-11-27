package Google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EvenDigits {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long n = in.nextLong();
            long ans = calculateMinSteps(n);

            System.out.println("Case #" + i + ": " + ans);
        }

    }

    private static long calculateMinSteps(Long n){
        long ans = 0;
        long n1 = n;
        long ans1 = 0;;
        long ans2 = 0;
        if(areAllDigitsEven(n))
            return ans;

        while (!areAllDigitsEven(n)){
            n++;
            ans1++;

        }

        while (!areAllDigitsEven(n1)){
            n1--;
            ans2 ++;
        }

       return Math.min(ans1, ans2);

    }

    private static boolean areAllDigitsEven(long n){

        while (n > 0) {
            if (n % 2 == 0) {
            } else {
                return false;
            }
            n = n / 10;
        }
        return true;

    }
}
