package com.topcoder;

import java.util.Scanner;

public class AB {
    public static void main(String[] args) {
        System.out.println("Main method started!");
//taking value as command line argument.
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter N Value:  ");
        int N = in.nextInt();
        System.out.printf("Enter K Value:  ");
        int K = in.nextInt();
        String outputString = createString(N, K);
        System.out.printf("String is: " + outputString);
    }


    public static String createString(int N, int K) {
        for (int cntB = 0; cntB <= N; cntB++) {
            char[] a = new char[N];
            for (int i = 0; i < cntB; i++) {
                a[i] = 'B';
            }
            for (int i = cntB; i < N; i++) {
                a[i] = 'A';
            }
            int cur = 0;
            while (true) {
                if (cur == K) {
                    return new String(a);
                }
                int pos = -1;
                for (int i = 0; i + 1 < N; i++) {
                    if (a[i] == 'B' && a[i + 1] == 'A') {
                        pos = i;
                        break;
                    }
                }
                if (pos == -1) {
                    break;
                }
                cur++;
                a[pos] = 'A';
                a[pos + 1] = 'B';
            }
        }
        return "";
    }
}

