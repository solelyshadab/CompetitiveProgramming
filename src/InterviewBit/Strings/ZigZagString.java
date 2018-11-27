package InterviewBit.Strings;

public class ZigZagString {
    public static void main(String[] args){
        ZigZagString a = new ZigZagString();
        System.out.println(a.zigzag("GEEKSFORGEEKS",1));
    }

    public String zigzag(String A, int N){
        if(N==1)
            return A;
        StringBuilder[] stringArray = new StringBuilder[N];
        boolean goDown = true;
        int row = 0;

        for(int i =0; i < stringArray.length; i++){
            stringArray[i] = new StringBuilder();
        }

        for(int i = 0; i < A.length();i++ ){
            char ch = A.charAt(i);
            stringArray[row].append(ch);

            if (row==N-1){
                goDown = false;
            }
            if(row == 0){
                goDown = true;
            }

            if(goDown){
                row++;
            }else {
                row--;
            }

        }

        for(int i =1; i < stringArray.length; i++){
            stringArray[0].append(stringArray[i]);
        }

        return stringArray[0].toString();

    }
}
