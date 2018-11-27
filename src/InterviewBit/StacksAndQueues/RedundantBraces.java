package InterviewBit.StacksAndQueues;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args){
       RedundantBraces a = new RedundantBraces();
        System.out.println(a.checkRedundantBrackets("(a*b)+(b*(d+(a)))"));
        System.out.println(a.checkRedundantBrackets("(a+((b*c)+c))"));
        System.out.println(a.checkRedundantBrackets("((a+b))"));
    }

    public int checkRedundantBrackets(String A){
        A = A.trim();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            if(ch != ')'){
               stack.push(ch);
            }
            else {
                boolean isOperatorFound = false;
                char top = stack.peek();
                while(top != '('){
                    if(top == '+' || top == '-' || top == '*' || top == '/')
                        isOperatorFound = true;

                    top = stack.pop();
                }
                if(!isOperatorFound)
                    return 1;
            }

        }
        return 0;
    }
    // This solution is also correct, but above one looks better to understand
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        A = A.trim();
        for (int i = 0; i < A.length(); i++) {

            char c = A.charAt(i);

            if (c != ')')
                stack.push(c);
            else {
                boolean isOperatorFound = false;
                while (stack.peek() != '(') {
                    if (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')
                        isOperatorFound = true;
                    stack.pop();
                }

                stack.pop();
                if(!isOperatorFound)
                    return 1;

            }
        }
        return 0;
    }
}
