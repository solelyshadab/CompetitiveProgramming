package InterviewBit.Strings;

public class CountAndSay {
    public static void main(String[] args){
        CountAndSay a = new CountAndSay();
        System.out.println(a.countAndSay(5));
    }

    public String countAndSay(int A){

        String ans = "1";
        if(A<=0)
            return null;

        int i = 1;
        while(i < A){

            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1; j < ans.length(); j++){
                if(ans.charAt(j)==ans.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(ans.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(ans.charAt(ans.length()-1));
            ans = sb.toString();
            i++;

        }

        return ans;
    }
}
