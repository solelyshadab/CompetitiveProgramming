package DataStructures.Sorting.DivideNConquer;

import java.util.Random;

public class QuickSortPractice {
    public static void main(String[] args){
        int[] arr = {5,3,1,2,4,6};
        int[] ans = quickSort(arr);
        for(int i =0; i < ans.length; i++)
        System.out.print(ans[i] + " ");
    }

    private static int[] quickSort(int[] arr){
        return sort(arr, 0, arr.length-1);
    }

    private static int[] sort(int[] arr, int l, int r){
        if(l >=r)
            return arr;
        int pIndex = l;
        int pivot = arr[pIndex];

        int i = l+1;
        for(int j= l+1; j < arr.length; j++){
            if(arr[j] <= pivot){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        arr[l] = arr[i-1];
        arr[i-1] = pivot;

        sort(arr, l, i-2);
        sort(arr,i, r);

        return arr;
    }



    private static int[] quickSort(int[] arr, int l, int r) {

        if(l>=r)
            return arr;

            int pIndex = new Random().nextInt(r - l + 1) + l;

            int p = arr[pIndex];

            int temp = arr[pIndex];
            arr[pIndex] = arr[l];
            arr[l] = temp;

            int i = l + 1;
            for (int j = l + 1; j <= r; j++) {
                if (arr[j] < p) {
                    int temp1 = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp1;
                    i++;
                }
            }
            //Swap pivot to right position
            int temp2 = arr[i - 1];
            arr[i - 1] = arr[l];
            arr[l] = temp2;

                quickSort(arr, l, i - 2);
                quickSort(arr, i, r);


        return arr;
    }



}
