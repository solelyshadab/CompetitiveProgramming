package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.ArrayList;

public class SumOfFibonacciNumbers {
    public static void main(String[] args){
        SumOfFibonacciNumbers a = new SumOfFibonacciNumbers();
        System.out.println(a.fibsum(2));
    }

    public int fibsum(int n) {
        int count = 0;

        ArrayList<Integer> fibList = findFibs(n);
        int index = fibList.size()-1;

        while (n >0){

            count += n / fibList.get(index);
            n = n % fibList.get(index);

            index--;
        }

        return count;
    }

    private ArrayList<Integer> findFibs(int K){
        ArrayList<Integer> list = new ArrayList<>();

        int a = 1; int b = 1;

        int nextTerm;
        list.add(a);list.add(b);

        while (true){

            nextTerm = a+b;

            if(nextTerm >K)
                break;

            list.add(nextTerm);
            a = b;
            b = nextTerm;
        }

        return list;
    }
}
