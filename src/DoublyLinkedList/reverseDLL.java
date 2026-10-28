package DoublyLinkedList;

public class reverseDLL {
    static Node reverseDLL(Node head) {
        Node temp = head;
        Node newHead = null;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = temp.prev;
            temp.prev = nextNode;
            newHead = temp;
            temp = nextNode;
        }
        return newHead;
    }
    static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print(" <-> ");
            }
            temp=temp.next;
        }
        System.out.println();
    }
    static void main(String[] args) {
        Node head=new Node(10);
        Node second=new Node(20);
        Node third=new Node(30);
        Node fourth=new Node(40);
        head.next=second;
        second.prev=head;
        second.next=third;
        third.prev=second;
        third.next = fourth;
        fourth.prev = third;
        System.out.print("Original DLL: ");
        printList(head);
        head = reverseDLL(head);
        System.out.print("Reversed DLL: ");
        printList(head);
    }
 }
