package Google.Qualificiationround2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TroubleSortSmallData {
    public static void main(String[] args){
        long ans =0;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        TroubleSortSmallData troubleSort = new TroubleSortSmallData();
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long N = in.nextLong();


                int[] arr = new int[(int)N];
                for(int j = 0; j < N;j++){
                    arr[j] = in.nextInt();
                }
            ans = troubleSort.isSortForSmall(arr);


            if(ans == -1)
                System.out.println("Case #" + i + ": " + "OK");
            else
                System.out.println("Case #" + i + ": " + ans);
        }

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
