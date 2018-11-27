package InterviewBit.Math;

public class PalindromeInteger {
    public static void main(String[] args){
        PalindromeInteger a = new PalindromeInteger();
        System.out.println(a.isPalindrome(-121));
    }

    public int isPalindrome(int N){
        if(N < 0)
            return 0;

        String NString = Integer.toString(N);

        int l = 0;
        int r = NString.length()-1;

        for(int i = l; l < r ; i++){
            if(NString.charAt(l) != NString.charAt(r)){
                return 0;
            }
            l++;
            r--;
        }



        return 1;
    }
}
