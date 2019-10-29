package InterviewBit.DynamicProgramming;

import java.util.Stack;

/**
 * Created by 609112524 on 30/04/2019.
 */
public class LongestValidParentheses {
    public static void main(String[] args){
        System.out.println(longest("())()"));
    }

    public static int longest(String a){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for(int i = 0 ; i < a.length(); i++){
            if(a.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();

                if(!stack.empty())
                result = Math.max(result, i - stack.peek());

                else
                    stack.push(i);
            }
        }


        return result;
    }
}
