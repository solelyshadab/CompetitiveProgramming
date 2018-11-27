package InterviewBit.Strings;

public class LengthOfLastWord {
    public static void main(String[] args){
        LengthOfLastWord a = new LengthOfLastWord();
        System.out.println(a.length1("**"));
    }

    public int length1(final String a){
        int len =0;
        boolean firstCharFound = false;

        for(int i = a.length()-1; i >=0; i--){
            if(Character.isLetter(a.charAt(i))){
                firstCharFound = true;
                len++;
            }else {
                if(firstCharFound)
                    return len;
            }
        }

        return len;
    }


    public int length(String a){
        a = a.trim();

        int lastSPaceIndex = a.lastIndexOf(' ');
        if(lastSPaceIndex == -1)
            return 0;

        return a.length() - (lastSPaceIndex+1);

    }
}
