package DoublyLinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class sortZerosOnesTwo {
    static Node sortBrute(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        Collections.sort(list);
        current = head;
        int i = 0;
        while (current != null) {
            current.data = list.get(i);
            current = current.next;
            i++;
        }
        return head;
    }

    static Node sortBetter(Node head) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        Node current = head;
        while (current != null) {
            if (current.data == 0) {
                count0++;
            } else if (current.data == 1) {
                count1++;
            } else {
                count2++;
            }
            current = current.next;
        }
        current = head;
        while (current != null) {
            if (count0 > 0) {
                current.data = 0;
                count0--;
            } else if (count1 > 0) {
                current.data = 1;
                count1--;
            } else {
                current.data = 2;
                count2--;
            }
            current = current.next;
        }
        return head;
    }

    static Node createList(int[] arr) {

        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {

            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    // PRINT LINKED LIST
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

    // MAIN FUNCTION
    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 1, 0, 2, 1};

        // Brute Force
        Node head1 = createList(arr);

        System.out.println("Original List:");
        printList(head1);

        head1 = sortBrute(head1);

        System.out.println("\nBrute Force:");
        printList(head1);

        // Better
        Node head2 = createList(arr);

        head2 = sortBetter(head2);

        System.out.println("\nBetter - Counting:");
        printList(head2);
    }
}