package InterviewBit.Strings;

public class MinCharToMakeStringPalindromic {
    public static void main(String[] args){
        MinCharToMakeStringPalindromic a = new MinCharToMakeStringPalindromic();
        System.out.println(a.minChar("AAAAAA"));
    }

    //Solution 2: Based on KMP Algorithm, Requires O(N)
    public int minChar(String A){

        int[] lpsArray = lpsArray(A +"$"+ new StringBuilder(A).reverse());

     return A.length() - lpsArray[lpsArray.length-1];
    }

    private static int[] lpsArray(String pattern){
        int[] lpsArray = new int[pattern.length()];
        lpsArray[0] = 0;
        int j = 0;

        for(int i =1; i < pattern.length();i++){
            if(pattern.charAt(i) == pattern.charAt(j) ){
                j++;
                lpsArray[i] = j;
            }else {
                if(j>0){
                    j = lpsArray[j-1];
                    i--;
                }else {
                    j =0;
                    lpsArray[i] = 0;
                }
            }
        }
        return lpsArray;
    }


    // Solution 1: Naive, requires O(n*n)
    public int solution(String A){
        int count = 0;

        while(A.length()>0){
            if(isPalindrome(A)){
                break;
            }else{
                A = A.substring(0, A.length()-1);
                count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String A){
        int l = 0;
        int r = A.length()-1;

        while(l < r){
            if(A.charAt(l) != A.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
