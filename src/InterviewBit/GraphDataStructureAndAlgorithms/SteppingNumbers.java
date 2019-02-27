package InterviewBit.GraphDataStructureAndAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {
    public static void main(String args[])
    {
        int n = 0, m = 21;
        System.out.println(displaySteppingNumbers(n,m));

    }

    public static ArrayList<Integer> displaySteppingNumbers(int n, int m)
    {
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0 ; i <= 9 ; i++) {
            ansList.addAll(bfs(n, m, i));
        }
        return ansList;
    }

    public static ArrayList<Integer> bfs(int n,int m,int num)
    {
        ArrayList<Integer> ansList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(num);

        while (!q.isEmpty())
        {

            int stepNum = q.poll();

            // If the Stepping Number is in
            // the range [n,m] then display
            if (stepNum <= m && stepNum >= n)
            {
                //System.out.print(stepNum + " ");
                ansList.add(stepNum);
            }

            // If Stepping Number is 0 or greater
            // then m ,need to explore the neighbors
            if (stepNum == 0 || stepNum > m)
                continue;

            // Get the last digit of the currently
            // visited Stepping Number
            int lastDigit = stepNum % 10;

            // There can be 2 cases either digit
            // to be appended is lastDigit + 1 or
            // lastDigit - 1
            int stepNumA = stepNum * 10 + (lastDigit- 1);
            int stepNumB = stepNum * 10 + (lastDigit + 1);

            // If lastDigit is 0 then only possible
            // digit after 0 can be 1 for a Stepping
            // Number
            if (lastDigit == 0)
                q.add(stepNumB);

                // If lastDigit is 9 then only possible
                // digit after 9 can be 8 for a Stepping
                // Number
            else if (lastDigit == 9)
                q.add(stepNumA);

            else
            {
                q.add(stepNumA);
                q.add(stepNumB);
            }
        }
        return ansList;
    }
}
