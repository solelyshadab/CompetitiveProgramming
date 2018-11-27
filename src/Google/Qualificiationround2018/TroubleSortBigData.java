package Google.Qualificiationround2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TroubleSortBigData {
    public static void main(String[] args){
        long ans =0;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        TroubleSortBigData troubleSort = new TroubleSortBigData();
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long N = in.nextLong();

//            if(N <= 1000){
//                int[] arr = new int[(int)N];
//                for(int j = 0; j < N;j++){
//                    arr[j] = in.nextInt();
//                }
//            ans = troubleSort.isSortForSmall(arr);
//
//            }else {

                String Number1 = "";
                String Number2 = "";
                for (long j = 0; j < N; j++) {
                    if (j < N / 2)
                        Number1 += in.next();
                    else
                        Number2 += in.next();
                }

                ans = troubleSort.troubleSortPossible(Number1, Number2);
            //}
            if(ans == -1)
                System.out.println("Case #" + i + ": " + "OK");
            else
                System.out.println("Case #" + i + ": " + ans);
        }

    }

    public long troubleSortPossible(String s1, String s2){
      long ans = -1;
      for(int i = 0; i < s1.length()-2; i++){
          if(s1.charAt(i) - '0' > s1.charAt(i+1) - '0') {
              if (!isSortableFirstString(i, s1, s2)) {
                  //Not Sortable
                  return errorIndex(s1, s2);
              }
          }
      }

      if(s1.charAt(s1.length()-1) - '0' > s2.charAt(0) - '0'){
          if(s1.charAt(s1.length()-1) - '0' > s2.charAt(1) - '0'){
              if (!isSortableSecondString(1, s2)) {
                  //Not Sortable
                  return errorIndex(s1, s2);
              }
          }
      }

        for(int i = 0; i < s2.length()-2; i++){
          if(s2.charAt(i) - '0' > s2.charAt(i+1) - '0') {
              if (!isSortableSecondString(i, s2)) {
                  //Not Sortable
                  return errorIndex(s1, s2);
              }
          }

        }

      return ans;

        }

        public static long errorIndex(String s1, String s2){
        long ans = -1;
            for(int i = 0; i < s1.length() -1; i++){
                if(s1.charAt(i) -'0' > s1.charAt(i+1) -'0')
                return i;
                }

                if(s1.charAt(s1.length()-1)-'0' > s2.charAt(0) -'0')
                    return s1.length()-1;

            for(int i = 0; i < s2.length() -1; i++){
                if(s2.charAt(i) -'0' > s2.charAt(i+1) -'0')

                return i + s1.length();
            }


                return -1;
        }
        
        public boolean isSortableFirstString(int i, String s1, String s2) {
            if (i < s1.length() - 2) {
                if (s1.charAt(i) - '0' < s1.charAt(i + 2))
                    return true;
                if (s1.charAt(i) - '0' >= s1.charAt(i + 2))
                    return isSortableFirstString(i + 2, s1, s2);
            }
            // i is second last index of String1
            if (i == s1.length() - 2){
                if (s1.charAt(s1.length() - 2) - '0' >= s2.charAt(0) - '0') {
                    return isSortableSecondString(0, s2);
                }else return true;

        }
            // i is last index of String1
        if(i == s1.length()-1){
            if (s1.charAt(s1.length() - 1) - '0' < s2.charAt(1) - '0') {
                return isSortableSecondString(1, s2);
            }else return true;
        }

            return true;
        }

    public boolean isSortableSecondString(int i, String s2){
        if(i > s2.length() -2)
            return false;

        if(s2.charAt(i) -'0' < s2.charAt(i+2))
            return true;
        if(s2.charAt(i) -'0' >= s2.charAt(i+2))
            return isSortableSecondString(i+2, s2);
        else return false;

    }

    public int isSortForSmall(int[] arr){

        arr = troubleSortForSmall(arr);


        return errorIndexForSmall(arr);
    }

    public static int errorIndexForSmall(int[] arr){
        int ans = -1;
        for(int i = 0; i < arr.length -1; i++){
            if(arr[i] > arr[i+1])
            return i;
        }
        return ans;
    }

    public static int[] troubleSortForSmall(int[] arr){
        for(int i =0; i< arr.length-2; i++){
            for(int j = 0; j < arr.length-2 -i; j++){
                if (arr[j] > arr[j+2])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }

        }
        return arr;
    }

}
