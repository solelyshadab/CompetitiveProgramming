package Google.CodeJam2018Practice;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Solution cruiseControl = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        System.out.println();
        for (int i = 1; i <= t; i++) {
            float D = in.nextFloat();
            float N = in.nextFloat();
            double totalTime = 0;
            ArrayList<Horse> horseList = new ArrayList<>();

            for(int j = 0; j < N ; j++){
                float Dj = in.nextFloat();
                float Ds = in.nextFloat();
                Solution.Horse horse = cruiseControl.new Horse(Dj, Ds);
                horseList.add(horse);
            }

            Collections.sort(horseList, new Comparator<Horse>() {
                @Override
                public int compare(Horse o1, Horse o2) {
                    if (o1.DH < o2.DH) return -1;
                    if (o1.DH > o2.DH) return 1;
                    return 0;
                }
            });

            float H1initialDis = horseList.get(0).DH;
            float H1Speed = horseList.get(0).SH;

//            if(N ==1){
//                totalTime = (D - H1initialDis) / H1Speed;
//                double ans = D / totalTime;
//                System.out.println("Case #" + i + ": " + ans);
//                continue;
//            }

            for(int j = 1; j< N; j++){
                float DH = horseList.get(j).DH;
                float SH = horseList.get(j).SH;

                if(SH < H1Speed){
                    float relSpeed = H1Speed - SH;
                    float D0 = DH - H1initialDis;
                    double time = (double) D0 / relSpeed;

                    H1Speed = SH;
                    float elapseDis = (float) (relSpeed * time);

                    if(elapseDis + DH > D) {
                        double time1 = (double) (elapseDis + DH - D) / relSpeed;
                        totalTime += time - time1;
                        H1initialDis = D;
                        break;

                    }else {
                        totalTime += time ;
                        H1initialDis += elapseDis + DH;
                    }
                }
            }
            if(H1initialDis < D)
            totalTime += (D - H1initialDis) / H1Speed;

            double ans = (double) D / totalTime;

            System.out.println("Case #" + i + ": " + ans);
        }
    }

    public class Horse{
        float DH;
        float SH;
        public Horse(float DH, float SH){
            this.SH = SH;
            this.DH = DH;
        }

    }
}
