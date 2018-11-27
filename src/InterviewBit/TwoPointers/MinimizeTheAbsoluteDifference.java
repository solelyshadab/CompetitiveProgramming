package InterviewBit.TwoPointers;

import java.util.ArrayList;

public class MinimizeTheAbsoluteDifference {
    public static void main(String[] args){
        MinimizeTheAbsoluteDifference a = new MinimizeTheAbsoluteDifference();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        A.add(1);A.add(4);A.add(10);
        B.add(2);B.add(15);B.add(20);
        C.add(10);C.add(12);
        System.out.println(a.solution(A,B,C));
    }

    public int solution(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C){
        int i =0, j =0, k =0;
        int ans = 0;
        ArrayList<Integer> ansList = new ArrayList<>();
        int ans_i =0, ans_j = 0, ans_k = 0, diff = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size() && k < C.size()){
            int minimumOFThree = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int maximumOFThree = Math.max(A.get(i),Math.max(B.get(j), C.get(k)));
            

            if(maximumOFThree - minimumOFThree < diff) {
                diff = maximumOFThree - minimumOFThree;
                ans_i = i;
                ans_j = j;
                ans_k = k;
            }

            if(diff==0)
                break;

            if (minimumOFThree == A.get(i))
                i++;
            else if(minimumOFThree == B.get(j))
                j++;
            else k++;

        }

        ansList.add(A.get(ans_i));ansList.add(B.get(ans_j));ansList.add(C.get(ans_k));

    return ans;
    }
}

