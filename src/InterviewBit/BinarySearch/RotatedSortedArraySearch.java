package InterviewBit.BinarySearch;
import java.util.*;

public class RotatedSortedArraySearch {
    public static void main(String[] args){
        RotatedSortedArraySearch a = new RotatedSortedArraySearch();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);A.add(5);A.add(6);A.add(7);A.add(8);A.add(9);
        //System.out.println(pivot(A, 0, A.size()-1));
        //System.out.println(binarySearch(A,0, A.size()-1, 7));
        System.out.println(a.search(A,9));
    }

    public int search(List<Integer> A, int x){
        
        int pivot = pivot(A,0, A.size()-1);
        if(pivot == -1)
            return binarySearch(A, 0, A.size()-1, x);
        if(x == A.get(pivot))
            return pivot;

        if( x >= A.get(0))
            return binarySearch(A,0, pivot, x);


            return binarySearch(A, pivot+1, A.size()-1, x);


    }

    private static int binarySearch(List<Integer> A, int l, int r, int x ){
        if(l>r)
            return -1;

        int mid = l + (r-l) /2;
        if(A.get(mid) == x)
            return mid;

        if(A.get(mid) > x){
            r = mid -1;
            return binarySearch(A, l, r, x);
        }

        l = mid+1;
        return binarySearch(A, l, r, x);

    }

    private static int pivot(List<Integer> A, int l, int r){
        if(l>r)
            return -1;

        if(A.get(l) < A.get(r))
            return -1;

        int mid = l + (r-l)/2;

        if(mid < r && A.get(mid) > A.get(mid+1)){
            return mid;
        }
        if( mid > l && A.get(mid) < A.get(mid-1)){
            return mid-1;
        }

        if( A.get(mid) < A.get(r)){
            r = mid-1;
            return pivot(A, l,r);
        }

            l = mid+1;
            return pivot(A, l,r);


    }

}
