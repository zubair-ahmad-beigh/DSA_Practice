package BinarySearch.linkedList;
public class insertionAndDelection {
    static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " -> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    static Node deleteHead(Node head){
        if(head==null){
            return null;
        }
        return head.next;
    }
    static Node deleteTail(Node head){
        if(head==null ||head.next==null){
            return null;
        }
        Node temp=head;
        while(temp.next.next !=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    static Node deleteKth(Node head,int k){
        if(head==null ||k<1){
            return head;
        }
        if(k==1){
            return head.next;
        }
        Node temp=head;
        for(int i=1;i<k-1;i++){
            if(temp.next==null){
                return  head;
            }
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
        return head;
    }
    static Node insertHead(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }
    static Node insertLast(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    static Node insertKth(Node head, int k, int value) {
        if (k < 1) {
            return head;
        }
        if (k == 1) {
            return insertHead(head, value);
        }
        Node temp = head;
        for (int i = 1; i < k - 1; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        System.out.println("Original Linked List:");
        printList(head);
        head = deleteHead(head);
        System.out.println("After deleting head:");
        printList(head);
       head = deleteTail(head);
        System.out.println("After deleting tail:");
        printList(head);
        head = deleteKth(head, 2);
        System.out.println("After deleting position 2:");
        printList(head);
        head = insertHead(head, 5);
        System.out.println("After inserting 5 at head:");
        printList(head);
        head = insertLast(head, 60);
        System.out.println("After inserting 60 at last:");
        printList(head);
        head = insertKth(head, 3, 25);
        System.out.println("After inserting 25 at position 3:");
        printList(head);
    }
}

