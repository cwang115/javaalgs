package section11;

/***
 * LCA in BST
 * prunning
 */
public class LCAII {
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q){
        if(root == null ){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode left = null;
        TreeNode right = null;
        if(root.key > p.key && root.key > q.key){
            left = lowestCommonAncestor(root.left, p, q);
        }

        if(root.key < p.key && root.key < q.key){
            right = lowestCommonAncestor(root.right, p, q);
        }

        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;

    }
}
