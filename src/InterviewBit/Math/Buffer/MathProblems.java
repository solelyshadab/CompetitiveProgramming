package InterviewBit.Math.Buffer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MathProblems {
    public static void main(String[] args){
        MathProblems a = new MathProblems();
        //System.out.println(a.sortedPermutationRank("string"));
        System.out.println(a.sortedPermutationRankNRunningTime("abcdefghijklmnopqrstuvwxzy"));
        //System.out.println(factorial1(100));
        //System.out.println(a.uniquePaths(2,2));
        //System.out.println(a.findDigitsInBinary(357));
        //System.out.println(a.returnBinarytoBaseTen(101100101));
        //System.out.println(a.digitsOfAlphabets("AY"));
        //System.out.println(a.findExcelColumnsFromNumber(51));
        //ArrayList<Integer> A = new ArrayList<>();
        //A.add(5);A.add(10);A.add(2);A.add(1);
        //System.out.println(Arrays.toString(a.allFactors(38808).toArray()));
//        ArrayList<Integer> B = a.performOps(A);
//        for (int i = 0; i < B.size(); i++) {
//            //System.out.print(B.get(i) + " ");
//        }
    }

    public static long factorial1(int n) {
        String ans = factorial(n, 300);
//            BigInteger big = new BigInteger (ans);
//            return big.mod(new BigInteger("1000003")).longValue() ;
        return mod(ans, 1000003);

    }

    static int mod(String num, int a)
    {
        // Initialize result
        int res = 0;

        // One by one process all digits of 'num'
        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int)num.charAt(i) - '0') % a;

        return res;
    }

    private static String factorial(int n, int maxSize) {
        int res[] = new int[maxSize];
        res[0] = 1; // Initialize result
        int res_size = 1;

        // Apply simple factorial formula n! = 1 * 2 * 3 * 4... * n
        for (int x = 2; x <= n; x++) {
            res_size = multiply(x, res, res_size);
        }

        StringBuffer buff = new StringBuffer();
        for (int i = res_size - 1; i >= 0; i--) {
            buff.append(res[i]);
        }

        return buff.toString();
    }
    private static int multiply(int x, int res[], int res_size) {
        int carry = 0; // Initialize carry.

        // One by one multiply n with individual digits of res[].
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of 'prod' in res[]
            carry = prod / 10;  // Put rest in carry
        }

        // Put carry in res and increase result size.
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }


        // Construct a count array where value at every index
// contains count of smaller characters in whole string

    private static void populateAndIncreaseCount(String A, int[] countArray){

        for(int i=0; i < A.length(); i++ ){
            int index = A.charAt(i);
            countArray[index]++;
        }

        for(int i = 1; i < 256 ; i++){
            countArray[i] += countArray[i-1];
        }
    }
    // Removes a character ch from count[] array
// constructed by populateAndIncreaseCount()
    private static void updateCount(int[] countArray, char ch){
        for(int i = ch; i < 256; i++){
            countArray[i]--;
        }
    }

    public int sortedPermutationRankNRunningTime(String A){
        int rank = 1;
        int[] countArray = new int[256];
        int factorialIndex = A.length() -1;

        // all elements of count[] are initialized with 0
        for(int i =0; i < countArray.length; i++){
            countArray[i] = 0;
        }

        // Populate the count array such that count[i]
        // contains count of characters which are present
        // in str and are smaller than i
        populateAndIncreaseCount(A, countArray);

        for(int i = 0; i < A.length(); i++ ){
            int count = 0;
            char ch = A.charAt(i);
            // count number of chars smaller than str[i]
            // from str[i+1] to str[size-1]
            count = countArray[ch -1];

            rank += count * factorial(factorialIndex);
            // Reduce count of characters greater than str[i]
            updateCount(countArray, ch);
            factorialIndex--;
        }

        return rank;
    }

    public int sortedPermutationRank(String A){
        int rank = 1;
        int factorialIndex = A.length() -1;

        for(int i = 0; i < A.length(); i++ ){
            int count = 0;
            char ch = A.charAt(i);
            for(int j = i+1; j < A.length(); j++){
                char chToCompare = A.charAt(j);
                if(chToCompare < ch){
                    count++;
                }
            }

            rank += count * factorial(factorialIndex);
            factorialIndex--;
        }

        return rank  ;
    }

    private static int factorial(int N){
        if(N<=1)
            return 1;

        return N * factorial(N-1);
    }

    public int uniquePaths(int m, int n){
        return paths(m,n,0);
    }

    private static int paths(int m, int n, int count){
        if(m==1 || n == 1) {
            count++;
            return count;
        }

        return paths(m-1, n , count) + paths(m, n-1, count);

    }


    public int digitsOfAlphabets(String A){

        int ans = 0;
        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            int n = ch -'A' + 1 ;
            int index = A.length()-i-1;
            ans += n * Math.pow(26, index);
        }
        return ans;

    }


    public String findExcelColumnsFromNumber(int A){

        String ans = "";
        while(A> 0) {

            int rem = A%26;
            if (rem == 0) {
                ans = "Z" + ans;
                A = A / 26 - 1;
            } else {
                char c = (char) ('A' + rem-1);
                ans = c + ans;
                A = A / 26;
            }
        }

        return ans;
    }

    public String findDigitsInBinary(int A) {
        if(A==0)
            return "0";
        String ans = "";

        while(A>0){
            ans = A%2 + ans;
            A /=2;
        }

        return ans;
    }

    public int returnBinarytoBaseTen(int A){
        String B = A + "";
        int ans = 0;
        for(int i = 0; i < B.length() ; i++){
            if(B.charAt(i) == '1'){
                int n = B.length() - i -1;
                ans += Math.pow(2,n);
            }
        }

        return ans;
    }

    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if(B> A.size()-1){
            B = B%A.size();
        }

        for (int i = 0; i < A.size()-B; i++) {
            ret.add(A.get(i + B));
        }

        for(int i = 0; i <B; i++){
            ret.add(A.get(i));
        }

        return ret;
    }

    ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            int j =  A.size()-i;
            B.set(i + A.size(), A.get((j) % A.size()));
        }
        return B;
    }


    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = (int)Math.sqrt(A) ; i > 0 ; i--){
            if(A%i == 0){
                ans.add(i);
                if(i * i != A){
                    ans.add(A/i);
                }
            }
        }
        Collections.sort(ans);
        return ans ;
    }

}
