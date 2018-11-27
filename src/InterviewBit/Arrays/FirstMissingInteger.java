package InterviewBit.Arrays;

import java.util.ArrayList;

public class FirstMissingInteger {
    public static void main(String[] args){
        FirstMissingInteger a = new FirstMissingInteger();
        ArrayList<Integer> A = new ArrayList<>();
        //A.add(2);A.add(-2);A.add(1);A.add(-3);A.add(0);A.add(7);
        A.add(10);
        //A.add(-8);A.add(-7);A.add(-6);
        //A.add(3);A.add(4);A.add(-1);A.add(1);
        System.out.println(a.missingNumber(A));
    }

    public int missingNumber(ArrayList<Integer> A){

        int posIndex = 0;
        // This solution but requires new ArrayList for positive nos., works even if neg nos are present
        for(int i = 0 ; i < A.size() ; i++){
            if(A.get(i) <= 0 ){
                int temp = A.get(i);
                A.set(i, A.get(posIndex));
                A.set(posIndex, temp);
                posIndex++;
            }
        }
        // Create new Array to separate out positive numbers
        int[] arr = new int[A.size()-posIndex];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = A.get(i+posIndex);
        }

        for(int i = 0; i < arr.length; i++)
        {

            if(Math.abs(arr[i]) - 1 < arr.length && arr[Math.abs(arr[i]) - 1] > 0)
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }

        // Return the first index value at which is positive
        for(int i = 0; i < arr.length; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes start from 0

        return arr.length+1;


 //Below solution works using existing ArrayList without creating new one, but works only for positive integers.
        /*for(int i = posIndex; i < A.size(); i++){
            int value = Math.abs(A.get(i)) - 1;
            if(value < A.size() - posIndex && A.get(value+posIndex) > 0) {
                A.set(value+posIndex, -A.get(value+posIndex));
            }
        }

        for(int i = posIndex; i < A.size() ; i++) {
            if (A.get(i) > 0)
                return i + 1 - posIndex;  // 1 is added because indexes start from 0
        }

        return A.size() - posIndex + 1;*/
    }

}
