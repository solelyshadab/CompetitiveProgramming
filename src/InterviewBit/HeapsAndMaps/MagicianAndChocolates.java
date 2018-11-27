package InterviewBit.HeapsAndMaps;
import java.util.*;

public class MagicianAndChocolates {
    public static void main(String[] args){
        MagicianAndChocolates a = new MagicianAndChocolates();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList( 2147483647, 2000000014, 2147483647));
        System.out.println(a.nchoc(10, B));
     }


    public int nchoc(int A, ArrayList<Integer> B) {
        long ans = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i < B.size(); i++){
            priorityQueue.offer(B.get(i));
        }

        while(A > 0){
            int maxBag = priorityQueue.poll();

            ans += maxBag;

            priorityQueue.offer(maxBag/2);

            A--;

        }

        return (int)(ans % 1000000007);
    }
}
