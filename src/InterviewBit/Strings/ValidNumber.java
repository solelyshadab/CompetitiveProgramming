package InterviewBit.Strings;

public class ValidNumber {
    public static void main(String[] args){
        ValidNumber a = new ValidNumber();
        System.out.println(a.isValidNumber("0.1"));
    }
    // Solution 1: My answer, proud to say it is correct...
    public int isValidNumber(String A){

        if(A==null || A.isEmpty())
            return 0;

        boolean gotDot = false; boolean gotE = false; boolean gotNum = false;

        int i  =0;
        while(i < A.length() && Character.isWhitespace(A.charAt(i)))
            i++;


        for(; i < A.length(); i++){
            char ch = A.charAt(i);

            if( (ch >= '0' && ch <= '9') || ch == 'e')
                gotNum = true;

            if(ch ==' '){
                int j = i;
                while(j < A.length() && Character.isWhitespace(A.charAt(j)))
                    j++;

                if(j>= A.length())
                    break;
                else
                    return 0;
            }

            if(ch  < '0' || ch > '9'){
                if(ch == '.' || ch == '+' || ch == '-' || ch == 'e'){

                }else
                    return 0;
            }

            if(ch=='e'){
                if(gotE || i > A.length()- 3 )
                    return 0;

                if (A.charAt(i+1) == '-' || A.charAt(i+1) == '+'){
                    if( i < A.length() - 3 && A.charAt(i+2)>= '0' && A.charAt(i+2) <= '9'
                            && A.charAt(i+3) >= '0' && A.charAt(i+3) < '9'){
                        gotE = true;
                    }else
                        return 0;
                }else if (A.charAt(i+1)>= '0' && A.charAt(i+1) <= '9'
                        && A.charAt(i+2) >= '0' && A.charAt(i+2) < '9' ){
                    gotE = true;
                }else return 0;

            }

            if(ch =='.'){
                if((gotE && !gotDot) || gotDot || i > A.length()-2)
                    return 0;

                else
                    gotDot = true;
            }

        }

        return gotNum ? 1 : 0;
    }


    // Solution 2: google answer
    public int isNumber(final String A) {

        if(A == null || A.length() == 0 || A.charAt(A.length()-1) == '.' )
            return 0;
        int i = 0;
        int dot = 0;
        int e = 0;
        int num = 0;
        char temp = A.charAt(i);

        if(temp == '+' || temp == '-' || temp == ' ')
            i++;
        while(i < A.length()){
            temp = A.charAt(i);

            if((temp >= '0' && temp <= '9') ){
                num++;
            }
            else if(temp == '+' || temp == '-'|| temp == ' '){

            }
            else if(temp == '.' && i < A.length()-1 && (A.charAt(i+1) >= '0' && A.charAt(i+1) <= '9')){
                if(e > 0)
                    return 0;
                else
                    dot++;
            }
            else if(temp == 'e'){
                e++;
            }
            else
                return 0;
            i++;
        }

        if(num < 1) return 0;
        if(dot > 1 || e > 1) return 0;

        return 1;
    }
}
