package InterviewBit.GraphDataStructureAndAlgorithms;
import java.util.*;


public class ConvertesSortedListToBST {

      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }

    public TreeNode sortedListToBST(ListNode a) {
        if(a==null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();

        while(a !=null){
            list.add(a.val);
            a = a.next;
        }

        return bst(list, 0, list.size()-1);

    }

    private TreeNode bst(ArrayList<Integer> A, int l, int r){
        if(l>r)
            return null;

        int mid = (l + r) /2;

        TreeNode root = new TreeNode(A.get(mid));

        root.left = bst(A,l, mid-1);
        root.right = bst(A, mid+1, r);

        return root;
    }
}
