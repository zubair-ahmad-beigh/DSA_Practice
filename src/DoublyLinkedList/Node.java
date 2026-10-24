package DoublyLinkedList;

public class Node {
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
class main{
    static void main(String[] args) {
        Node first=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        first.next=second;
        second.next=third;
        second.prev=first;
        third.prev=second;
        Node temp=first;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
}
