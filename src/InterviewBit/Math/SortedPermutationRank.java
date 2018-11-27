package InterviewBit.Math;

public class SortedPermutationRank {

    public int findRank(String A) {
        int[] countArray = new int[256];
        long rank = 1;
        int factorialIndex = A.length() - 1;

        for(int i = 0; i < countArray.length; i++){
            countArray[i] = 0;
        }
        populateCount(countArray, A);

        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            int count = countArray[ch-1];

            rank += (long) ((long)count * factorial1(factorialIndex));
            factorialIndex--;
            updateCount(countArray, ch);
        }

        return (int)(rank % 1000003);
    }

    private static void populateCount(int[] countArray, String A){
        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            countArray[ch]++;
        }

        for(int i = 1; i < 256; i++){
            countArray[i] += countArray[i-1];
        }

    }

    private static void updateCount(int[] countArray, char ch){
        for(int i = ch ; i < 256 ; i++){
            countArray[i]--;
        }
    }

    private static long factorial1(int n) {
        if(n==0 || n==1)
            return 1;

        return ((n * factorial1(n-1))% 1000003);
    }

}
