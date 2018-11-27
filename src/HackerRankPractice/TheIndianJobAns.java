package HackerRankPractice;
import java.io.*;
import java.util.*;

public class TheIndianJobAns {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int y=0;y<t;y++){
            int n=sc.nextInt(),m=sc.nextInt();
            int a[]=new int[n],sum=0;
            for(int i=0;i<n;i++){a[i]=sc.nextInt();sum+=a[i];}
            if(m>=sum) System.out.println("YES");
            else if(m<(sum-m)) System.out.println("NO");
            else{
                int set[]=new int[m+10];
                for(int i=0; i<m; i++) set[i]=0;
                set[0]=1;
                for(int i=0; i<n; i++)
                    for(int j=m; j>=a[i]; j--)
                        set[j] |= set[j-a[i]];
                int done=0;
//System.out.println("The possible sum subsets are : ");
                for(int i=sum-m;i<=m;i++)
                    if(set[i]==1){done=1;System.out.println("YES");break;}
                if(done==0) System.out.println("NO");
            }
        }
    }
}

