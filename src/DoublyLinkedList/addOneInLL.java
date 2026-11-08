package DoublyLinkedList;

import java.math.BigInteger;

public class addOneInLL {
    static Node addOneBrute(Node head){
        if(head==null){
            return new Node(1);
        }
        StringBuilder number=new StringBuilder();
        Node current=head;
        while(current!=null){
            number.append(current.data);
            current=current.next;
        }
        BigInteger num=new BigInteger(number.toString());
        num=num.add(BigInteger.ONE);
        String result=num.toString();
        return createListFromString(result);
    }
    static Node createListFromString(String str){
        Node head=null;
        Node current=null;
        for(int i=0;i<str.length();i++){
            Node newNode=new Node(str.charAt(i)-'0');
            if(head==null){
                head=newNode;
                current=newNode;
            }else{
                current.next=newNode;
                current=newNode;
            }
        }
        return head;
    }
    static Node addOneBetter(Node head){
        int carry=addOneRecursive(head);
        if(carry>0){
            Node newHead=new Node(carry);
            newHead.next=head;
            head=newHead;
        }
        return head;
    }
    static int addOneRecursive(Node head){
        if(head==null){
            return 1;
        }
        int carry=addOneRecursive(head.next);
        int sum= head.data+carry;
        head.data=sum%10;
        return sum/10;
    }
    static Node addOneOptimal(Node head){
        if(head==null){
            return new Node(1);
        }
        Node reversed=reverse(head);
        Node current=reversed;
        Node prev=null;
        int carry=1;
        while(current!=null && carry>0){
            int sum=current.data+carry;
            current.data=sum%10;
            carry=sum/10;
            prev=current;
            current=current.next;
        }
        if(carry>0){
            prev.next=new Node(carry);

        }
        return reverse(reversed);
    }
    static Node reverse(Node head){
        Node prev=null;
        Node current=head;
        while(current!=null){
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    static Node createList(int[] arr){
        if(arr.length==0){
            return null;
        }
        Node head=new Node(arr[0]);
        Node current=head;
        for (int i = 0; i < arr.length; i++) {
            current.next=new Node(arr[i]);
            current=current.next;
        }
        return head;
    }
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {9, 9, 8, 9};
        Node head1 = createList(arr);
        System.out.println("Original List:");
        printList(head1);
        head1 = addOneBrute(head1);
        System.out.println("\nBrute Force - BigInteger:");
        printList(head1);
       Node head2 = createList(arr);
        head2 = addOneBetter(head2);
        System.out.println("\nBetter - Recursion:");
        printList(head2);
        Node head3 = createList(arr);
        head3 = addOneOptimal(head3);
        System.out.println("\nOptimal - Reverse:");
        printList(head3);
    }
}
