package InterviewBit.Strings;

public class RomanToInteger {
    public static void main(String[] args){
        RomanToInteger a = new RomanToInteger();
        System.out.println(a.romanToInteger("MCMIVII"));
    }

    public int romanToInteger(final String A){

        int ans = 0;
        for(int i = 0; i < A.length(); i++){
            int value = intValue(A.charAt(i));

            if(i+1 < A.length()){
                int nextValue = intValue(A.charAt(i+1));
                if(value >= nextValue){
                    ans+= value;
                }
                else {
                    ans += (nextValue - value);
                    i++;
                }
            }else {
                ans += value;
            }

        }

        return ans ;
    }

    private static int intValue(char ch){
        if(ch =='I')
        return 1;
        if (ch =='V')
        return 5;
        if(ch=='X')
            return 10;
        if(ch=='L')
            return 50;
        if(ch=='C')
            return 100;
        if(ch=='D')
            return 500;
        if(ch=='M')
            return 1000;
        return 0;
    }
}
