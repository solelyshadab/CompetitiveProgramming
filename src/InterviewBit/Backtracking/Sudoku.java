package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sudoku {

    public static void main(String[] args){
        ArrayList<ArrayList<Character>> A = getSudoku();
        if(solveSudoku(A)){
            for(ArrayList<Character> row : A){
                System.out.println(row);
            }
        }else {
            System.out.println("Sudoku cannot be solved!!");
        }


    }


    public static boolean solveSudoku(ArrayList<ArrayList<Character>> board)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board.get(i).get(j) == '.')
                {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }

        // no empty space left
        if (isEmpty)
        {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= 9; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board.get(row).set(col, (char) (num +'0'));
                if (solveSudoku(board))
                {
                    return true;
                }
                else
                {
                    board.get(row).set(col, '.'); // replace it
                }
            }
        }
        return false;
    }


    public static boolean isSafe(ArrayList<ArrayList<Character>> board,
                                 int row, int col,
                                 int num)
    {
        // row has the unique (row-clash)
        for (int d = 0; d < board.size(); d++)
        {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board.get(row).get(d) - '0' == num)
            {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < board.size(); r++)
        {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (board.get(r).get(col) - '0' == num)
            {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrt = (int) Math.sqrt(board.size());
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board.get(r).get(d) - '0' == num)
                {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }


    public static ArrayList<ArrayList<Character>> getSudoku() {
        //String[] sudokuString = {"3.65.84..", "52.......", ".87....31", "..3.1..8.", "9..863..5", ".5..9.6..", "13....25.", ".......74", "..52.63.."};
        String[] sudokuString = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        for (String aSudokuString : sudokuString) {
            a.add(getAsCharArray(aSudokuString));
        }
        return a;
    }

    private static ArrayList<Character> getAsCharArray(String s) {

        return IntStream.range(0, s.length()).mapToObj(s::charAt).collect(Collectors.toCollection(ArrayList::new));
    }
}
