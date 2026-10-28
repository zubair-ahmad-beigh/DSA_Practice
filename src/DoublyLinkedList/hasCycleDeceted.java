package DoublyLinkedList;

public class hasCycleDeceted {
    static boolean hasCycleBrute(Node head){
        Node current=head;
        while(current!=null){
            Node previous=head;
            while (previous!=current){
                if(previous==current){
                    return true;
                }
                previous=previous.next;
            }
            current=current.next;
        }
        return false;
    }
    static boolean hasCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    static void main(String[] args) {
        Node head=new Node(10);
        Node second=new Node(20);
        Node third=new Node(30);
        Node fourth=new Node(40);
        Node fifth=new Node(50);
        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=third;
        if(hasCycle(head)){
            System.out.println("Loop detected");
        }else{
            System.out.println("No Loop");
        }
    }
}
