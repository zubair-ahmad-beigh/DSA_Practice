package DoublyLinkedList;

public class middleNode {
    static Node middleNode(Node head){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int mid=count/2;
        temp=head;
        for (int i = 0; i < mid; i++) {
            temp=temp.next;
        }
        return temp;
    }
    static Node middleNodeOptimal(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);
        Node middle=middleNode(head);
        Node middleOptimal=middleNodeOptimal(head);
        System.out.println(middle.data);
        System.out.println(middleOptimal.data);
    }
}
