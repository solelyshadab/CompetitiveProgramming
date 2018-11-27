package CourseEra.Month1;


public class MergeSort {
    int ab = 0;
    int ac = 0;
    public static void main(String[] args) {

        //System.out.println("Main method started!");
        int arr[] = {96,7,34,87,7,6,0};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0,arr.length-1);
        printArray(arr);
    }

    public int[] sort(int[] arr, int l, int r){

        //System.out.println("Sort method no : " + ab);
        ab++;
        if(l<r){
            // find the middle point
            int m = (l+r)/2;

            //sort first and second halves
            sort(arr, l , m);
            sort(arr, m+1, r);
            merge(arr,l,m,r);
        }
        return arr;
    }

    // Merge two subArrays of arr[]
    //First subArray is arr[l to m], second subArray is arr[m+1 to r]
    private void merge(int arr[], int l , int m, int r){

        //System.out.println("Merge method no : " + ac);
        ac++;

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

    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
