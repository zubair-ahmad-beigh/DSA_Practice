package DoublyLinkedList;

import java.util.ArrayList;

public class deleteAllOccurance {
    static Node createDLL(int[] arr) {

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {

            Node newNode = new Node(arr[i]);

            current.next = newNode;
            newNode.prev = current;

            current = newNode;
        }

        return head;
    }

    // Print DLL
    static void printDLL(Node head) {

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

    static Node deleteAllOccurance(Node head, int key) {
        ArrayList<Node> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                list.add(temp);
            }
            temp = temp.next;
        }
        for (Node node : list) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
        return head;
    }

    static Node deleteAllOccurrences(Node head, int key) {

        Node current = head;

        while (current != null) {

            if (current.data == key) {

                Node nextNode = current.next;

                // If current is head
                if (current == head) {
                    head = nextNode;
                }

                // Connect previous node
                if (current.prev != null) {
                    current.prev.next = current.next;
                }

                // Connect next node
                if (current.next != null) {
                    current.next.prev = current.prev;
                }

                current = nextNode;

            } else {

                current = current.next;
            }
        }

        return head;
    }
    public static void main(String[] args) {

        int[] arr = {10, 20, 10, 30, 10, 40};

        int key = 10;

        Node head = createDLL(arr);

        System.out.println("Original DLL:");
        printDLL(head);

        head = deleteAllOccurrences(head, key);

        System.out.println("After deleting " + key + ":");
        printDLL(head);
    }
}
