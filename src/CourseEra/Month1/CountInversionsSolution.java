package CourseEra.Month1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CountInversionsSolution {
    private static long backupCount = 0;

    public static void main(String[] args) {

        System.out.println("Main method started!");
        //int inputArray[] = new int[]{1, 20, 6, 4, 5};
        //int inputArray[] = new int[]{96, 7, 34, 87, 7, 6, 0};
        CountInversionsSolution countInversions = new CountInversionsSolution();
        //countInversions.sort(arr, 0,arr.length-1);

        //Get file from resources folder
        File file = new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/LargeArrayInput.txt");
        System.out.println("FileName is :" + file.getName());
        int inputArray[] = countInversions.getArray(file);

        long ans =  countInversions.sort(inputArray, 0,inputArray.length-1);
        System.out.println("No of count Inversions are: " + ans);
        System.out.println("Backup Count is: " + backupCount);
        countInversions.printArray(inputArray);
    }

    private long sort(int arr[],int l, int r){
    long inversionCounts = 0;
        if(l<r){
            // find the middle point
            int m = (l+r)/2;

            //sort first and second halves
            inversionCounts += sort(arr, l , m);
            inversionCounts+= sort(arr, m+1, r);
            inversionCounts+= merge(arr,l,m,r);
        }
        return inversionCounts;
    }

    // Merge two subArrays of arr[]
    //First subArray is arr[l to m], second subArray is arr[m+1 to r]
    private long merge(int arr[], int l , int m, int r){

        long inversionCounts = 0;
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
                inversionCounts = inversionCounts + ( L.length -i);
                backupCount+= L.length-i;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    return inversionCounts;
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public int[] getArray(File file){
        ArrayList<Integer> resultArray = new ArrayList();
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                int line = scanner.nextInt();
                resultArray.add(line);
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertIntegers(resultArray);
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

}
