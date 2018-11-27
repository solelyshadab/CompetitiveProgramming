package InterviewBit.Strings;

public class MultiplyStrings {
    public static void main(String[] args){
        MultiplyStrings a = new MultiplyStrings();
        System.out.println(a.multiply("1235421415454545454545454544","1714546546546545454544548544544545"));
    }
    //123 - A
    //456 - B
    public String multiply(String A, String B){
        if(A.equals("0") || B.equals("0"))
            return "0";
        String ans ="";

        int addLastZero = 0;  int b; int a; int product;
        for(int i = B.length()-1; i >=0; i--){
            StringBuilder sb = new StringBuilder();int carry = 0;
              for(int j = A.length()-1; j >=0 ; j--){

               b = B.charAt(i) - '0';
               a = A.charAt(j) - '0';
               product = (b * a) + carry;

               if(product >= 10)
                   carry = product / 10;
               else
                   carry = 0;
               sb.append(product % 10);
              }
            if(carry !=0)
                sb.append(carry);
              sb.reverse();

              for(int n = 0; n < addLastZero ; n++){
                  sb.append(0);
              }
              addLastZero++;
              if(ans.length() >0){
                  ans = addStrings(ans, sb.toString());
              }else {
                  ans = sb.toString();
              }
        }
        int startIndex = 0;
        while(ans.charAt(startIndex) == '0'){
            startIndex++;
        }
        return ans.substring(startIndex);
    }
    //456
    //789
    private String addStrings(String A, String B){
        StringBuilder sb = new StringBuilder();
        int n = Math.min(A.length(), B.length());
        int carry = 0; int sum = 0;
        for(int i = 0; i < n ; i++){
            sum = (A.charAt(A.length() - 1 - i) -'0') + (B.charAt(B.length() -1 - i) - '0') + carry;
            if(sum >=10)
                carry = sum / 10;
            else
                carry = 0;
            sb.append(sum % 10);
        }
        String rem = "";
        if(A.length() > n){
            String remaining = A.substring(0, A.length() - n);
            sum = carry + Integer.parseInt(remaining);
            rem += sum;
        }
        else if(B.length() > n){
            String remaining = B.substring(0, B.length() - n);
            sum = carry + Integer.parseInt(remaining);
            rem += sum;
        }

        if(rem.length() >0)
            return rem + sb.reverse().toString();
        else
            return carry + sb.reverse().toString();

    }
}
