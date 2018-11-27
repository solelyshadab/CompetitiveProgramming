package InterviewBit.Arrays;

import java.util.*;

public class MAXSPPROD {

    public static void main(String[] args){
        MAXSPPROD a = new MAXSPPROD();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);list.add(9);list.add(6);
        list.add(8);list.add(6);list.add(4);
        list.add(6);list.add(9);list.add(5);
        list.add(4);list.add(9);
        //list.add(1);
        System.out.println(a.maxSpecialProduct(list));
    }
    // Solution1: My solution, accepted by interviewbit...
    public int maxSpecialProduct(ArrayList<Integer> A) {

        ArrayList<int[]> integerData = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        //stack.add(0);

        for(int i = 0; i < A.size(); i++){
            int[] array = new int[2];
            int size = stack.size();

            if (size>0) {

                while ((long)A.get(i) >= (long)A.get(stack.get(size - 1))) {
                    stack.remove(size - 1);
                    size--;
                    if (size<=0)
                        break;
                }
            }

            if(size == 0){
                array[0] = 0;
            }
            else {
                array[0] = stack.get(size-1);
            }
            stack.add(i);

            integerData.add(i,array);
        }

        stack.clear();
        //stack.add(A.size()-1);

        for(int i = A.size()-1; i >=0; i--){
            int[] array = integerData.get(i);
            int size = stack.size();

            if (size>0) {

                while ((long)A.get(i) >= (long)A.get(stack.get(size - 1))) {
                    stack.remove(size - 1);
                    size--;
                    if (size<=0)
                        break;
                }
            }

            if(size == 0){
                array[1] = 0;
            }
            else {
                array[1] = stack.get(size-1);
            }
            stack.add(i);

            integerData.set(i,array);
        }

        long finalProduct = 0;
        for(int i = 0 ; i < integerData.size() ; i++){
            long leftIndexValue =  integerData.get(i)[0];
            long rightIndexValue =  integerData.get(i)[1];


        if(rightIndexValue * leftIndexValue > finalProduct) {
                finalProduct = rightIndexValue * leftIndexValue;
            }

        }

        return (int)(finalProduct%1000000007);
    }
    // Solution2 : Interviewbit solution..
    public int maxSpecialProduct1(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        for(int i = 1; i < n; i++){
            while(!q.isEmpty()){
                if(A.get(q.getLast()) > A.get(i)) break;
                q.removeLast();
            }
            left[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }
        q = new ArrayDeque<>();
        q.addLast(n - 1);
        for(int i = n - 2; i >= 0; i--){
            while(!q.isEmpty()){
                if(A.get(q.getLast()) > A.get(i)) break;
                q.removeLast();
            }
            right[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }
        long mx = -1;
        for(int i = 0; i < n; i++){
            mx = Long.max(mx, 1L * left[i] * right[i]);
        }
        return (int)(mx % 1000000007);
    }

}
