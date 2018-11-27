package Google;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LuckyDip {

    public static void main(String[] args){
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = null;
        try {
            in = new Scanner(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Google/LuckyDipSmall.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];

            for(int j = 0; j < n ; j++) {
                arr[j] = in.nextInt();
            }

            float ans = 0;
            float total = 0;
            if(k == 0 || n == k){
                for(int x= 0; x < arr.length; x++){
                    total = total + arr[x];
                }
                ans = (float) total / arr.length;
                try{
                    FileWriter fw = new FileWriter("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Google/ANS_LuckyDipSmall.txt", true);
                    fw.write("Case #" + i + ": " + ans + "\n");
                    fw.close();
                }
                catch (IOException e) {
                }
                System.out.println("Case #" + i + ": " + ans );

                continue;
            }

            if(k == 1 && k != n){
                Arrays.sort(arr);
                float l = arr.length;
                float f = (float) (l - 1.0) / l;
                float temp = f * f;
                float Bigchance = 1 - temp;
                float otherchance = 1 - Bigchance;

                double otherTotal = 0;
                double otheravg = 0;
                for(int x= 0; x < arr.length-1; x++){
                    otherTotal = otherTotal + arr[x];
                }

                otheravg = otherTotal / (arr.length -1) ;

                ans = (float) ( Bigchance * arr[arr.length -1] + otherchance  * (otheravg));
                try{
                    FileWriter fw = new FileWriter("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Google/ANS_LuckyDipSmall.txt", true);
                    fw.write("Case #" + i + ": " + ans + "\n");
                    fw.close();
                }
                catch (IOException e) {
                }

                System.out.println("Case #" + i + ": " + ans );
            }



        }

    }
}
