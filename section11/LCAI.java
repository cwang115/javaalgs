package section11;



public class LCAI {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two){
        //Assumptions: root is not null
        //one and two guaranteed to be in the tree and not null
        if(root == null){
            return null;
        }

        if(root == one || root == two){
            return root;
        }

        TreeNode ll = lowestCommonAncestor(root.left, one, two);
        TreeNode lr = lowestCommonAncestor(root.right, one, two);
        if(ll != null && lr != null){
            return root;
        }

        return ll == null ? lr : ll;
    }
}
