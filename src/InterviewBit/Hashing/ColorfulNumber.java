package InterviewBit.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    public static void main(String[] args) {
        ColorfulNumber a = new ColorfulNumber();
        System.out.println(a.isColorful(3245));
    }

    //3245 ->   3 2 4 5 32 24 45 324 245
    public int isColorful(int A) {

        String string = String.valueOf(A);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j <= string.length(); j++) {
                String substring;
                if (j == string.length()) {
                    substring = string.substring(i);
                } else {
                    substring = string.substring(i, j);
                }

                if (substring.length() == string.length())
                    continue;

                int product = 1;
                for (int k = 0; k < substring.length(); k++) {
                    product *= substring.charAt(k) - '0';
                }
                if (set.contains(product)) {
                    return 0;
                } else {
                    set.add(product);
                }
            }

        }
        return 1;
    }

}
