package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;

public class RainWaterTrapped {
    public static void main(String[] args){
        RainWaterTrapped a = new RainWaterTrapped();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3,0,0,2,0,4));
        System.out.println(a.solve(A));
    }

    //Solution2: space optimization of below solution
    public int solve(ArrayList<Integer> A){
        int ans = 0;
        int l = 0; int r = A.size()-1;
        int leftMax = 0; int rightMax = 0;


        while(l<=r){
            if(A.get(l) < A.get(r) ){
                if(A.get(l) > leftMax){
                    leftMax = A.get(l);
                }else{
                    ans += leftMax - A.get(l);
                }
                l++;

            }else{
                if(A.get(r)> rightMax){
                    rightMax = A.get(r);
                }else
                {
                    ans += rightMax - A.get(r);
                }
                r--;
            }
        }

        return ans;
    }

    // Solution1:
    public int solve1(ArrayList<Integer> A){
        int ans = 0;
        int[] leftMax = new int[A.size()];
        int[] rightMax = new int[A.size()];

        leftMax[0] = A.get(0);
        for(int i = 1; i < A.size(); i++){
            leftMax[i] = Math.max(leftMax[i-1], A.get(i));
        }
        rightMax[A.size()-1] = A.get(A.size()-1);
        for(int i = A.size()-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], A.get(i));
        }
        System.out.println("LeftMax: " + Arrays.toString(leftMax));
        System.out.println("RightMax: " +Arrays.toString(rightMax));
        for(int i = 0; i < A.size() ; i++){
            int height = Math.min(leftMax[i], rightMax[i]);
            int area = height - A.get(i);
            System.out.println("Water stored at index " + i +" is: " + area);
            if(area>0){
                ans+= area;
            }
        }

        return ans;
    }


}
