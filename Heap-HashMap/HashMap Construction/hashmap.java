import java.util.*;

public class hashmap {
      private class linkedlist {

            private class Node {
                  Integer key = 0;
                  Integer value = 0;
                  Node next = null;

                  Node(Integer key, Integer value) {
                        this.key = key;
                        this.value = value;
                  }
            }

            private Node head = null;
            private Node tail = null;
            private int noOfEle = 0;

            public linkedlist() {
                  this.head = this.tail = null;
                  this.noOfEle = 0;
            }

            public int size() {
                  return noOfEle;
            }

            public void addLast(Node node) {
                  if (head == null)
                        head = tail = node;
                  else {
                        this.tail.next = node;
                        this.tail = node;
                  }
                  this.noOfEle++;
            }

            public Node removeFirst() {
                  Node node = this.head;
                  if (this.noOfEle == 1)
                        this.head = this.tail = null;
                  else {
                        this.head = this.head.next;
                        node.next = null;
                  }
                  this.noOfEle--;
                  return node;
            }
      }

      public ArrayList<Integer> keySet() {

      }

      public Integer remove(Integer key) {
            int val = get(key);
            return val--;
      }

      public getOrDefault(Integer key,Integer defaultValue){

      }

      public Integer get(Integer key) {

      }

      public boolean containsKey(Integer key) {

      }

      private linkedlist group(Integer key) {
            int code = hashCode(key);
            return this.containers[code];
      }

      private int hashCode(Integer key) {
            int value = key.hashCode();
            return value % containers.length;
      }
}