package InterviewBit.Arrays;
import java.util.*;

public class MaximumUnsortedSubarray {
    public static void main(String[] args){
        MaximumUnsortedSubarray a = new MaximumUnsortedSubarray();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5));
        System.out.println(a.subUnsort(A));
    }

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int l = 0; int r = A.size()-1; int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for(l = 0; l < n -1 ; l++ ){
            if(A.get(l) > A.get(l+1)){
                break;
            }
        }
        if(l == n-1){
            ans.add(-1);
            return ans;
        }

        for(r = n-1 ; r > 0 ; r--){
            if(A.get(r) < A.get(r-1)){
                break;
            }
        }

        int max = A.get(l); int min = A.get(l);

        for(int i = l ; i <= r ; i++){
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        for(int i = 0; i < l; i++){
            if(A.get(i) > min){
                l = i;
                break;
            }
        }

        for(int i = n -1; i > r; i--){
            if(A.get(i) < max){
                r = i;
                break;
            }
        }

        ans.add(l); ans.add(r);

        return ans;

    }

    private static ArrayList<Integer> quickSort(ArrayList<Integer> A, int l, int r){
        if(l>=r)
            return A;
        int pIndex = new Random().nextInt(r-l) + l;

        int temp = A.get(l);
        A.set(l, A.get(pIndex));
        A.set(pIndex, temp);

        int i = l+1;
        for(int j = l+1 ; j <= r ; j++ ){

            if(A.get(j) < A.get(l)){
                int temp1 = A.get(j);
                A.set(j, A.get(i));
                A.set(i, temp1);
                i++;
            }

        }

        int temp2 = A.get(l);
        A.set(l, A.get(i-1));
        A.set(i-1, temp2);

        quickSort(A, l, i-2);
        quickSort(A, i, r);

        return A;

    }

}
