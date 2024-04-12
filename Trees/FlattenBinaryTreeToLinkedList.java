package Trees;
import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class FlattenBinaryTreeToLinkedList {
    TreeNode prev=null;
    public void flattenRecursive(TreeNode root) {
        if(root==null) return;
        flattenRecursive(root.left);
        flattenRecursive(root.right);
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.right=left;
        root.left=null;
        TreeNode current=root;
        while(current.right!=null){
            current=current.right;

        }
        current.right=right;
    }
    public void flattenIterative(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if (current != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }

                if (!stack.isEmpty()) {
                    current.right = stack.peek();
                }
                
                current.left = null;
            }
        }
    }

}