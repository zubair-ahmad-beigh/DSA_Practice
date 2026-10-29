package DoublyLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class detectLoopLength {
    static int loopLengthBrute(Node head){
        List<Node> visited=new ArrayList<>();
        Node current=head;
        while(current!=null){
            for(int i=0;i<visited.size();i++){
                if(visited.get(i)==current){
                    return visited.size()-i;
                }
            }
            visited.add(current);
            current=current.next;
        }
        return 0;
    }
    static int loopLengthBetter(Node head){
        Map<Node,Integer> visited=new HashMap<>();
        Node current=head;
        int position=0;
        while(current!=null){
            if(visited.containsKey(current)){
                return position-visited.get(current);
            }
            visited.put(current,position);
            current=current.next;
            position++;
        }
        return 0;
    }
    static int loopLengthOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                Node temp = slow.next;
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }
        return 0;
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

        // Create loop: 50 points back to 30
        fifth.next = third;

        int length = loopLengthOptimal(head);

        System.out.println("Length of loop: " + length);
    }
}
