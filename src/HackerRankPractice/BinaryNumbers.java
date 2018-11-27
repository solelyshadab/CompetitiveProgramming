package com.bt.neo.scenarios.ATSRuleEngine.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 609112524 on 13/02/2018.
 */
public class BinaryNumbers {
    private static List<Integer> binaryList = new ArrayList<>();
    private static int count =0;
    private static int tempCount = 0;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n>0){
            int remainder = n % 2;
            n = n/2;
            binaryList.add(remainder);
        }

        Collections.reverse(binaryList);
        //System.out.print(binaryList);

        for(int i = 0; i< binaryList.size(); i++){
            if(binaryList.get(i) == 1){
                tempCount++;
            }
            else{
                if(tempCount>= count)
                    count = tempCount;

                tempCount =0;
            }

            if(i == binaryList.size()-1 && binaryList.get(i) == 1 ) {

                    if (tempCount >= count)
                        count = tempCount;

                    tempCount = 0;
                }
        }
        System.out.println(count);

    }
}
