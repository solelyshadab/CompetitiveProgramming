package InterviewBit.StacksAndQueues;

import java.util.LinkedList;
import java.util.Stack;

public class MinList{
    Stack<Integer> stack;
    int minElement;
    public MinList(){
        stack = new Stack<>();
    }

    public static void main(String[] args){
        MinList min = new MinList();
        min.push(3);
        System.out.println(min.minElement);
        min.push(5);
        System.out.println(min.minElement);
        min.push(2);
        System.out.println(min.minElement);
        min.push(1);
        System.out.println(min.minElement);
        min.push(1);
        System.out.println(min.minElement);
        min.push(-1);
        System.out.println(min.minElement);
        System.out.println("Starting pop now!!");

        min.pop();
        System.out.println(min.minElement);
        min.pop();
        System.out.println(min.minElement);
        min.pop();
        System.out.println(min.minElement);
        min.pop();
        System.out.println(min.minElement);
        min.pop();
        System.out.println(min.minElement);
        min.pop();
        System.out.println(min.minElement);
        min.pop();
        System.out.println(min.minElement);
        min.pop();
        System.out.println(min.minElement);
    }

    public void push(int x){
        if(stack.empty()) {
            stack.push(x);
            minElement = x;
        }
        else if(x >= minElement){
           stack.push(x);
        }
        else{
           int y = 2 * x - minElement;
           stack.push(y);
           minElement = x;
        }
    }
    public int min(){
        return minElement;
    }

    public int pop(){
        if(stack.empty()){
            minElement = Integer.MIN_VALUE;
            System.out.println("StackEmptyException!!");
            return Integer.MIN_VALUE;
        }
        int value = stack.pop();

        if(value < minElement){
            int min = minElement;
            minElement = 2 * minElement - value;
            if(stack.empty())
                minElement = Integer.MIN_VALUE;
            return min;
        }
        else {
            if(stack.empty())
                minElement = Integer.MIN_VALUE;
            return value;
        }
    }

    public int peek(){
        if(stack.empty()) {
            System.out.println("StackEmptyException!!!");
            return Integer.MIN_VALUE;
        }

        if(stack.peek() < minElement){
            return minElement;
        }else
        {
            return stack.peek();
        }

    }


}
