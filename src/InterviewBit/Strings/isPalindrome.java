package InterviewBit.Strings;

public class isPalindrome {
    public static void main(String[] args){
        isPalindrome a = new isPalindrome();
        System.out.println(a.isPalindrome("1a2"));
    }

    public int isPalindrome(String A) {
        boolean isDigit = Character.isDigit(A.charAt(0));
        int countOfValidChars = 0;
        int l =0;
        int r = A.length()-1;
        while(l < r){
            if(Character.isLetterOrDigit(A.charAt(l)) &&
                    Character.isLetterOrDigit(A.charAt(r))){
                countOfValidChars++;
                if(Character.toLowerCase(A.charAt(l)) !=
                        Character.toLowerCase(A.charAt(r))){
                    return 0;
                }else{
                    l++;
                    r--;
                    continue;
                }
            }
            if(!Character.isLetterOrDigit(A.charAt(l))){
                l++;
            }
            if(!Character.isLetterOrDigit(A.charAt(r))){
                r--;
            }


        }
        if(countOfValidChars >0)
        return 1;
        else return 0;
    }
}
