package InterviewBit.Arrays.Practice;

public class NoOfSwapsBetweenAdjacentNumbers {
    public static void main(String[] args){
        int[] q = {2,1,5,3,4};
     minimumBribes(q);
    }
    //Hackerank question: New year chaos
    //Solution1: n running time
    private static void  minimumBribes(int[] q){
        int n = q.length; int ans = 0;
        for(int i = n-1; i >=0; i--){
            if(q[i] != i+1){
                if( i-1 >= 0 && q[i-1] == i+1){
                    ans++;
                    int temp = q[i-1];
                    q[i-1] = q[i];
                    q[i] = temp;
                }else if(i-2 >=0 && q[i-2] == i+1){
                    ans += 2;
                    q[i-2] = q[i-1];
                    q[i-1] = q[i];
                    q[i] = i+1;

                }else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(ans);
    }

    //Solution 2: Can be n2 running time
    static void minimumBribes1(int[] q) {
        int n = q.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }
        System.out.println(ans);
    }

}
