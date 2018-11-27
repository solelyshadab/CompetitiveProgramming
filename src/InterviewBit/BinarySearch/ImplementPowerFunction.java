package InterviewBit.BinarySearch;

public class ImplementPowerFunction {
    public static void main(String[] args){
        ImplementPowerFunction a = new ImplementPowerFunction();
        System.out.println(a.pow(-1 ,1 ,20));
    }
    //InterviewBit Solution
    public int pow(int x, int n, int d) {
        long res = 1;
        long aux = x%d;
        while (n > 0) {
            if (n%2 == 1)
                res = res*aux%d;

            aux = aux*aux%d;
            n = n/2;
        }
        if (res < 0)
            res = d + res;
        return (int) res%d;

    }

    public int power(int x, int n, int d) {
        boolean isXNeg = false;
        if(x==0)
            return x;
        if(n==0)
            return 1;

        if (x <0 && (n%2 !=0))
            isXNeg = true;

        long ans = 1;
        x = x % d;
        while(n>0){

            long xSquare = 0;
            if(x<0) {
                xSquare = modMultiplication(Math.abs(x), Math.abs(x), d) %d;
            }
            else
            {
                xSquare = modMultiplication(x,x,d);
            }
            //long xSquare = (x * x) % d;

            if(n % 2 !=0){
                ans = (ans * x) % d;
            }

            x = (int)(xSquare % d );
            n = n/2;
        }
        if(isXNeg){
            return d + ((int)ans%d);
        }else {
            return (int) (ans % d);
        }

    }


    static int powerusingRecursion(int x, int n, int d)
    {
        x = x %d;
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return ((powerusingRecursion(x, n / 2,d)%d) * (powerusingRecursion(x, n / 2,d)%d))%d;
        else
            return ((x %d) * ((powerusingRecursion(x, n / 2,d)%d) * (powerusingRecursion(x, n / 2,d))%d))%d;
    }

    private static int modMultiplication(int a, int b, int d){
        int res = 0;  // Initialize result

        // Update a if it is more than
        // or equal to mod
        a %= d;

        while (b >0)
        {
            // If b is odd, add a with result
            if (b % 2 != 0)
                res = (res + a) % d;

            // Here we assume that doing 2*a
            // doesn't cause overflow
            a = (2 * a) % d;

            b /= 2;  // b = b / 2
        }

        return res;
    }
}
