package InterviewBit.Arrays.Practice;

public class MinSwapsToSortArray {

    static int minimumSwaps(int[] arr) {
        int l = 0; int r = arr.length-1; int swaps = 0;
        while(l<r){
            while(arr[l]== l+1 && l <r)
                l++;

            if(l<r){
                int temp = arr[arr[l]-1];
                arr[arr[l]-1] = arr[l];
                arr[l] = temp;
                swaps++;
            }

        }
        return swaps;
    }
}
