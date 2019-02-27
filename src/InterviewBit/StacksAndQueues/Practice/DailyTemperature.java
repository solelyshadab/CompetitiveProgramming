package InterviewBit.StacksAndQueues.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(73, 74, 75, 71, 69, 72, 76, 73));
        System.out.println(maxTemp(A));
    }
    // 73, 74, 75, 71, 69, 72, 76, 73
    // 1,  1    4  2   1   1   0   0
    private static ArrayList<Integer> maxTemp(ArrayList<Integer> A){
        int[] ans = new int[A.size()];
        Stack<Integer> stack = new Stack();

        for(int i = A.size()-1; i >=0; i--){

            while (!stack.empty() && A.get(i) >= A.get(stack.peek()))
                stack.pop();

            if (stack.empty())
                ans[i] = 0;
            else {
                ans[i] = stack.peek() - i;
            }
            stack.add(i);
        }

        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i = 0; i < ans.length; i++)
            ansList.add(ans[i]);
        return ansList;
    }
}
