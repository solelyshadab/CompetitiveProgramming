package Google.CodeJam2018Practice.InteractiveProgramming;

import java.util.*;
import java.io.*;

// Interactive Programming: Number Guessing
public class NumberGuessing {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = in.read();
        for (int i = 1; i <= t; ++i) {
            int A = in.read();
            int originalA=A;
            int B = in.read();
            int N = in.read();
            for(int j = 0; j< N; j++ ){
                int Q = ((A+B)/2);
                if(Q==originalA)
                    Q+=1;
                BufferedOutputStream out = new BufferedOutputStream(System.out);
                try {
                    out.write(Q);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String response = in.readLine();
                if(response.contains("TOO_BIG")){
                    B = Q;
                }

                if(response.contains("TOO_SMALL")){
                    A = Q;
                }

                if(response.contains("CORRECT")){
                    break;
                }

            }

        }
    }
}
