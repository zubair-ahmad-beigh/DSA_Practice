package DoublyLinkedList;

import java.sql.Statement;

public class CnvtArrayIntoLinkedList {
    static Node ConvertArrayToDll(int []arr){
        if(arr.length==0){
            return null;
        }
        Node head=new Node(arr[0]);
        Node prev=head;
        for(int i=1;i<arr.length;i++){
            Node curr=new Node(arr[i]);
            prev.next=curr;
            curr.prev=prev;
            prev=curr;
        }
        return head;
    }
    static void printForward(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
        System.out.println();
    }
    static void printBackward(Node head){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.prev;
        }
        System.out.println();
    }

    static void main(String[] args) {
        int []arr={10,20,30,40};
        Node head=ConvertArrayToDll(arr);
        System.out.println("Forward");
        printForward(head);
        System.out.println("Backward");
        printBackward(head);
    }

}
