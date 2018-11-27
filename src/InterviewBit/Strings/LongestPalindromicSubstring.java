package InterviewBit.Strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
        LongestPalindromicSubstring a = new LongestPalindromicSubstring();
        System.out.println(a.solve("abcdeeee"));
    }

    public int solve(String A){
        int maxOdd = 1; int maxEven = 0; int indexOdd = 0; int indexEven = 0;
        int currLen;

        for(int i = 0; i < A.length(); i++){
            int l = i-1; int r = i+1;
            currLen =1;
            while(l>=0 && r< A.length()){
                if(A.charAt(l)== A.charAt(r)){
                    currLen+=2;
                    if(currLen > maxOdd){
                        maxOdd = currLen;
                        indexOdd = l;
                    }
                    l--; r++;
                }else break;
            }
            l = i; r = i+1; currLen =0;
            while(l>=0 && r< A.length()){
                if(A.charAt(l)== A.charAt(r)){
                    currLen+=2;
                    if(currLen > maxEven){
                        maxEven = currLen;
                        indexEven = l;
                    }
                    l--; r++;
                }else break;
            }

        }
        if(maxEven > maxOdd) {
            printMaxPalindrome(A, indexEven, maxEven);
            return indexEven;
        }
        else {
            printMaxPalindrome(A, indexOdd, maxOdd);
            return indexOdd;
        }


    }

    private void printMaxPalindrome(String A, int l, int length){

        System.out.println(A.substring(l, l + length));
    }
}
