package InterviewBit.Arrays;
import java.util.*;

public class RepeatAndMissingNumber {
    public static void main(String[] args) {
        RepeatAndMissingNumber a = new RepeatAndMissingNumber();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218, 143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506, 261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358, 209, 213, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421, 313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222, 500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360, 244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314, 480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432, 418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107, 134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122, 162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478, 477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127, 444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330, 311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276, 83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67, 498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493, 150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380, 359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426, 514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306, 449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86, 417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64, 316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473, 165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135, 269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160, 256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260));
        System.out.println(a.repeatedNumber(A));

    }
    // Solution Approach
        // A = repeat, B = missing
   /* Sum(Actual) = Sum(1...N) + A - B
      Sum(Actual) - Sum(1...N) = A - B.
      Sum(Actual Squares) = Sum(1^2 ... N^2) + A^2 - B^2
      Sum(Actual Squares) - Sum(1^2 ... N^2) = (A - B)(A + B)
            = (Sum(Actual) - Sum(1...N)) ( A + B).*/



    // InterviewBit Solution
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int arraySize = A.size();
        long sumOfNumbers = getSumOfNumbers(arraySize);
        long sumOfSquares = getSumOfSquares(arraySize);
        long differenceNumber =  getDifferenceofNumbers(A,sumOfNumbers);
        long differenceSquare = getDifferenceofSquares(A,sumOfSquares);
        long sumNumber =  differenceSquare/differenceNumber;
        int repeatedNumber = (int)((sumNumber+differenceNumber)/2);
        int missingNumber = (int)(sumNumber-repeatedNumber);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeatedNumber);
        result.add(missingNumber);
        return result;
    }

    private long getDifferenceofNumbers(List<Integer> a,long sumOfNumbers){
        long sum = sumOfNumbers * -1;
        for(Integer number: a){
            long num = (long)number;
            sum+=num;
        }
        return sum;
    }

    private long getDifferenceofSquares(List<Integer> a, long sumOfSquares){
        long sumSquares = sumOfSquares*-1;
        for(Integer number:a){
            long num = (long)number;
            sumSquares+=(num*num);
        }
        return sumSquares;
    }

    private long getSumOfNumbers(double n){
        long ans = 0;
        for(int i =1; i <=n; i++)
            ans += i;
        return ans;
        //return (long)(n*(n-1)/2+n);
    }

    private long getSumOfSquares(double n){
        long ans = 0;
        for(int i =1; i <=n; i++)
            ans += i * i;
        return ans;
        //return (long)(n*(n+1)*(2*n+1)/6);
    }

    // Accepted by Interviewbit..
    public ArrayList<Integer> solve(final List<Integer> A) {
        int xor1;
        int n = A.size();
        /* Will have only single set bit of xor1 */
        int set_bit_no;

        int i;
        int x = 0;
        int y = 0;

        xor1 = A.get(0);

        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ A.get(i);

    /* XOR the previous result with numbers from
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);

    /* Now divide elements in two sets by comparing
    rightmost set bit of xor1 with bit at same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements.The
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((A.get(i) & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ A.get(i);

            else
                /* arr[i] belongs to second set*/
                y = y ^ A.get(i);
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;

            else
                /* i belongs to second set*/
                y = y ^ i;
        }
        ArrayList<Integer> ansList = new ArrayList<>();
        if(A.contains(x)){
            ansList.add(x); ansList.add(y);
        }
        else{
            ansList.add(y); ansList.add(x);
        }

        return ansList;

    }
        // Solution2: Not accepted by Interviewbit since can't modify ArrayList
        public ArrayList<Integer> repeatedNumber1 ( final List<Integer> A){
            int repeat = 0;
            int missing = 0;
            ArrayList<Integer> ansList = new ArrayList<>();

            // 3 1 2 5 3
            // 0 1 2 3 4
            for (int i = 0; i < A.size(); i++) {
                if (A.get(Math.abs(A.get(i)) - 1) > 0) {
                    A.set(Math.abs(A.get(i)) - 1, -A.get(Math.abs(A.get(i)) - 1));
                } else {
                    repeat = Math.abs(A.get(i));
                }
            }

            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) > 0)
                    missing = i + 1;
            }

            ansList.add(missing);
            ansList.add(repeat);
            Collections.sort(ansList);

            return ansList;

        }



    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int m = a.get(0).size();
        if(n ==1)
            return;

        //First transpose
        for(int i = 0 ; i < n ; i++ ){
            for(int j = i ; j < m ; j++){
                //int temp = arr[y][z];
                int temp = a.get(i).get(j);
                //arr[y][z] = arr[z][y];
                int temp1 = a.get(j).get(i);
                a.get(i).set(j, temp1);
                //arr[z][y] = temp;
                a.get(j).set(i, temp);
            }
        }
        // Now reverse each row
        for(int j = 0; j < m/2 ; j++ ){
            for(int i  = 0; i < n ; i++){
                //int temp = arr[z][y];
                int temp = a.get(i).get(j);
                //arr[z][y] = arr[z][i-1-y];
                int temp1 = a.get(i).get(n-1-j);
                a.get(i).set(j, temp1);
                //arr[z][i-1-y] = temp;
                a.get(i).set(n-1-j, temp);
            }
        }
    }
    }

