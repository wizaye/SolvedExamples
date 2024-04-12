package Trees;
import java.util.List;
import java.util.ArrayList;

/* place links if the rightmost node of the left subtree is null
 else remove the links and move to the right subtree */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
};

public class MorrisTraversal {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> inOrder=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                inOrder.add(cur.data);
                cur=cur.right;
            }else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }else{
                    prev.right=null;
                    inOrder.add(cur.data);
                    cur=cur.right;
                }
            }
        }
        return inOrder;
    }
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		// Write your code here
        ArrayList<Integer> preOrder=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                preOrder.add(cur.data);
                cur=cur.right;
            }else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    preOrder.add(cur.data);
                    cur=cur.left;
                }else{
                    prev.right=null;
                    cur=cur.right;
                }

            }
          
        }
        return preOrder;
	}
}

