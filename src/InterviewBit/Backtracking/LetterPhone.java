package InterviewBit.Backtracking;

import java.util.ArrayList;

public class LetterPhone {

    static final String[] hashTable = {"0", "1", "abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args){
        LetterPhone a = new LetterPhone();
        int number[] = {0, 2};
        ArrayList<String> ansList =a.printWords(number,number.length);
        System.out.print(ansList);

    }
    //Solution works fine..
    static ArrayList<String> printWords(int number[], int n)
    {

        char output[] = new char[n];
        ArrayList<String> ansList = printWordsUtil(number, 0, output, new ArrayList<>());
        return ansList;
    }

    static ArrayList<String> printWordsUtil(int number[], int curr_digit, char output[],ArrayList<String> ansList)
    {

        if (curr_digit == number.length)
        {
            ansList.add(String.valueOf(output));
            return ansList;
        }
        int i=0;
        String currentdigitString = hashTable[number[curr_digit]];

        while(i<currentdigitString.length())
            {
                output[curr_digit] = currentdigitString.charAt(i);
                printWordsUtil(number, curr_digit+1, output,ansList);
                i++;
            }
        return ansList;
    }
}
