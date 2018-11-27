package InterviewBit.Strings;

public class ReverseStringByWord {
    public static void main(String[] args){
        ReverseStringByWord a = new ReverseStringByWord();
        System.out.println(a.reverseWords("   My name      is     Shadab    "));
    }
    public String reverseWords(String a) {
        a = a.trim();
        StringBuilder stringBuilder = new StringBuilder(a);
        StringBuilder ansStringBuilder = new StringBuilder();

        for(int i = 0; i< stringBuilder.length()-1; i++){
            if(stringBuilder.charAt(i) == ' ' && stringBuilder.charAt(i+1) == ' '){
                stringBuilder.deleteCharAt(i+1);
                i--;
            }
        }

        String[] tempArray = stringBuilder.toString().split(" ");

        for(int i = tempArray.length-1; i >=0; i--){
            ansStringBuilder.append(tempArray[i]);
            if(i != 0){
                ansStringBuilder.append(" ");
            }
        }

    return ansStringBuilder.toString();

    }

}
