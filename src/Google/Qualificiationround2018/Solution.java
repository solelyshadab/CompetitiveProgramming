package Google.Qualificiationround2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution savingTheUniverseAgain = new Solution();
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long D = in.nextLong();
            String P = in.next();
            long ans = savingTheUniverseAgain.calculateMinSwaps(D, P);
            if(ans == -1)
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            else
            System.out.println("Case #" + i + ": " + ans);
        }

    }

    public long calculateMinSwaps(long D, String P){

        char[] PChar = P.toCharArray();
        int count =0;
        long Damage = calculateDamage(PChar);
        if(Damage <=D)
            return count;
        for(int i = PChar.length -1 ; i > 0; i--){
            if(PChar[i] =='S' && PChar[i-1] == 'C'){
                PChar[i] = 'C';
                PChar[i-1] = 'S';
                count++;
                Damage = calculateDamage(PChar);
                if(Damage <= D)
                    return count;
                i +=2;
                if(i>PChar.length)
                    i = PChar.length;
            }
        }

        return -1;
    }

    private static long calculateDamage(char[] PChar){
        long charge = 1;
        long Damage = 0;
        for(int i = 0 ; i < PChar.length; i++){
            if(PChar[i] =='S'){
                Damage += charge;
            }
            if(PChar[i] =='C'){
                charge *=2;
            }
        }
        return Damage;
    }


}
