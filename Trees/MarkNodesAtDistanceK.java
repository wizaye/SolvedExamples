package Trees;
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}


public class MarkNodesAtDistanceK {
    public static Node dfs(Node root, int target) {
        if (root == null || root.data == target)
            return root;
        
        Node left = dfs(root.left, target);
        if (left != null)
            return left;
        
        Node right = dfs(root.right, target);
        return right;
    }
    public static void markParents(Node root,Map<Node,Node> parent_track){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node current=q.poll();
            if(current.left!=null){
                parent_track.put(current.left,current);
                q.add(current.left);
            }
            if(current.right!=null){
                parent_track.put(current.right,current);
                q.add(current.right);
            }
        }
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        Node tar=dfs(root,target);
        Map<Node,Node> parent_track=new HashMap<>();
        markParents(root,parent_track);
        Map<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(tar);
        visited.put(tar,true);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(level==k) break;
            level++;
            for(int i=0;i<size;i++){
                Node current=q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.add(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.add(current.right);
                    visited.put(current.right,true);
                }
                if(parent_track.get(current)!=null && visited.get(parent_track.get(current))==null){
                    q.add(parent_track.get(current));
                    visited.put(parent_track.get(current),true);
                }
            }
            
            
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            Node current=q.poll();
            ans.add(current.data);
        }
        Collections.sort(ans);
        return ans;
        
        
        
    }
};