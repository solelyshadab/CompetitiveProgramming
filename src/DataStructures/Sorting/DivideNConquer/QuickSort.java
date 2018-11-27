package DataStructures.Sorting.DivideNConquer;
import CourseEra.Month1.CountInversionsSolution;

import java.io.*;
import java.util.*;

public class QuickSort {

    private static long count =0;

    public static void main(String[] args){

        int arr[] = {5,7,0,91,3,11};

        //Get file from resources folder
        CountInversionsSolution countInversions = new CountInversionsSolution();
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/QuickSortLargeInput.txt");
        System.out.println("FileName is :" + file.getName());
        int inputArray[] = countInversions.getArray(file);

        quickSort(inputArray,0,inputArray.length-1);
        System.out.println(Arrays.toString(inputArray));
        System.out.println("Total no of comparisons: " + count);

    }

    private static void quickSort(int[] arr, int l, int r){

        if(l<r){

            int pIndex = new Random().nextInt(r-l+1)+l;
            //int pIndex =l;
            //int pIndex = r;
            count += r-l;

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
    }
}
