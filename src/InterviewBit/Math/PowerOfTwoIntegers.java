package InterviewBit.Math;

public class PowerOfTwoIntegers {
    public static void main(String[] args){
        PowerOfTwoIntegers a = new PowerOfTwoIntegers();
        System.out.println(a.isPower(1024000000));
    }
    // Accepted solution by InterviewBit
    public int isPower(int A) {
        if(A==1)
            return 1;
        for(int i = 2; i <= Math.sqrt(A); i++ ) {
            int x = A;
            while(x % i == 0){
                x /=i;
                if(x==1)
                    return 1;

            }
        }
        return 0;
    }

     //Below solution works only on small value of A
    /*public int isPower(int A) {
        if(A==1)
            return 1;
        for(int x = 2; x <= Math.sqrt(A); x++ ){
            int p = x;
            while(p <= A){
                p = p*x;
                if(p == A)
                    return 1;
            }
        }
        return 0;
    }*/

    /* Did not work for some A.
    public int isPower(int A) {
        if(A==1)
            return 1;
        for(int x = 2; x <= Math.sqrt(A); x++ ){
            float f = (float)Math.log(A) /
                    (float) Math.log(x);

            if ((f - (int)f) == 0.0)
                return 1;
        }
        return 0;
    }*/


    }



