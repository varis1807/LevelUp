public class implementation{
      import java.io.*;
import java.util.*;
 
public class Main {
  public static class Trie {
 
    /** Initialize your data structure here. */
    public class TrieNode{
      TrieNode[] children;
      boolean isWord;
 
      public TrieNode(){
        children=new TrieNode[26];
        isWord=false;
      }
    }
 
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
 
    /** Inserts a word into the trie. */
    public void insert(String word) {
      TrieNode curr=root;
 
      for(int i=0; i<word.length(); i++){
        char ch=word.charAt(i);
 
        if(curr.children[ch-'a']==null){
          curr.children[ch-'a']=new TrieNode();
        }
 
        curr=curr.children[ch-'a'];
      }
 
      curr.isWord=true;
    }
 
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      TrieNode curr=root;
 
      for(int i=0; i<word.length(); i++){
        char ch=word.charAt(i);
 
        if(curr.children[ch-'a']==null) return false;
 
        curr=curr.children[ch-'a'];
      }
      return curr.isWord;
    }
 
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      TrieNode curr=root;
 
      for(int i=0; i<prefix.length(); i++){
        char ch=prefix.charAt(i);
 
        if(curr.children[ch-'a']==null) return false;
 
        curr=curr.children[ch-'a'];
      }
 
      return true;
    }
  }
 
  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
 
    Trie obj = new Trie();
 
    while (read.ready()) {
      String inp[] = read.readLine().split(" ");
 
      if (inp[0].equals("insert")) {
        obj.insert(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      } else if (inp[0].equals("startsWith")) {
        System.out.println(obj.startsWith(inp[1]));
      }
    }
 
  }
}
}