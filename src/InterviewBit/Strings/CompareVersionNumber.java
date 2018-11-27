package InterviewBit.Strings;

import java.util.ArrayList;

public class CompareVersionNumber {
    public static void main(String[] args){
        CompareVersionNumber a = new CompareVersionNumber();
        System.out.println(a.compareVersion("1.11.000000000.00000001","1.11.0000.00000000"));
    }
    //0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
    public int compareVersion(String A, String B){
        int n = A.length(); int m = B.length();

        int i =0; int j =0;
        while (i<n && j <m){
            ArrayList<Integer> v1 = new ArrayList<>();
            while (i < n && A.charAt(i) == '0' && i < n)
                i++;

            while (i < n && A.charAt(i) != '.'){
                v1.add(A.charAt(i) - '0');
                //v1 = v1 * 10 + (A.charAt(i) -'0');
                i++;
            }
            i++;

            ArrayList<Integer> v2 = new ArrayList<>();
            while (j < m && B.charAt(j) == '0')
                j++;

            while (j < m && B.charAt(j) != '.'){
                v2.add(B.charAt(j)-'0');
                //v2 = v2 * 10 + (B.charAt(j) -'0');
                j++;
            }
            j++;

            int ans = compare(v1,v2);
            if(ans !=0)
                return ans;
        }

        while(i<n && (A.charAt(i) == '0' || A.charAt(i) == '.' )){
            i++;
        }

        while(j<m && (B.charAt(j) == '0' || B.charAt(j) == '.')){
            j++;
        }

        if(i<n)
            return 1;
        else if(j < m)
            return -1;

return 0;
    }

    private int compare(ArrayList<Integer> v1, ArrayList<Integer> v2){
        if(v1.size() > v2.size())
            return 1;
        else if(v1.size() < v2.size())
            return -1;

        for(int i = 0; i < v1.size(); i++){
            if(v1.get(i) > v2.get(i))
                return 1;
            else if(v1.get(i) < v2.get(i))
                return -1;
        }

        return 0;
    }
}
