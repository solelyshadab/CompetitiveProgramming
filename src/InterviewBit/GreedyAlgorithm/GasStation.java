package InterviewBit.GreedyAlgorithm;

import java.util.*;

public class GasStation {
    // GeeksforGeeks solution, uses sliding window
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        if(A.size()==1)
            return 0;
        int start = 0;
        int end = 1;
        int curr_Gas;
        int n = A.size();

        curr_Gas = A.get(start) - B.get(start);

        while(start !=end || curr_Gas < 0){

            while(start !=end && curr_Gas < 0){

                curr_Gas -= A.get(start) - B.get(start);
                start = (start+1) % n;

                if(start==0)
                    return -1;
            }

            curr_Gas += A.get(end) - B.get(end);
            end = (end+1)%n;

        }
        return start;

    }

    //InterviewBit Solution
    public int canCompleteCircuit1(final List<Integer> gas, final List<Integer> cost) {
        int currentFuel = 0;
        int remaining = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < gas.size(); i++){
            remaining = gas.get(i) - cost.get(i);
            if(currentFuel >= 0)
                currentFuel += remaining;
            else{
                currentFuel = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }
}
