package Trie;
import java.util.Arrays;
class TrieNode{
    TrieNode a[];
    boolean flag;
   
    TrieNode(){
        a=new TrieNode[26];
        Arrays.fill(a,null);
        flag=false;
    }    
    public boolean containsKey(char ch){
        return (a[ch-'a']!=null);
    }
    public void put(TrieNode node, char ch){
        a[ch-'a']=node;
    }
    public TrieNode get(char ch){
        return a[ch-'a'];
    }
    public void setEnd(){
        flag=true;
    }
    public boolean isEnd(){
        return flag;
    }

}
public class Trie {

    private static TrieNode root;

    //Initialize your data structure here

    Trie() {
        root=new TrieNode();
        //Write your code here
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        //Write your code here
        TrieNode node=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            if(node.containsKey(word.charAt(i))==false){
                node.put(new TrieNode(),word.charAt(i));
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {

        //Write your code here
        TrieNode node=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            if(node.containsKey(word.charAt(i))==false){
               return false;
            }
            node=node.get(word.charAt(i));

        }
        if(node.isEnd()){
            return true;
        }
        return false;
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        //Write your code here
        TrieNode node=root;
        int n=prefix.length();
        for(int i=0;i<n;i++){
            if(node.containsKey(prefix.charAt(i))==false){
               return false;
            }
            node=node.get(prefix.charAt(i));

        }
        return true;
    }
}
