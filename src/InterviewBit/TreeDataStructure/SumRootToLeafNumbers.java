package InterviewBit.TreeDataStructure;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        SumRootToLeafNumbers a = new SumRootToLeafNumbers();
        TreeNode root = a.new TreeNode(1);
        root.left = a.new TreeNode(2);
        root.right = a.new TreeNode(3);
        root.left.left = a.new TreeNode(4);
        //root.left.right = a.new TreeNode(5);
        root.right.left = a.new TreeNode(6);
        root.right.right = a.new TreeNode(7);
        System.out.println(a.solve(root));
    }

    public int solve(TreeNode A) {
        long ans = util(A,0,0);
        return (int) ans;
    }

    private long util(TreeNode A, long ans, int number){
        if(A==null)
            return ans;

        if(A.left == null && A.right == null){

            ans += (number*10 + A.val) % 1003;
            return ans;
        }

        ans = util(A.left,ans,(number* 10 +A.val) % 1003);
        ans = util(A.right,ans,(number*10 + A.val) % 1003);

        return ans % 1003;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
}
