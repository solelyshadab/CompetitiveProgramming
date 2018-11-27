package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {
    public static void main(String[] args){
        int[] arr = {2, 1, -1, 1,1,1 };
        //int[] arr = {2147483647 , 1540383426, -1303455736, -521595368, 2147483646 ,2147483644,2147483647  };
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }

        MaxNonNegativeSubArray a = new MaxNonNegativeSubArray();
        System.out.println(Arrays.toString(a.maxSet(list).toArray()));
    }

    public ArrayList<Integer> maxSet(ArrayList<Integer> A) {

        int size = A.size();
        ArrayList<Integer> ansList = new ArrayList<>();
        long maxSum_so_far = 0, maxSum_ending_here = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        int maxSegment = 0;
        int segmentLength = 0;

        for (int i = 0; i < size; i++) {
            if(A.get(i) >= 0) {
                segmentLength++;
                maxSum_ending_here += A.get(i);
                tempList.add(A.get(i));
            }
            else{
                if(maxSum_ending_here > maxSum_so_far) {
                    maxSum_so_far = maxSum_ending_here;
                    maxSegment = segmentLength;
                    ansList.clear();
                    for(int j = 0; j < tempList.size() ; j++) {
                        ansList.add(tempList.get(j));
                    }

                }

                if(maxSum_ending_here == maxSum_so_far && segmentLength > maxSegment){
                    maxSum_so_far = maxSum_ending_here;
                    maxSegment = segmentLength;
                    ansList.clear();
                    for(int j = 0; j < tempList.size() ; j++) {
                        ansList.add(tempList.get(j));
                    }
                }
                tempList.clear();
                maxSum_ending_here = 0;
                segmentLength = 0;
            }
            // If we are in last index
            if(i== size-1 && maxSum_ending_here > maxSum_so_far){
                maxSum_so_far = maxSum_ending_here;
                maxSegment = segmentLength;
                ansList.clear();
                for(int j = 0; j < tempList.size() ; j++) {
                    ansList.add(tempList.get(j));
                }
            }
            if(i== size-1 && maxSum_ending_here == maxSum_so_far && segmentLength > maxSegment){
                maxSum_so_far = maxSum_ending_here;
                maxSegment = segmentLength;
                ansList.clear();
                for(int j = 0; j < tempList.size() ; j++) {
                    ansList.add(tempList.get(j));
                }
            }

        }
        return ansList;
    }
}
