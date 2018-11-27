//package Google;
//
//public class MyAnsw {
//
//    String s = String.valueOf(n);
//    StringBuilder sb = new StringBuilder(s);
//
//       for(int i = 0; i < s.length(); i++){
//        char f = s.charAt(i);
//        int y = f - '0';
//        if(y % 2 == 0)
//            continue;
//
//        if((s.length() - i) <= 1){
//            if( y >5 ) {
//                ans = 10 - y;
//                return ans;
//            }
//            else{
//                ans = y;
//                return ans;
//            }
//        }
//
//        char f1 = s.charAt(i+1);
//        int y1 = f1 - '0';
//        if(y1 > 5){
//            // forward
//            int yf = y + 1;
//            sb.setCharAt(i, String.valueOf(yf).charAt(0));
//
//            ans = Long.valueOf(sb.toString()) - n;
//        }else
//        {
//            // backward
//            int yf = y - 1;
//            sb.setCharAt(i, String.valueOf(yf).charAt(0));
//
//            ans = Long.valueOf(sb.toString()) - n;
//
//        }
//    }
//}
