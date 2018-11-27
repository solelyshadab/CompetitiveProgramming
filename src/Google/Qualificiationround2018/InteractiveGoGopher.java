package Google.Qualificiationround2018;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class InteractiveGoGopher {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int A = input.nextInt();
            solve(input, A);
        }
    }

    public static void solve(Scanner input, int A) {
        Random r = new Random();
        if(A == 200){
            HashSet<String> responseSet = new HashSet<>();
            int x = r.nextInt(4 -2 +1) + 2;
            int y = r.nextInt(39 -2 +1) + 2;

            System.out.println(x + " " + y);
            String response = input.nextInt() + " " + input.nextInt();
            responseSet.add(response);
            while( !response.equals("0 0")){
                x = r.nextInt(4 -2 +1) + 2;
                y = r.nextInt(39 -2 +1) + 2;
                String xy = x + " " + y;
                String xy1 = (x+1) + " " + y;
                String xy2 = x + " " + (y+1);
                String xy3 = (x-1) + " " + y;
                String xy4 = x + " " + (y-1);
                String xy5 = (x-1) + " " + (y-1);
                String xy6 = (x+1) + " " + (y-1);
                String xy7 = (x+1) + " " + (y+1);
                String xy8 = (x-1) + " " + (y+1);

                if(responseSet.contains(xy) && responseSet.contains(xy1) && responseSet.contains(xy2)
                        &&responseSet.contains(xy3) && responseSet.contains(xy4) && responseSet.contains(xy5)
                        && responseSet.contains(xy6) && responseSet.contains(xy7) &&responseSet.contains(xy8)){
                    continue;
                }

                System.out.println(xy);
                response = input.nextInt() + " " + input.nextInt();
                responseSet.add(response);
            }

        }

        if(A == 20){
            int x = r.nextInt(3 -2 +1) + 2;
            int y = r.nextInt(4 -2 +1) + 2;

            System.out.println(x + " " + y);
            String response = input.nextInt() + " " + input.nextInt();
            while( !response.equals("0 0")){
                x = r.nextInt(3 -2 +1) + 2;
                y = r.nextInt(4 -2 +1) + 2;

                System.out.println(x + " " + y);
                response = input.nextInt() + " " + input.nextInt();
            }

        }

    }


}
