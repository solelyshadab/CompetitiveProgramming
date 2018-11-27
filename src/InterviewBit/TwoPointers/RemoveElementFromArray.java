package InterviewBit.TwoPointers;
import java.util.*;

public class RemoveElementFromArray {
    public static void main(String[] args){
        RemoveElementFromArray a = new RemoveElementFromArray();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,1,1,2,1,3));
        System.out.println("Length is: " + a.removeElement(A,1));
    }

    //Accepted solution..
    public int removeElement1(ArrayList<Integer> a, int b) {
        int i = 0;
        int j = 0;

        while (i<a.size()) {
            if (a.get(i) != b) {
                if (i != j) {
                    a.set(j, a.get(i));
                    a.set(i, b);
                }
                j++;
            }
            i++;
        }

        return j;
    }
    // my solution not accepted..
    public int removeElement(ArrayList<Integer> a, int b) {
        int index = 0;

        for(int i = 0; i < a.size(); i++){
            if(!a.get(i).equals(b)){
                int temp = a.get(i);
                a.set(i, a.get(index));
                a.set(index, temp);
                index++;
            }
        }
        for(int i = 0; i < index; i++)
            System.out.print(a.get(i) + " ");
        return index;
    }
}
