package Classwork3;

public class Node<T> {
    T data;
    Node<T> next;
            
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public T getNodeData() { return this.data; }
    public Node<T> getNodeNext() { return this.next; }
}