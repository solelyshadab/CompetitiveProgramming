package InterviewBit.Math;

public class ExcelColumnTitle {
    public String convertToTitle(int A) {

        String ans = "";
        while(A > 0){

            int rem = A % 26;
            if(rem == 0){
                ans = "Z" + ans;
                A = A /26-1;
            }else{
                char ch = (char) ('A' + rem - 1) ;
                ans = ch + ans;
                A = A /26;
            }
        }
        return ans;
    }
}
