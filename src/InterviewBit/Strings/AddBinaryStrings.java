package InterviewBit.Strings;

public class AddBinaryStrings {
    public static void main(String[] args){
        AddBinaryStrings a = new AddBinaryStrings();
        System.out.println(addBinary("100", "11"));
    }

    public String solve(String A, String B){

        String[] arr = makeEqual(A,B);
        A = arr[0];
        B = arr[1];
        String result = "";
        int carry = 0;

        for(int i = A.length()-1; i >=0; i--){
            int first = A.charAt(i) - '0';
            int second = B.charAt(i) - '0';

            int sum = (first ^ second ^ carry) +'0';

            result = (char) sum + result;

            carry = (first & second) | (second & carry) | (first & carry);
        }

        if(carry == 1)
            result = carry + result;

        return result;

    }

    private String[] makeEqual(String A, String B){
        int l1 = A.length(); int l2 = B.length();

        if(l1 > l2){
            for(int i = 0; i < l1 - l2; i++){
                B = '0' + B;
            }

        }else if (l2 > l1){
            for(int i = 0; i < l2 - l1; i++){
                A = '0' + A;
            }
        }
        String[] arr = {A,B};
        return arr;
    }


    //Geeks solution
    static String addBinary(String A, String B)
    {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Travers both strings starting
        // from last characters
        int i = A.length() - 1, j = B.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? A.charAt(i) - '0': 0);
            s += ((j >= 0)? B.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result += (char)(s % 2 + '0');

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }
}
