package InterviewBit.Arrays;

import java.util.*;

public class NobleInteger {

    public static void main(String[] args){
        NobleInteger a = new NobleInteger();
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);list.add(2);list.add(7);list.add(0);list.add(9);
//        list.add(3);list.add(6);list.add(0);list.add(6);
        list.add(2);list.add(2);list.add(5);list.add(1);
//        list.add(-4);list.add(-2);list.add(0);
//        list.add(-1);list.add(-6);
        //list.add(5);list.add(6);list.add(2);
        System.out.println(a.solve(list));
    }

    public int solve(ArrayList<Integer> A) {

    int size = A.size();
        int[] sortedArray = new int[size];
        for(int i = 0; i < size; i++){
            sortedArray[i] = A.get(i);
        }

        sortedArray = quickSort(sortedArray, 0 , size-1);

        for(int i = sortedArray.length-2; i >= 0; i--){
            if(sortedArray[i] == sortedArray.length - i - 1 && sortedArray[i] != sortedArray[i+1] ){
                return 1;
            }
        }

        if(sortedArray[size-1] == 0){
            return 1;
        }

        return -1;

    }

    private static int[] quickSort(int[] arr, int l, int r){

        if(l<r){

            int pIndex = new Random().nextInt(r-l+1)+l;

            int p = arr[pIndex];
            int x = arr[pIndex];
            arr[pIndex] = arr[l];
            arr[l] = x;
            int i = l+1;
            for(int j = l+1; j <=r; j++){
                if(arr[j]< p) {
                    int a = arr[j];
                    arr[j] = arr[i];
                    arr[i] = a;
                    i++;
                }
            }
            //Swap pivot to right position
            int b = arr[i-1];
            arr[i-1] = arr[l];
            arr[l] = b;

            if(i-2-l >0) {
                quickSort(arr, l, i - 2);
            }
            if(r-i>0) {
                quickSort(arr, i, r);
            }

        }

        return arr;
    }
}
