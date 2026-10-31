package DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class OddAndEvenLL {
    static Node oddEvenBrute(Node head){
        if(head==null){
            return null;
        }
        List<Integer>odd=new ArrayList<>();
        List<Integer>even=new ArrayList<>();
        Node temp=head;
        int position=1;
        while(temp!=null){
            if(position%2==1){
                odd.add(temp.data);
            }else{
                even.add(temp.data);
            }
            temp=temp.next;
            position++;
        }
        temp=head;
        for(int value:odd){
            temp.data=value;
            temp=temp.next;
        }
        for(int value:even){
            temp.data=value;
            temp=temp.next;
        }
        return head;
    }
    static Node oddEvenOptimal(Node head){
        if(head==null ||head.next==null){
            return head;
        }
        Node odd=head;
        Node even=head.next;
        Node evenHead=even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=even.next;
        return head;
    }
    static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print(" -> ");
            }
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original LinkedList:");
        printList(head);

        head = oddEvenOptimal(head);

        System.out.println("After Odd Even:");
        printList(head);
    }
}
