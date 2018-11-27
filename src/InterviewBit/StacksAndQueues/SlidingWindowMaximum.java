package InterviewBit.StacksAndQueues;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args){
        SlidingWindowMaximum a = new SlidingWindowMaximum();
        List<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(3);A.add(1);
        A.add(4);A.add(5);A.add(2);A.add(3);A.add(6);
        System.out.println(Arrays.toString(a.slidingMaximum(A,3).toArray()));
    }
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> ansList = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        if(B > A.size()){
            B = A.size();
        }
        int i;
        for(i =0; i < B ; i++){
            while(!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for( ; i < A.size() ; i++){
            ansList.add(A.get(deque.peekFirst()));

            while(!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())){
                deque.removeLast();
            }

            while(!deque.isEmpty() && deque.peekFirst() <= i - B){
                deque.removeFirst();
            }

            deque.addLast(i);

        }
        ansList.add(A.get(deque.peekFirst()));
        return ansList;

    }
}
