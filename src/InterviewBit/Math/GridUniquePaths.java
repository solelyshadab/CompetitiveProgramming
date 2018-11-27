package InterviewBit.Math;

public class GridUniquePaths {
    public static void main(String[] args){
        GridUniquePaths a = new GridUniquePaths();
        System.out.println(a.uniquePaths(3,3,0));

    }
    public int uniquePaths(int A, int B,int count) {
        if(A==1 || B==1){
            count++;
            return count;
        }

        return uniquePaths(A-1, B,count) + uniquePaths(A, B-1,count) ;
    }

}
