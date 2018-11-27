package InterviewBit.Strings;

public class Atoi {
    public static void main(String[] args) {
        Atoi a = new Atoi();
        System.out.println(a.atoi(" -1234"));
    }

    public int atoi(final String A) {

        int sign = 1;
        int i = 0;
        while (i < A.length() && Character.isWhitespace(A.charAt(i))) {
            i++;
        }

        if (A.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (A.charAt(i) == '+') {
            i++;
        }

        long base = 0;

        while (i < A.length() && Character.isDigit(A.charAt(i))) {
            base = base * 10 + (A.charAt(i) - '0');
            if (base > Integer.MAX_VALUE) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            i++;
        }
        
        return (int) (sign * base);
    }
}

