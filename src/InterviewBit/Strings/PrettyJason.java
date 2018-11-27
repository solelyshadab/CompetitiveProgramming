package InterviewBit.Strings;

import java.util.ArrayList;

public class PrettyJason {
    public static void main(String[] args){
        PrettyJason a = new PrettyJason();
        a.solve("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        //a.solve("{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}");
    }
    //{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
    public ArrayList<String> solve(String A){
        ArrayList<String> ansList = new ArrayList<>();
        if(A ==null || A.isEmpty())
            return ansList;
        int tabSize = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == ' ')
                continue;
            StringBuilder sb = new StringBuilder();
            if(A.charAt(i) == '{' || A.charAt(i) == '['){

                for(int t = 0; t < tabSize; t++){
                    sb.append("\t");
                }
                sb.append(A.charAt(i));
                System.out.println(sb.toString());
                ansList.add(sb.toString());
                tabSize++;
            }
            else if(A.charAt(i) == '}' || A.charAt(i) == ']'){
                    tabSize--;
                for(int t = 0; t < tabSize; t++){
                    sb.append("\t");
                }
                sb.append(A.charAt(i));
                if(i < A.length()-1 && A.charAt(i+1) == ','){
                    sb.append(",");
                    i++;
                }
                System.out.println(sb.toString());
                ansList.add(sb.toString());
            }
            else {
                for(int t = 0; t < tabSize; t++){
                    sb.append("\t");
                }
                while(i < A.length()-1 && A.charAt(i+1) != '{' && A.charAt(i+1) != '['
                        && A.charAt(i+1) != '}' && A.charAt(i+1) != ']' && A.charAt(i) != ','){
                    sb.append(A.charAt(i));
                    i++;
                }
                sb.append(A.charAt(i));
                System.out.println(sb.toString());
                ansList.add(sb.toString());
            }
        }

        return ansList;
    }
}
