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
            }
      }
}