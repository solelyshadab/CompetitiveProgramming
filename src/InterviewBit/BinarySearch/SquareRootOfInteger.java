package InterviewBit.BinarySearch;

public class SquareRootOfInteger {
    public static void main(String[] args){
        SquareRootOfInteger a = new SquareRootOfInteger();
        System.out.println(a.sqrt(673707547));
    }

    public int sqrt(int A){
        if(A==0 || A==1)
            return A;
        int l = 0;
        int r = A;
        int ans = Integer.MIN_VALUE;
        while(l<=r){
            long mid = l + (r-l)/2;
            long midSquare = mid * mid;
            if(midSquare == A){
                return (int) mid;
            }
            if(midSquare < A && midSquare>0){
                l = (int)mid + 1;
                if(mid > ans)
                    ans = (int)mid;
            }
            if(midSquare > A || midSquare <0){
                r = (int)mid -1;
            }
        }

        return ans;
    }
}
