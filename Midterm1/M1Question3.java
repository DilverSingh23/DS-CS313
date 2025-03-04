package Midterm1;

public class M1Question3 {

    public class Node {
        int val;
        Node next;
        public Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public class Queue {
        Node dummyhead;
        Node tail;
        int length;
        public Queue () {
            dummyhead = new Node (-1, null);
            tail = dummyhead;
            length = 0;
        }

        public void enqueue (int val){
            Node input = new Node(val, null);
            if (length == 0) {
                dummyhead.next = input;
                tail = input;
            }
            else {
                tail.next = input;
                tail = input;
            }
            length++;
        }

        public int dequeue() {
            if (length == 0){
                return -1;
            }
            int save = dummyhead.next.val;
            dummyhead.next = dummyhead.next.next;
            length--;
            return save;
        }
    }
}
