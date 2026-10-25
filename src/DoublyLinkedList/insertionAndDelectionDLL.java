package DoublyLinkedList;

public class insertionAndDelectionDLL {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Print DLL
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }
    static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;
        return newHead;
    }
    static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.prev.next = null;
        tail.prev = null;
        return head;
    }
    static Node deleteKth(Node head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        if (k == 1) {
            return deleteHead(head);
        }
        Node curr = head;
        int count = 1;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            return head;
        }
        Node before = curr.prev;
        Node after = curr.next;
        before.next = after;
        if (after != null) {
            after.prev = before;
        }
        curr.prev = null;
        curr.next = null;
        return head;
    }
    static Node deleteGivenNode(Node head, Node node) {
        if (head == null || node == null) {
            return head;
        }
        if (node == head) {
            return deleteHead(head);
        }
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        if (after != null) {
            after.prev = before;
        }
        node.prev = null;
        node.next = null;
        return head;
    }
    static Node insertHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }
    static Node insertTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.prev = tail;
        return head;
    }
    static Node insertBeforeKth(Node head, int k, int data) {
        if (k < 1) {
            return head;
        }
        if (k == 1) {
            return insertHead(head, data);
        }
        Node curr = head;
        int count = 1;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            return head;
        }
        Node before = curr.prev;
        Node newNode = new Node(data);
        newNode.prev = before;
        newNode.next = curr;
        before.next = newNode;
        curr.prev = newNode;
        return head;
    }
    public static void main(String[] args) {
        Node head = null;

        head = insertTail(head, 10);
        head = insertTail(head, 20);
        head = insertTail(head, 30);
        head = insertTail(head, 40);

        System.out.print("Original: ");
        printList(head);

        head = deleteHead(head);
        System.out.print("Delete Head: ");
        printList(head);

        head = insertHead(head, 10);
        head = deleteTail(head);
        System.out.print("Delete Tail: ");
        printList(head);

        head = insertTail(head, 40);
        head = deleteKth(head, 2);
        System.out.print("Delete Kth (2): ");
        printList(head);

        // Delete the node containing 30
        Node temp = head;

        while (temp != null && temp.data != 30) {
            temp = temp.next;
        }

        head = deleteGivenNode(head, temp);
        System.out.print("Delete Given Node (30): ");
        printList(head);

        head = insertHead(head, 5);
        System.out.print("Insert Head (5): ");
        printList(head);

        head = insertTail(head, 50);
        System.out.print("Insert Tail (50): ");
        printList(head);

        head = insertBeforeKth(head, 2, 15);
        System.out.print("Insert 15 Before K=2: ");
        printList(head);
    }
}

