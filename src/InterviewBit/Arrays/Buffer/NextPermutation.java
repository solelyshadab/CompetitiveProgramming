package InterviewBit.Arrays.Buffer;

import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation a = new NextPermutation();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);
        list.add(5);list.add(6);list.add(7);
        System.out.println(a.nextPermutation(list));
    }


    public ArrayList<Integer> nextPermutation(ArrayList<Integer> a) {
        int n = a.size();

        int k = -1;
        int l = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            Collections.sort(a);
            return a;
        }

        for (int i = k + 1; i < n; i++) {
            if (a.get(i) > a.get(k))
                l = i;
        }

        int temp = a.get(k);
        a.set(k, a.get(l));
        a.set(l, temp);

        int last = n - 1;
        int j = k + 1;
        while (j <= last) {
            temp = a.get(j);
            a.set(j, a.get(last));
            a.set(last, temp);
            j++;
            last--;
        }

        return a;
    }
}
