package InterviewBit.StacksAndQueues.Practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stackNewestOnTop;
    Stack<Integer> stackOldestOnTop;

    /** Initialize your data structure here. */
    public QueueUsingStack() {
        stackNewestOnTop = new Stack<>();
        stackOldestOnTop = new Stack<>();
    }
    //Solution1: Push in O(n) and pop and peek at O(1) time.
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stackOldestOnTop.empty())
            stackNewestOnTop.push(stackOldestOnTop.pop());

        stackOldestOnTop.push(x);

        while(!stackNewestOnTop.empty())
            stackOldestOnTop.push(stackNewestOnTop.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stackOldestOnTop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!stackOldestOnTop.empty())
            return stackOldestOnTop.peek();

        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOldestOnTop.empty();
    }



//Solution2: push at O(1) time ,and peek and pop at O(n) time..
    public void enqueue(int value) { // Push onto newest stack
        stackNewestOnTop.push(value);
    }

    public int peek1() {
        prepOld();
        return stackOldestOnTop.peek();
    }

    public int dequeue() {
        prepOld();
        return stackOldestOnTop.pop();
    }

    public void prepOld(){
        if (stackOldestOnTop.isEmpty())
            while(!stackNewestOnTop.isEmpty())
                stackOldestOnTop.push(stackNewestOnTop.pop());
    }
}
