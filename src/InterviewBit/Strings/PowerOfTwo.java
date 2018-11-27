package InterviewBit.Strings;

public class PowerOfTwo {
    public static void main(String[] args){
        PowerOfTwo a = new PowerOfTwo();
        System.out.println(a.power("1853026348080"));
    }

    public int power(String A) {
        int beginIndex = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) - '0' == 0){
                beginIndex++;
            }else{
                break;
            }
        }

        A = A.substring(beginIndex);

        while(A.length() > 0){
            if(A.length() == 1 && A.charAt(0) - '0' == 2){
                return 1;
            }
            if( (A.charAt(A.length()-1) - '0' ) % 2 != 0){
                return 0;
            }

            int rem = 0;
            StringBuilder newA = new StringBuilder();
            for(int i = 0; i < A.length(); i++){

                int digit = rem * 10 + A.charAt(i) - '0';
                if(digit < 2 && i < A.length() -1){
                    digit = digit * 10 + A.charAt(i+1) - '0';
                    if(i>0){
                        newA.append(0);
                    }
                    i++;
                }

                int quotient = digit / 2 ;
                rem = digit % 2;

                newA.append(quotient);

            }

            A = newA.toString();

        }
        return 1;

    }
}
