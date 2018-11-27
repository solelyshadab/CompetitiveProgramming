package InterviewBit.Math;

public class ReverseInteger {
    public static void main(String[] args){
        ReverseInteger a = new ReverseInteger();
        System.out.println(a.reverse(-123));
    }

    public int reverse(int A) {

        long sol = 0;
        while(A !=0){
            sol = sol*10 + (A%10);
            A = A/10;

        }
        if(sol > Integer.MAX_VALUE || sol < Integer.MIN_VALUE)
            return 0;

        return (int)sol;

    }
}
