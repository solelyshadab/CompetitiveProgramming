package InterviewBit.Math;
import java.util.*;

public class FizzBuzz {
    public static void main(String[] arg) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
    }

    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> ansList = new ArrayList<>();

        for (int i = 1;i <= A; i++){
            String in = "";

            if (i % 3 == 0)
                in += "Fizz";

            if (i % 5 == 0)
                in += "Buzz";

            if (i%3!=0 && i%5!=0)
                in = Integer.toString(i);

            ansList.add(in);
        }
        return ansList;
    }


}
