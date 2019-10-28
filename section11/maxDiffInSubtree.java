package section11;

public class maxDiffInSubtree {

    public TreeNode maxDiffNode(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode[] node = new TreeNode[1];
        int[] diff = new int[1];
        diff[0] = -1;
        numNodes(root, node, diff);
        return node[0];
    }

    private int numNodes(TreeNode root, TreeNode[] node, int[] diff){
        if(root == null){
            return 0;
        }

        int leftNum = numNodes(root.left, node, diff);
        int rightNum = numNodes(root.right, node, diff);
        if(Math.abs(leftNum - rightNum) > diff[0]){
            diff[0] = Math.abs(leftNum - rightNum);
            node[0] = root;
        }

        return leftNum + rightNum + 1;
    }

}
