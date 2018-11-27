package InterviewBit.Strings;
import java.util.*;

public class ValidIPAddresses {
    public static void main(String[] args){
       ValidIPAddresses a = new ValidIPAddresses();
        for(String s : a.solve("128001"))
            System.out.println(s);
    }

    public ArrayList<String> solve(String A){
       ArrayList<String> ansList = new ArrayList<>();
       if(A == null || A.length()<4 || A.length() > 12)
       return ansList;

       return util(A, new StringBuilder(), 0, ansList);
    }

    public ArrayList<String> util(String A, StringBuilder ans, int count, ArrayList<String> ansList){
        if(count==3){
            if(isValidIP(A)) {
                ans.append(A);
                ansList.add(ans.toString());
            }

            return ansList;
        }
        StringBuilder sbTemp = new StringBuilder(ans);
        for(int i = 1; i < 4 && i < A.length(); i++){
            String temp = A.substring(0, i);
            if(isValidIP(temp)){
                ans.append(temp + ".");
                 //ans.append('.');
                util(A.substring(i),ans, count+1, ansList);
                ans = new StringBuilder(sbTemp);
            }
        }

    return ansList;
    }

    private boolean isValidIP(String s){
        if(s.charAt(0)=='0')
            return s.equals("0");
        int n = Integer.parseInt(s);
        return ( n <=255 && n >0);
    }




// Solutiom2: Uses String instead of StringBuilder
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length()<4||s.length()>12) return res;
        dfs(s,"",res,0);
        return res;
    }

    public void dfs(String s, String tmp, ArrayList<String> res, int count){
        if (count == 3 && isValidIP(s)) {
            res.add(tmp + s);
            return;
        }
        for(int i=1; i<4 && i<s.length(); i++){
            String substr = s.substring(0,i);
            if (isValidIP(substr)){
                dfs(s.substring(i), tmp + substr + '.', res, count+1);
            }
        }
    }


}
