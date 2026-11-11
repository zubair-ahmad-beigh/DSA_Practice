package DoublyLinkedList;
import java.math.BigInteger;


public class addTwoNumbersLL {
    static BigInteger convertToNumber(Node head){
        StringBuilder sb=new StringBuilder();
        Node current=head;
        while(current!=null){
            sb.append(current.data);
            current=current.next;
        }
        return new BigInteger(sb.reverse().toString());
    }
    static Node addTwoNumberBrute(Node l1,Node l2){
        BigInteger num1=convertToNumber(l1);
        BigInteger num2=convertToNumber(l2);
        BigInteger sum=num1.add(num2);
        String result=sum.toString();
        Node dummy=new Node(0);
        Node current=dummy;
        for(int i=result.length()-1;i>=0;i--){
            int digit=result.charAt(i)-'0';
            current.next=new Node(digit);
            current=current.next;
        }
        return dummy.next;
    }
    static Node createList(int[] arr) {

        Node dummy = new Node(0);
        Node current = dummy;

        for (int value : arr) {
            current.next = new Node(value);
            current = current.next;
        }

        return dummy.next;
    }

    static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }
    static Node addTwoNumbers(
            Node l1, Node l2) {

        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            // Calculate digit and carry
            carry = sum / 10;
            int digit = sum % 10;

            // Create new result node
            current.next = new Node(digit);
            current = current.next;
        }

        return dummy.next;
    }



    public static void main(String[] args) {

        Node l1 = createList(new int[]{2, 4, 3});
        Node l2 = createList(new int[]{5, 6, 4});

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        Node result = addTwoNumberBrute(l1, l2);
        Node result2 = addTwoNumbers(l1, l2);

        System.out.println("Brute Force Result:");
        printList(result);
        System.out.println("Addition Result:");
        printList(result);
    }
}
