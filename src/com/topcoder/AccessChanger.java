package com.topcoder;

import java.util.Arrays;

public class AccessChanger {
    public static void main(String[] args){
        String program[] = {"//->string"};
        AccessChanger ac = new AccessChanger();
        System.out.println(Arrays.toString(ac.convert(program)));

    }
    // MySolution: Passed all test cases
//    public String[] convert(String[] program){
//        String[] finalAns = new String[program.length];
//
//        for(int i = 0; i < program.length; i++){
//            String eachString = program[i];
//            String finalLine ="";
//
//            for(String line : eachString.split("\\r?\\n") ){
//                boolean hitComment = false;
//                char[] ch = line.toCharArray();
//                for(int j = 0; j < ch.length-1 ; j++){
//                    if(ch[j] =='/' && ch[j+1]=='/'){
//                        for(int a = j; a<ch.length; a++)
//                        finalLine += ch[a];
//                        hitComment = true;
//                        break;
//                    }
//
//
//                    if(ch[j] =='-' && ch[j+1]=='>'){
//                        finalLine += '.';
//                        j++;
//                    }else {
//                        finalLine += ch[j];
//                    }
//                }
//                if(!(ch[ch.length-1] == '>' && ch[ch.length-2] == '-') && !hitComment){
//                    finalLine += ch[ch.length-1];
//                }
//
//            }
//            finalAns[i] = finalLine;
//        }
//
//        return finalAns;
//    }

    //TopCoder Solution.
        public String[] convert(String[] program) {
            for (int x=0; x<program.length; x++) {
                String s = program[x];
                String ss = "";
                if (s.indexOf("//") != -1) {
                    ss = s.substring(s.indexOf("//"));
                    s = s.substring(0, s.indexOf("//"));
                }
                while (s.indexOf("->") != -1)
                    s = s.replaceAll("->",".");
                program[x] = s + ss;
            }
            return program;
        }

}
