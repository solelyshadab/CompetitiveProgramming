package InterviewBit.BinarySearch;

import java.util.ArrayList;

public class SortedInsertPosition {
    public static void main(String[] args){
        SortedInsertPosition a = new SortedInsertPosition();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1); A.add(3);A.add(5);A.add(6);
        System.out.print(a.position(A, 17));
    }

    public int position(ArrayList<Integer> a, int b){
        
        int ans = 0;
        int l = 0;
        int r = a.size()-1;
        if(a.get(r)<b)
            return a.size();
        while(l<=r){
            int mid = l + (r-l) / 2;
            if(a.get(mid) == b)
                return mid;

            if(a.get(mid) < b){
                l = mid+1;
            }

            if(a.get(mid) > b){
                r = mid-1;
                ans = mid;
            }
        }

        return ans;
    }
}
