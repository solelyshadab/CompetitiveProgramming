package InterviewBit.Strings.Practice;

public class ImplementStrStr {
    public static void main(String[] args){
        solve("boysboysboysboyz","boys");
    }

    public static void solve(String string, String pattern){
        int n = string.length(); int m = pattern.length();
        System.out.println("string : " + n + " pattern : " + m);
        int[] lpsArray = lps(pattern);

        int i = 0; int j = 0;
        while (i < n){
            if(string.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j==m){
                System.out.println(i - m);
                i = i-j+1;
                j=0;
            }

            if( i < n && j < m && string.charAt(i) != pattern.charAt(j)){
                if (j>0)
                j = lpsArray[j-1];
                else
                    i++;
            }
        }

    }

    private static int[] lps(String A){
        int[] lpsArray = new int[A.length()];

        lpsArray[0] = 0;
        int i = 1; int j = 0;

        while (i < A.length()){
            if(A.charAt(i) == A.charAt(j)){
                j++;
                lpsArray[i] = j;
                i++;
            }else {
                if (j>0){
                    j = lpsArray[j-1];
                }else {
                    lpsArray[i] = j;
                    i++;
                }
            }
        }

        return lpsArray;

    }
}
