package com.topcoder;

import CourseEra.Month1.CountInversionsSolution;

import java.io.File;

public class CountInversions {

    // Driver method to test the above function
    public static void main(String[] args)
    {
        //int arr[] = new int[]{1, 20, 6, 4, 5};
        //int arr[] = new int[]{96, 7, 34, 87, 7, 6, 0};
        //Get file from resources folder
        CountInversionsSolution countInversions = new CountInversionsSolution();
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/LargeArrayInput.txt");
        System.out.println("FileName is :" + file.getName());
        int arr[] = countInversions.getArray(file);
        System.out.println("Number of inversions are " + mergeSort(arr, arr.length));
        countInversions.printArray(arr);
    }

    /* This method sorts the input array and returns the
       number of inversions in the array */
    static long mergeSort(int arr[], int array_size)
    {
        int temp[] = new int[array_size];
        return _mergeSort(arr, temp, 0, array_size - 1);
    }

    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    static long _mergeSort(int arr[], int temp[], int left, int right)
    {
        long inv_count=0;
        if (right > left)
        {
        /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
           int mid = (right + left)/2;

        /* Inversion count will be sum of inversions in left-part, right-part
          and number of inversions in merging */
            inv_count  += _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid+1, right);

            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }

    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/
    static long merge(int arr[], int temp[], int left, int mid, int right)
    {
        int i, j, k;
        long inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid;  /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            }
            else
            {
                temp[k++] = arr[j++];

                /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

      /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

      /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

        /*Copy back the merged elements to original array*/
        for (i=left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }


}
