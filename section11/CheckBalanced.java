package section11;

public class CheckBalanced {
    public boolean isBalanced(TreeNode root){

        if(root == null){
            return true;
        }

        return height(root) != -1;

    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        if(left == -1){
            return -1;
        }

        int right = height(root.right);
        if(right == -1){
            return -1;
        }


        //calculate the difference
        if(Math.abs(left - right) > 1 ){
            return -1;
        }
        return 1 + Math.max(right, left);
    }
}
