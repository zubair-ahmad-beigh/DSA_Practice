
import java.util.*;

class sortLinkedList {

    // Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ==================================
    // 1. BRUTE FORCE - ARRAYLIST + SORT
    // ==================================

    static ListNode sortBrute(ListNode head) {

        if (head == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();

        ListNode current = head;

        // Store all values
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Sort values
        Collections.sort(list);

        // Update linked list
        current = head;
        int i = 0;

        while (current != null) {
            current.val = list.get(i);
            current = current.next;
            i++;
        }

        return head;
    }


    // ==================================
    // 2. BETTER - INSERTION SORT
    // ==================================

    static ListNode sortBetter(ListNode head) {

        ListNode dummy = new ListNode(0);

        ListNode current = head;

        while (current != null) {

            // Save next node
            ListNode next = current.next;

            ListNode temp = dummy;

            // Find correct position
            while (temp.next != null &&
                    temp.next.val <= current.val) {

                temp = temp.next;
            }

            // Insert current node
            current.next = temp.next;
            temp.next = current;

            current = next;
        }

        return dummy.next;
    }


    // ==================================
    // 3. OPTIMAL - MERGE SORT
    // ==================================

    static ListNode sortOptimal(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split linked list
        prev.next = null;

        // Sort left and right halves
        ListNode left = sortOptimal(head);
        ListNode right = sortOptimal(slow);

        // Merge sorted halves
        return merge(left, right);
    }

    // Merge two sorted linked lists
    static ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {

                tail.next = left;
                left = left.next;

            } else {

                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;
    }


    // ==================================
    // CREATE LINKED LIST
    // ==================================

    static ListNode createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);

        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {

            current.next = new ListNode(arr[i]);

            current = current.next;
        }

        return head;
    }


    // ==================================
    // PRINT LINKED LIST
    // ==================================

    static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {

            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }


    // ==================================

    // ==================================

    public static void main(String[] args) {

        int[] arr = {4, 2, 1, 3, 5};

        // Test Brute Force
        ListNode head1 = createList(arr);

        System.out.println("Original List:");
        printList(head1);

        head1 = sortBrute(head1);

        System.out.println("\nBrute Force - ArrayList:");
        printList(head1);


        // Test Better
        ListNode head2 = createList(arr);

        head2 = sortBetter(head2);

        System.out.println("\nBetter - Insertion Sort:");
        printList(head2);


        // Test Optimal
        ListNode head3 = createList(arr);

        head3 = sortOptimal(head3);

        System.out.println("\nOptimal - Merge Sort:");
        printList(head3);
    }
}
