package HackerRankPractice;

public class CountFrequencies
{
    // Function to find counts of all elements present in
    // arr[0..n-1]. The array elements must be range from
    // 1 to n
    public int[] findCounts(int[] arr, int n)
    {
        // Traverse all array elements
        int i = 0;
        while (i < n)
        {
            // If this element is already processed,
            // then nothing to do
            if (arr[i] <= 0)
            {
                i++;
                continue;
            }

            // Find index corresponding to this element
            // For example, index for 5 is 4
            float elementIndex = arr[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't loose anything.
            if (arr[(int) elementIndex] > 0)
            {
                arr[i] = arr[(int) elementIndex];

                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[(int) elementIndex] = -1;
            }
            else
            {
                // If this is NOT first occurrence of arr[i],
                // then increment its count.
                arr[(int) elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }

        System.out.println("Below are counts of all elements");
        for (int j = 0; j < n; j++) {
            arr[j] = Math.abs(arr[j]);
            System.out.println(j + 1 + "->" + Math.abs(arr[j]));
        }
    return arr;
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        CountFrequencies count = new CountFrequencies();
//        int arr[] = {2, 3, 3, 2, 5};
//        count.findCounts(arr, arr.length);
//
//        int arr1[] = {1};
//        count.findCounts(arr1, arr1.length);
//
//        int arr3[] = {4, 4, 4, 4};
//        count.findCounts(arr3, arr3.length);
//
//        int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
//        count.findCounts(arr2, arr2.length);
//
//        int arr4[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
//        count.findCounts(arr4, arr4.length);
//
//        int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        count.findCounts(arr5, arr5.length);
//
//        int arr6[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        count.findCounts(arr6, arr6.length);
    }
}
