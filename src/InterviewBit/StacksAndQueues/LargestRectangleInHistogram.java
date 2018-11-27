package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args){
        LargestRectangleInHistogram a = new LargestRectangleInHistogram();
        ArrayList<Integer> A = new ArrayList<>();
        //A.add(3);A.add(2);A.add(5);A.add(6);
        //A.add(1);A.add(4);A.add(4);
        A.add(1);A.add(0);A.add(1);
        System.out.println(a.solution(A));
    }

    public int solution(ArrayList<Integer> A){
        if(A.size()==0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < A.size()){
            if(stack.empty() || A.get(i) >= A.get(stack.peek())){
               stack.push(i++);
            }else{
                int top = stack.pop();
                int width = stack.empty() ?  i : i - 1 - stack.peek() ;
                maxArea = Math.max(maxArea, A.get(top) * width );
            }
        }

        while(!stack.empty()){
            int top = stack.pop();
            int width = stack.empty() ?  i : i - 1 - stack.peek() ;
            maxArea = Math.max(maxArea, A.get(top) * width );
        }

        return maxArea;
    }
}
