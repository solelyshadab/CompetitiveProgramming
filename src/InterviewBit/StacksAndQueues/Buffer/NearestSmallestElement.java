package InterviewBit.StacksAndQueues.Buffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElement {
    public static void main(String[] args){
        NearestSmallestElement a = new NearestSmallestElement();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(5);A.add(3);
        A.add(6);A.add(1);A.add(2);A.add(5);
        System.out.println(Arrays.toString(a.solution(A).toArray()));
    }
    //1 5 3 6 1 2 5
    public ArrayList<Integer> solution(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ansList = new ArrayList<>();
        ansList.add(-1);
        stack.add(A.get(0));
        for(int i =1; i < A.size(); i++){

            int top = stack.pop();
            while(top >= A.get(i) && !stack.empty()){
                top = stack.pop();
            }
            if(top >= A.get(i)) {
                ansList.add(-1);
                stack.add(A.get(i));
            }

            else {
                ansList.add(top);
                stack.add(top);
                stack.add(A.get(i));
            }
        }

        return ansList;
    }
}
