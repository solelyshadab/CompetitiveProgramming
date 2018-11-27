package InterviewBit.Arrays;
import java.util.*;

public class LargestNumber {
    public static void main(String[] args){
        LargestNumber a = new LargestNumber();
        List<Integer> A = new ArrayList<>(Arrays.asList(54,546,548,60));
        System.out.println(a.largestNumber(A));
    }

    public String largestNumber(final List<Integer> A){
        List<String> list = new ArrayList<>();

        for(int i =0; i < A.size(); i++){
            list.add("" + A.get(i));
        }
        Comparator<String> comp = new MyComparator();
        Collections.sort(list,comp );

        int sum =0;
        StringBuilder ans = new StringBuilder();
        for(int i = list.size() -1 ; i >=0; i--){
            ans.append(list.get(i));
            sum += Integer.parseInt(list.get(i));
        }

        return sum == 0 ? "0" : ans.toString();
    }

    class MyComparator implements Comparator<String>{

        @Override
        public int compare(String a, String b){
            String ab = a+b;
            String ba = b+a;

            return ab.compareTo(ba);

        }

    }

}
