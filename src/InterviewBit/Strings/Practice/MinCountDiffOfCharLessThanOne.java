package InterviewBit.Strings.Practice;

import java.util.Arrays;
// Hackerrank: Sherlock and The Valid String.
public class MinCountDiffOfCharLessThanOne {

    public static void main(String[] args){
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
    }

    static String isValid(String s) {
        if(s==null || s.length() < 3)
            return "YES";
        int[] count = new int[26];
        for(int i = 0; i < s.length();i++){
            int ch = s.charAt(i)-'a';
            count[ch]++;
        }
        Arrays.sort(count);
        int minDiff = 0; int min = 0; int max = count[25]; int maxDiff = 0;
        int minIndex = -1;
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0)
                continue;
            if(min ==0 && count[i] > 0){
                min = count[i];
                minIndex = i;
            }
            
            minDiff += count[i] - min;
            maxDiff += max - count[i];
        }
        if(minDiff>1 && maxDiff > 1){
            if(min == 1 && minIndex < count.length-2){
                for(int i = minIndex+1; i < count.length-1; i++){
                    if(count[i] != count[i+1]){
                        return "NO";
                    }
                }
                return "YES";
            }
            return "NO";
        }
        return "YES";

    }
}
   /* An overview of the solution is to get a count of all distinct characters in the string and then test for valid conditions. Three cases exist that are valid strings:

        If all have the same frequency
        If only  character has a frequency that is  greater than all others
        If all have the same frequency except  element which has a frequency of */
