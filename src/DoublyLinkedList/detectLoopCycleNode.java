package DoublyLinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class detectLoopCycleNode {
    static Node detectLoopNodeBrute(Node head){
        List<Node>visited=new ArrayList<>();
        Node current=head;
        while(current!=null){
            for(Node node:visited){
                if(node==current){
                    return current;
                }
            }
            visited.add(current);
            current=current.next;
        }
        return null;
    }
    static Node detectLoopNodeBetter(Node head){
        Set<Node>visited=new HashSet<>();
        Node current=head;
        while(current!=null){
            if(visited.contains(current)){
                return current;
            }
            visited.add(current);
            current=current.next;
        }
        return null;
    }
    static Node detectCycleOptimal(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {

        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create a loop: 50 points back to 30
        fifth.next = third;

        Node result = detectCycleOptimal(head);

        if (result != null) {
            System.out.println(
                    "Loop starts at node: " + result.data
            );
        } else {
            System.out.println("No loop found");
        }
    }
}
