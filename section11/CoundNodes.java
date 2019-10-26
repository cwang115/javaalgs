package section11;

public class CoundNodes {
    class TreeNode{
        int val;
        int leftSubtreeNodes;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            leftSubtreeNodes = 0;
            left = null;
            right = null;
        }
    }

    public int getLeftSubtreeNodes(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getLeftSubtreeNodes(root.left);
        int right = getLeftSubtreeNodes(root.right);
        root.leftSubtreeNodes = left;
        return left + right + 1;
    }
}
