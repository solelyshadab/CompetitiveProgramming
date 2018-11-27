package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args){
        EvaluateExpression a = new EvaluateExpression();
        ArrayList<String> A = new ArrayList<>();
        A.add("4");A.add("13");A.add("5");
        A.add("/");A.add("+");
        System.out.println(a.evalRPN(A)); //9
      
    }
    public int evalRPN(ArrayList<String> A) {
        String operators ="+-*/";
    Stack<String> stack = new Stack<>();
        for(int i =0; i < A.size(); i++){
        String value = A.get(i);
        if(!operators.contains(value)){
            stack.push(value);
        }else{
            int num2 = Integer.valueOf(stack.pop());
            int num1 = Integer.valueOf(stack.pop());
            if(value.equals("+")){
                int sum = num1 + num2;
                stack.push(String.valueOf(sum));
            }
            else if(value.equals("-")){
                int diff = num1 - num2;
                stack.push(String.valueOf(diff));
            }
            else if(value.equals("*")){
                int multiply = num1 * num2;
                stack.push(String.valueOf(multiply));
            }
            else if(value.equals("/")){
                int div = num1 / num2;
                stack.push(String.valueOf(div));
            }

        }
    }

        return Integer.valueOf(stack.pop());
}



}








