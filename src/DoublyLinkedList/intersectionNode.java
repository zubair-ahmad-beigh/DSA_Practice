package DoublyLinkedList;

import java.util.HashSet;

public class intersectionNode {
    static Node intersectionBrute(Node headA,Node headB){
        Node temp1=headA;
        while(temp1!=null){
            Node temp2=headB;
            while(temp2!=null){
                if(temp1==temp2){
                    return temp1;
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return null;
    }
    static Node intersectionBetter(Node headA,Node headB){
        HashSet<Node>set=new HashSet<>();
        Node current=headA;
        while(current!=null){
            set.add(current);
            current=current.next;
        }
        current=headB;
        while(current!=null){
            if(set.contains(current)){
                return current;
            }
            current=current.next;
        }
        return null;
    }
    static Node intersectionOptimal(Node headA,Node headB){
        if(headA==null || headB==null){
            return null;
        }
        Node p1=headA;
        Node p2=headB;
        while(p1!=p2){
            p1=(p1==null)?headB:p1.next;
            p2=(p2==null)?headA:p2.next;
        }
        return p1;
    }

    static Node createList(int[] arr) {

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


    // =====================================
    // PRINT LINKED LIST
    // =====================================

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


    // =====================================
    // MAIN FUNCTION
    // =====================================

    public static void main(String[] args) {

        // Create common part
        Node common = createList(new int[]{6, 7, 8});

        // Create first list
        Node headA = createList(new int[]{1, 2, 3});

        Node tempA = headA;

        while (tempA.next != null) {
            tempA = tempA.next;
        }

        // Attach common part
        tempA.next = common;


        // Create second list
        Node headB = createList(new int[]{4, 5});

        Node tempB = headB;

        while (tempB.next != null) {
            tempB = tempB.next;
        }

        // Attach SAME common part
        tempB.next = common;


        System.out.println("Linked List A:");
        printList(headA);

        System.out.println("Linked List B:");
        printList(headB);


        // Test Brute Force
        Node result1 = intersectionBrute(headA, headB);

        System.out.println("\nBrute Force Intersection:");
        System.out.println(result1 != null ? result1.data : "No Intersection");


        // Test Better
        Node result2 = intersectionBetter(headA, headB);

        System.out.println("\nBetter - HashSet:");
        System.out.println(result2 != null ? result2.data : "No Intersection");


        // Test Optimal
        Node result3 = intersectionOptimal(headA, headB);

        System.out.println("\nOptimal - Two Pointers:");
        System.out.println(result3 != null ? result3.data : "No Intersection");
    }
}
