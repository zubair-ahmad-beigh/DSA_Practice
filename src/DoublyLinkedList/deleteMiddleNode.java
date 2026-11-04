package DoublyLinkedList;

public class deleteMiddleNode {
    static Node deleteMiddle(Node head){
        if(head==null|| head.next==null){
            return null;
        }
        Node slow=head;
        Node fast=head;
        Node prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
    public static Node createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Print Linked List
    public static void printList(Node head) {

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

    // Main Function
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        Node head = createList(arr);

        System.out.println("Original Linked List:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("After Deleting Middle Node:");
        printList(head);
    }
}
