package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku a = new ValidSudoku();
        List<String> A = new ArrayList<>(Arrays.asList(".........",
                                                       ".........",
                                                       ".........",
                                                        "...789...",
                                                        "...456...",
                                                        "...123...",
                                                        "......384",
                                                        "......125",
                                                        "......679"));
        System.out.println(a.isSudokuValid(A));
    }

    public int isSudokuValid(final List<String> A) {

        boolean[] arr = new boolean[9];
        // Checking for each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(A.get(i).charAt(j))) {
                    if (arr[A.get(i).charAt(j) - '0' - 1])
                        return 0;
                    else
                        arr[A.get(i).charAt(j) - '0' - 1] = true;
                }
            }
            Arrays.fill(arr, false);
        }
        //Reset boolean array
        Arrays.fill(arr, false);
        // Checking for each col
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(A.get(j).charAt(i))) {
                    if (arr[A.get(j).charAt(i) - '0' - 1])
                        return 0;
                    else
                        arr[A.get(j).charAt(i) - '0' - 1] = true;
                }
            }
            Arrays.fill(arr, false);
        }

        //Reset boolean array
        Arrays.fill(arr, false);
        //9.6
        //.79
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (Character.isDigit(A.get(i + k).charAt(j+l))) {
                            if (arr[A.get(i + k).charAt(j+l) - '0' - 1])
                                return 0;
                            else
                                arr[A.get(i + k).charAt(j+l) - '0' - 1] = true;
                        }
                    }
                }
                Arrays.fill(arr, false);
            }
        }

        return 1;
    }


}
