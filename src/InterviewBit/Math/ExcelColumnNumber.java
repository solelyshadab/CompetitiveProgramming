package InterviewBit.Math;

public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int ans = 0;

        for(int i = 0; i < A.length(); i++){

            char ch = A.charAt(i);
            int index = A.length() - i -1 ;
            int n = ch - 'A' + 1;
            ans += n * Math.pow(26, index);
        }

        return ans;
    }
}
