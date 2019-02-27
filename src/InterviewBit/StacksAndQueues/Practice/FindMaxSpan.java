package InterviewBit.StacksAndQueues.Practice;

import java.util.*;

public class FindMaxSpan {
    public static void main(String[] args){
        FindMaxSpan a = new FindMaxSpan();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(6);A.add(3);A.add(4);
        A.add(5);A.add(2);
        System.out.println(Arrays.toString(a.solution(A).toArray()));
    }
    // 6 3 4 5 2
    // 1 1 2 3 1
    public ArrayList<Integer> solution(ArrayList<Integer> A){

        ArrayList<Integer> ansList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int p =0;
        for(int i = 0; i < A.size(); i++){
            if(!stack.empty() && A.get(i) >= A.get(stack.peek())){
                stack.pop();
            }
            p = stack.empty() ? -1 : stack.peek();
            ansList.add(i - p);
            stack.push(i);
        }

        return ansList;
    }
}
