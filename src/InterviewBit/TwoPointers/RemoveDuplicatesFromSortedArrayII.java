package InterviewBit.TwoPointers;
import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args){
        RemoveDuplicatesFromSortedArrayII a = new RemoveDuplicatesFromSortedArrayII();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0,1,2,2,3,3));
        System.out.println(a.solve(A));
    }
    //0 0 1 1 1 2 2 3 -> 0 0 1 1 2 2 3
    //6 0 1 2 2 3 3
    public int solve(ArrayList<Integer> a){
        if(a == null)
            return 0;
        if(a.size()<=2)
            return a.size();

        int index = 1;

        for(int i =1; i < a.size()-1; i++){
            if(!a.get(i).equals(a.get(i+1))){
                a.set(index, a.get(i));
                index++;
            }
            else if(!a.get(i).equals(a.get(i-1))) {
                a.set(index, a.get(i));
                index++;
            }

            if(i == a.size()-2){
                a.set(index, a.get(i+1));
                index++;
            }

        }
        while(a.size() > index){
            a.remove(a.size()-1);
        }

        System.out.println(a);

        return index;
    }
}
