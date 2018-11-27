package HackerRankPractice;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.util.*;

public class LetsReview {
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            String input = in.next();
//            String evenString ="";
//            String oddString ="";
//
//            for(int j =0; j< input.length(); j++){
//                if(j%2 ==0)
//                evenString+= input.charAt(j);
//                else
//                   oddString+= input.charAt(j);
//            }
//
//            System.out.println(evenString + " " + oddString + "\n");
//
//        }
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i < n; i++){
//            arr[i] = in.nextInt();
//        }
//        in.close();
//        for(int i = arr.length-1; i>=0; i--){
//          System.out.print(arr[i] + " ");
//        }
//
//    }


    public static void main(String []argh){
        Map<String, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            map.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(map.containsKey(s))
                System.out.println(s +"=" + map.get(s));
            else
                System.out.println("Not found");
        }
        in.close();
    }

}


