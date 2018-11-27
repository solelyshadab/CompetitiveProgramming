package InterviewBit.Arrays.Buffer;

import InterviewBit.Arrays.MergeOverlappingIntervals;

public class LargestNumberBySingleSwap {
    public static void main(String[] args){
        LargestNumberBySingleSwap a = new LargestNumberBySingleSwap();

        System.out.println(a.largestNumber("96581"));
    }

    public String largestNumber(String A){

        char[] A_char = A.toCharArray();

        int max_right = -1;
        int max_right_index = -1;
        int r = -1;
        int l = -1;
        for(int i = A_char.length-1; i >=0 ; i--){
            if(A_char[i] - '0' > max_right){
                max_right = A_char[i] -'0';
                max_right_index = i;
            }

            else if(A_char[i]-'0' < max_right){
                l = i;
                r = max_right_index;
            }

        }

        if(l == -1){
            return A;
        }

        // Swap left and right index numbers
        char temp = A_char[l];
        A_char[l] = A_char[r];
        A_char[r] = temp;

        return new String(A_char);
    }
}
