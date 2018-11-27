package InterviewBit.GraphDataStructureAndAlgorithms;
import java.util.*;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> currQ = new LinkedList<>();
        Queue<TreeNode> nextQ = new LinkedList<>();

        currQ.add(A);
        ArrayList<Integer> list = new ArrayList<>();
        while(!currQ.isEmpty()){
            TreeNode node = currQ.poll();
            list.add(node.val);
            if(node.left !=null)
                nextQ.add(node.left);

            if(node.right !=null)
                nextQ.add(node.right);

            if(currQ.isEmpty()){
                Queue<TreeNode> temp = new LinkedList<>();
                temp = nextQ;
                nextQ = currQ;
                currQ = temp;

                ansList.add(list);
                list = new ArrayList<>();
            }
        }

        return ansList;
    }

     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
}
