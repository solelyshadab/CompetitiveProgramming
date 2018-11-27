package InterviewBit.Strings;

public class ImplementStrStr {
    public static void main(String[] args){
        ImplementStrStr a = new ImplementStrStr();
        System.out.println(a.strStr1("peeksforgeeks", "geeks"));
    }
    //Solution 1: Naive solution
    public int strStr(String text, String pattern){
        int n = text.length(); int m = pattern.length();

        for(int i =0; i < n-m+1; i++){
            if(text.charAt(i) == pattern.charAt(0)){
                int j =0;
                while(j < m && text.charAt(i) == pattern.charAt(j)){
                    i++;
                    j++;
                }

                if(j == m)
                    return i-m;
            }

        }
        return -1;
    }


    //Solution2 : Using KMP alogithm
    public int strStr1(String text, String pattern){
        
        int n = text.length(); int m = pattern.length();
        int[] lps = findLps(pattern);

        int i =0; int j = 0;
        while( i < n){
            if(text.charAt(i)== pattern.charAt(j)){
                i++;
                j++;
            }

            if(j==m){
                return i-j;
            }

            else if( i < n && text.charAt(i) != pattern.charAt(j)){
                if(j>0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }

        return -1;
    }


    private static int[] findLps(String pattern){
        int[] lps = new int[pattern.length()];
        lps[0] = 0; int j =0;

        int i = 1;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else {
                if(j>0){
                    j = lps[j-1];
                }else {
                    lps[i] = j;
                    i++;
                }
            }

        }
    return lps;

    }

}
