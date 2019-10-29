package InterviewBit;

public class RemoveLeadingZeroes {
    public static void main(String[] args){
        System.out.println(remove("112"));
    }

    static Integer remove(String num){
        int n = num.length();
        int i =0;
        for(; i < n; i++){
            if(num.charAt(i) != '0')
                break;
        }

        return Integer.valueOf(num.substring(i));
    }
}
