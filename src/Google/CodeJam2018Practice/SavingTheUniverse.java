package Google.CodeJam2018Practice;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class SavingTheUniverse {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Google/input.in"));
        PrintWriter out = new PrintWriter(new File("/Users/shadabbaig/IdeaProjects/TopCoderPractice/src/Resource/Files/Google/output.out"));

        int T = scan.nextInt(), s, q,c;
        String temp;

        HashSet<String> set = new HashSet<String>();

        scan.nextLine();
        for (int cT = 1; cT <= T; cT++) {
            set.clear();
            c = 0;
            s = scan.nextInt();

            for (int i = 0; i <= s; i++)
                scan.nextLine();

            q = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < q; i++) {
                set.add(temp = scan.nextLine());
                if (set.size() == s) {
                    c++;
                    set.clear();
                    set.add(temp);
                }
            }
            out.println("Case #"+ cT+": "+c);
        }

        scan.close();
        out.close();
    }
}
