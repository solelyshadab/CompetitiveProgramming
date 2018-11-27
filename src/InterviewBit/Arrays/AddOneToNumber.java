package InterviewBit.Arrays;

import java.util.*;

public class AddOneToNumber {
    public static void main(String[] args){
        AddOneToNumber a = new AddOneToNumber();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);list.add(9);list.add(9);
        System.out.println(Arrays.toString(a.plusOne(list).toArray()));
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        boolean complete = false;
        for(int i = A.size()-1; i >=0; i--){

            if(A.get(i) == 9){
                A.set(i,0);
            }
            else {
                A.set(i, A.get(i) +1);
                complete = true;
                break;
            }

        }
        if(!complete){
            A.add(0,1);
        }


        while (A.get(0) ==0){
            A.remove(0);
        }

        return A;
    }
}
