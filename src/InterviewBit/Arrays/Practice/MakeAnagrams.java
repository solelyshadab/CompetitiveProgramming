package InterviewBit.Arrays.Practice;

import java.util.Arrays;

public class MakeAnagrams {
    public static void main(String[] args){
        System.out.println(makeAnagram("cde","abc"));
    }
    static int makeAnagram(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(b1);
        int sameCount = 0; int n = a1.length; int m = b1.length;
        int i = 0; int j = 0;
        while(i < n && j < m){
            if(a1[i] == b1[j]){
                i++;
                j++;
                sameCount++;
            }else if(a1[i] < b1[j]){
                i++;
            }else {
                j++;
            }

        }

        return ((n+m) - (2 * sameCount));
    }
}
