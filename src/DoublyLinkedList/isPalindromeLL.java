package DoublyLinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class isPalindromeLL {
    static boolean isPalindromeBrute(Node head){
        ArrayList<Integer>list=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        int left=0;
        int right=list.size()-1;
        while(left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static boolean isPalindromeBetter(Node head){
        Stack<Integer>stack=new Stack<>();
        Node temp=head;
        while(temp!=null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data!=stack.pop()){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }
    static boolean isPalindromeOptimal(Node head){
        if(head==null ||head.next==null){
            return true;
        }
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node secondHalf=reverse(slow.next);
        Node firstHalf=head;
        Node Second=secondHalf;
        while(Second!=null){
            if(firstHalf.data!=Second.data){
                return false;
            }
            firstHalf=firstHalf.next;
            Second=Second.next;
        }
        return true;
    }
    static Node reverse(Node head){
        Node prev=null;
        Node current=head;
        while (current!=null){
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        if (isPalindromeOptimal(head)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
