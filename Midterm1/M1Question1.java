package Midterm1;
// Implement the remove(x) method using a doubly linked list
// Time Complexity: O(n)
public class M1Question1 {
    public class Node {
        int val;
        Node next;
        Node prev;
        public Node (int val) {
            this.val = val;
            this.next = null;
            this.prev = null;

        }
    }
    Node dummyhead;

    public M1Question1 () {
        dummyhead = new Node(-1);
    }

    public Node remove (int x) {
        Node cur = dummyhead.next;
        while (cur != null) {
            if (cur.val == x){
                if (cur.next == null) {
                    cur.prev.next = null;
                }
                else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return cur;
            }
            cur = cur.next;
        }
        throw new IllegalArgumentException("Element is not in the linked list");
    }
}