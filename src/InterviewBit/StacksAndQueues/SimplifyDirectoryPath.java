package InterviewBit.StacksAndQueues;
import java.util.*;

public class SimplifyDirectoryPath {
    public static void main(String[] args){
        SimplifyDirectoryPath a = new SimplifyDirectoryPath();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("/home//foo/","/a/./b/../../c/","/a/../","/../../../../../a","/a/./b/./c/./d/"));
        for(String string: A){
            System.out.println("Input: " + string + "\t\tOutput: " + a.simplifyPath(string));
        }

    }

    public String simplifyPath(String A){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < A.length(); i++){
            StringBuilder dir = new StringBuilder();

            while(i < A.length() && A.charAt(i) =='/'){
                i++;
            }

            while(i < A.length() && A.charAt(i) != '/'){
                dir.append(A.charAt(i));
                i++;
            }

            if(".".equals( dir.toString() ) ){

            }
            else if("..".equals( dir.toString() ) ){
                if(!stack.empty())
                    stack.pop();
            }

            else if(dir.length() !=0){
                stack.push(dir.toString());
            }

        }
        Stack<String> stack1 = new Stack<>();

        while(!stack.empty()){
            String a = stack.pop();
            stack1.push(a);
        }

        StringBuilder result = new StringBuilder("/");

        while(!stack1.empty()){
            String ans = stack1.pop();
            result.append(ans);

            if(!stack1.empty())
                result.append("/");
        }

        return result.toString();

    }
}
