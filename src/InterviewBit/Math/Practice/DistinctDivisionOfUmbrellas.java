package InterviewBit.Math.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistinctDivisionOfUmbrellas {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(2,4));
        int noOfPeople = 8;
        System.out.println("No of people: "+noOfPeople+" count : "+minUmbrellasReq(list, noOfPeople));
    }

    private static int minUmbrellasReq(List<Integer> list, int n){
        Collections.sort(list,Collections.reverseOrder());
        int count = 0;
        for(int i =0; i < list.size(); i++){
            count += n / list.get(i);
            n = n % list.get(i);

            if(n == 0)
                return count;
        }

        return -1;
    }
}
