package DoublyLinkedList;

import java.util.ArrayList;

public class nthNodeRemove {
    static Node removeNthBrute(Node head,int n){
        ArrayList<Node>list=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        int index=list.size()-n;
        if(index==0){
            return head.next;
        }
        Node previous=list.get(index-1);
        previous.next=previous.next.next;
        return head;
    }
    static Node removeNthBetter(Node head,int n){
        int length=0;
        Node temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        if(length==n){
            return head.next;
        }
        temp=head;
        for(int i=1;i<length-n;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
    static Node removeNthOptimal(Node head,int n){
        Node dummy=new Node(0);
        dummy.next=head;
        Node slow=dummy;
        Node fast=dummy;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    static Node createList() {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        return head;
    }
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }
    public static void main(String[] args) {

        int n = 2;

        // Brute
        Node head1 = createList();
        System.out.println("Brute Force:");
        printList(removeNthBrute(head1, n));

        // Better
        Node head2 = createList();
        System.out.println("Better Approach:");
        printList(removeNthBetter(head2, n));

        // Optimal
        Node head3 = createList();
        System.out.println("Optimal Approach:");
        printList(removeNthOptimal(head3, n));
    }
}

