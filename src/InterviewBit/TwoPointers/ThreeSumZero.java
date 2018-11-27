package InterviewBit.TwoPointers;
import java.util.*;

public class ThreeSumZero {
    public static void main(String[] args) {
        ThreeSumZero a = new ThreeSumZero();

    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Collections.sort(A);

        int l;
        int r;
        int n = A.size();
        for (int i = 0; i < n - 1; i++) {
            l = i + 1;
            r = n - 1;
            while (l < r) {
                int x = A.get(i);
                int y = A.get(l);
                int z = A.get(r);
                if (x + y + z == 0) {
                    String string = "" + x + y + z;
                    if (!set.contains(string)) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(x);
                        ans.add(y);
                        ans.add(z);
                        ansList.add(ans);
                        set.add(string);
                    }
                    l++;
                    r--;
                } else if ((x + y + z) > 0)
                    r--;
                else
                    l++;
            }
        }

        return ansList;
    }
}
