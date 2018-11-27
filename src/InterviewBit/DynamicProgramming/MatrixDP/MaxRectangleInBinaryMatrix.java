package InterviewBit.DynamicProgramming.MatrixDP;

import InterviewBit.DynamicProgramming.Practice.LongestCommonSubsequence;

import java.util.*;

public class MaxRectangleInBinaryMatrix {
    public static void main(String[] args) {
        MaxRectangleInBinaryMatrix a = new MaxRectangleInBinaryMatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        ArrayList<Integer> E = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1));
        ArrayList<Integer> F = new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        ArrayList<Integer> G = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        ArrayList<Integer> H = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        ArrayList<Integer> I = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0));
        ArrayList<Integer> J = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1));
        ArrayList<Integer> K = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1));
        ArrayList<Integer> L = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        ArrayList<Integer> M = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        ArrayList<Integer> N = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1));
        ArrayList<Integer> O = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1));
        ArrayList<Integer> P = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1));

        A.add(B);A.add(C);A.add(D);A.add(E);A.add(F);A.add(G);A.add(H);
        A.add(I);A.add(J);A.add(K);A.add(L);A.add(M);A.add(N);A.add(O);A.add(P);
        System.out.println(a.maxRectangle(A));

    }

    public int maxRectangle(ArrayList<ArrayList<Integer>> A) {
        int[] memo = new int[A.get(0).size()];

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if(A.get(i).get(j)==0)
                    memo[j] =0;
                else
                    memo[j] += A.get(i).get(j);

            }
            max = Math.max(max, maxAreaUnderHistogram(memo));

        }

        return max;
    }

    private static int maxAreaUnderHistogram(int[] memo) {
        int maxArea = 0;int area;
        Stack<Integer> stack = new Stack<>();
        int i;
        for (i = 0; i < memo.length; i++) {
            if (stack.empty() || memo[i] >= memo[stack.peek()])
                stack.push(i);
            else {
                while (!stack.empty() && memo[stack.peek()] > memo[i]) {
                    int topIndex = stack.pop();
                    int height = memo[topIndex];
                    int width = stack.empty() ? i : i - stack.peek() - 1;
                    area = height * width;
                    maxArea = Math.max(maxArea, area);
                }
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            int topIndex = stack.pop();
            int height = memo[topIndex];
            int width = stack.empty() ? i : i - stack.peek() - 1;
            area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
