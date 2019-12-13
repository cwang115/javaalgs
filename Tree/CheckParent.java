package Tree;



public class CheckParent {
    static class TreeNode{
        //fields
        int val;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;
    }

    /**
     * node1 parent node2 child
     * @param node1
     * @param node2
     * @return
     */
    //iterative
    public boolean isParent(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 == null){
            return false;
        }

        while(node2.parent != null){
            if(node2.parent == node1){
                return true;
            }else{
                node2 = node2.parent;
            }
        }
        return false;
    }

    public boolean isParentII(TreeNode node1, TreeNode node2){
        if(node2.parent == null){
            return false;
        }

        if(node2.parent == node1){
            return true;
        }
        return isParentII(node1, node2.parent);
    }


}
