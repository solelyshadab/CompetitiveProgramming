package InterviewBit.BitManipulation;

public class DivideIntegers {
    public static void main(String[] args){
        int dividend = -2147483648;
        int divisor = -10000000;
        System.out.println(divide(dividend,divisor));
    }

    public static int divide(int A, int B) {
        long dividend = Math.abs((long)A);
        long divisor = Math.abs((long)B);
        int result = 0;
        int mask = 1;
        if(divisor == 0)
            return Integer.MAX_VALUE;
//        if(divisor == 1)
//            return (int)dividend;
        while(divisor < dividend){
            divisor = divisor << 1;
            mask = mask << 1;
        }
        do{
            if(dividend >= divisor){
                dividend = dividend - divisor;
                result = result + mask;
            }
            divisor = divisor >> 1;
            mask = mask >> 1;
        }while(mask != 0);

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return result;
        else
            return -result;

    }

    public int divideSolution(int A, int B) {
        long p = Math.abs((long)A);
        long q = Math.abs((long)B);
        if(q == 0)
            return Integer.MAX_VALUE;
        int ret = 0;
        while (p >= q) {
            int counter = 0;
            while (p >= (q << counter)) {
                counter++;
            }
            ret = ret + 1 << (counter - 1);
            p = p - q << (counter - 1);
        }
        if (A == Integer.MIN_VALUE && B == -1)
            return Integer.MAX_VALUE;

        if ((A > 0 && B > 0) || (A < 0 && B < 0))
            return ret;
        else
            return -ret;
    }
}
