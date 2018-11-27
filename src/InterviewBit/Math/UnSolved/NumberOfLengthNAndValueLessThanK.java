package InterviewBit.Math.UnSolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfLengthNAndValueLessThanK {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        //A.add(0);A.add(1);A.add(2);A.add(5);
//        A.add(0);A.add(2);A.add(3);A.add(4);A.add(5);
//        A.add(7);A.add(8);A.add(9);
        A.add(0);A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);
        A.add(6);A.add(7);A.add(8);A.add(9);
        NumberOfLengthNAndValueLessThanK a = new NumberOfLengthNAndValueLessThanK();
        System.out.println(a.solution(A, 5,10004));
    }

    public int solution(ArrayList<Integer> A,int B, int C){
        String KString = Integer.toString(C);
        List<Integer> KuniqueList = new ArrayList<>();
        int[] KArray = new int[KString.length()];
        int[] countArray = new int[10];
        int[] equalCountArray = new int[10];

        for(int i = 0; i < KString.length(); i++){
            int temp = KString.charAt(i) - '0';
            KuniqueList.add(temp);
            KArray[i] = temp;
        }

        Collections.sort(KuniqueList);
        for(int i=0; i < KuniqueList.size()-1; i++){
            if(KuniqueList.get(i).equals(KuniqueList.get(i+1))){
                KuniqueList.remove(i+1);
                i--;
            }
        }

        int k = 0;
        FORLOOP :
        for(int i = 0; i < A.size(); i++ ){
            if(k > KuniqueList.size() -1)
                break ;
            int kDigit = KuniqueList.get(k);
            if(A.get(i) < kDigit){
                countArray[kDigit]++;
            }
            else if(A.get(i) == kDigit){
                equalCountArray[kDigit]++;
            }
            else{
                int carryOverCount = countArray[k];
                int carryOverEqualCount = equalCountArray[k];
                k++;
                i--;
                int kDigitNew = 0;
                if(k< KuniqueList.size()) {
                    kDigitNew = KuniqueList.get(k);
                }
                if(kDigitNew > 0) {
                    countArray[kDigitNew] += carryOverCount;
                    countArray[kDigitNew] += carryOverEqualCount;
                }
            }


        }

        int zeroCount = 0;
        // Count of zeros
        for(int i = 0; i < A.size(); i++){
            if(A.get(i)==0){
                zeroCount++;
            }
            else
                break;
        }

        int totalCount =0;
        int remainingSpace = B-1;
        int remainingDigits = A.size();
        for(int i = 0; i < KArray.length; i++){
            int kDigit = KArray[i];
            int perKDigitLesserCount = countArray[kDigit];
            if(i==0){
                perKDigitLesserCount -= zeroCount;
            }

        totalCount += perKDigitLesserCount * Math.pow(A.size(),remainingSpace);
            int min = Integer.MAX_VALUE;
            for(int j = i+1; j < KArray.length; j++){
                if(countArray[j] < min){
                    min = countArray[j];
                }
            }
            if(!A.contains(kDigit))
                break;

//            if(min !=Integer.MAX_VALUE) {
//                totalCount += equalCountArray[kDigit] * min;
//            }
            remainingSpace--;
            remainingDigits--;
        }

        return totalCount;
    }


}
