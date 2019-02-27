package InterviewBit.BinarySearch.Practice;

public class MedianOfTwoSortedArraysOfDiffSizes {
    public static void main(String[] args){
        int[] arr1 = {1,2};
        int[] arr2 = {3,4,5,6,7,8,9,10};
        MedianOfTwoSortedArraysOfDiffSizes a = new MedianOfTwoSortedArraysOfDiffSizes();
        System.out.println(a.findMedianSortedArrays(arr1,arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;int y = nums2.length; int l = 0; int r = x;
        int midX; int midY;
        int leftMaxX; int rightMinX;
        int leftMaxY; int rightMinY;
        while(l <=r){
            midX = (l + r) /2;
            midY = (x+y+1)/2 - midX;

            leftMaxX = midX == 0 ? Integer.MIN_VALUE : nums1[midX-1];
            rightMinX = midX == x ? Integer.MAX_VALUE : nums1[midX];

            leftMaxY = midY == 0 ? Integer.MIN_VALUE : nums2[midY-1];
            rightMinY = midY == y ? Integer.MAX_VALUE : nums2[midY];

            if(leftMaxX <= rightMinY && rightMinX >= leftMaxY){
                if( (x+y) % 2 == 0)
                    return ((double) Math.max(leftMaxX,leftMaxY) + Math.min(rightMinX,rightMinY)) / 2;
                else
                    return (double) Math.max(leftMaxX ,leftMaxY);

            }else{
                if(leftMaxX > rightMinY)
                    r = midX-1;
                else
                    l = midX+1;
            }

        }

        throw new IllegalArgumentException();

    }
}
