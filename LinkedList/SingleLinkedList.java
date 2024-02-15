package LinkedList;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class SingleLinkedList {
    public static Node addNode(Node root,int data){
        Node th=root;
        if(root==null){
            return new Node(data);
        }
        while(root.next!=null){
            root=root.next;
        }
        Node dt=new Node(data);
        root.next=dt;
        return root=th;
    }
    public static void printList(Node root){
        while(root!=null){
            System.out.print(root.data+"-->");
            root=root.next;
        }
        System.out.println();
    }
    public static Node deleteNode(Node root,int data){
        Node th=root;
        if(root==null){
            return null;
        }
        if(root.data==data){
            return root.next;
        }
        while(root.next!=null){
            if(root.data==data){
                root.next=root.next.next;
                return root=th;
            }
        }
        return root=th;
    }
    public static int size(Node root){
        int cnt=0;
        while(root!=null){
            cnt++;
            root=root.next;
        }
        return cnt;
    }
    public static void main(String[] args) {
        Node r=new Node(10);
        printList(r);
        r=addNode(r,20);
        r=addNode(r,50);
        printList(r);
        System.out.println(size(r));
        r=deleteNode(r, 10);
        printList(r);
        System.out.println(size(r));

    }

    
}
