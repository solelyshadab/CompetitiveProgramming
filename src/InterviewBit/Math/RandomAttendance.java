package InterviewBit.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class RandomAttendance {
    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, 3));

        solve(3, B);
    }

    public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        String[] arr = new String[A];
        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            String s = String.valueOf(i);
            arr[i - 1] = s;
        }

        Arrays.sort(arr);

        for (int i = 0; i < B.size(); i++) {
            int index = B.get(i) - 1;
            int value = Integer.valueOf(arr[index]);
            ansList.add(value);
        }

        return ansList;
    }

// Editorial Solution in c++
    //Note: Two functions are defined just for the sake of understanding.
//function_one and function_two can be combined into one function using a flag variable

    /*
    function_two(n,k) computes the rest of the digits of the kth required number.
    */
//    string function_two(string s, int k){
//        // Base case, first string is empty in this case
//        if(k==1) return "";
//
//        k-=1;     //Don't consider empty string
//
//        int l = s.size();
//        int f = s[0]-'0';
//        int temp = stoi(string(l,'1'));   // 1111111...    l digits
//
//        //Case when length of s is 1
//        if(l==1) return to_string(k-1);
//
//        string rem = s.substr(1);
//
//        //Note that i here starts from 0
//        for(int i=0; i<10; i++){
//            //Here we calculate the number of numbers starting from i.
//            //There will be multiple cases to handle which becomes clear
//            //after a little thinking.
//
//            if(i == f) temp/=10;
//            int buffer = temp;
//            if(i == f) buffer += stoi(rem) + 1;
//
//            if(k > buffer){
//                k-=buffer;
//                continue;
//            }
//            if(i == f) return to_string(i) + function_two(rem, k);
//            return to_string(i) + function_two(to_string(9*(temp/10)), k);
//        }
//
//    }
//
//    /*
//    function_one(n,k) computes the first digit of the kth required number.
//    function_one and function_two are separate as 1st digit can't be zero whereas
//    rest of the digits can be zero.
//    */
//    string function_one(string s, int k){
//
//        int l = s.size();                 //length of the number
//        int f = s[0]-'0';                 //first digit of the number
//        int temp = stoi(string(l,'1'));   // 1111111...    l digits
//
//        //Base case, only 1 digit number
//        if(l==1) return to_string(k);
//
//        //Utility string, used below in the for loop
//        string rem = s.substr(1);
//
//        //find the number of numbers say num starting from x (x <= i).
//        //if k > num, first digit is not i, else first digit is i.
//
//        //Note that i here starts from 1.
//        for(int i=1; i<10; i++){
//            //Here we calculate the number of numbers starting from i.
//            //There will be multiple cases to handle which becomes clear
//            //after a little thinking.
//
//            if(i == f) temp/=10;
//            int buffer = temp;
//            if(i == f) buffer += stoi(rem) + 1;
//
//            if(k > buffer){
//                k-=buffer;
//                continue;
//            }
//            if(i == f) return to_string(i) + function_two(rem, k);
//            return to_string(i) + function_two(to_string(9*(temp/10)), k);
//        }
//    }
//
//
//
//    vector<int> Solution::solve(int A, vector<int> &B){
//        string str = to_string(A);
//           }
//

}
