package BinarySearch.linkedList;

public class cnvtArrayintoLinkedList {
    static Node convert(int[] arr){
        Node head=null;
        for(int num:arr){
            Node newNode=new Node(num);
            if(head==null){
                head=newNode;
            }else{
                Node temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newNode;
            }
        }
        return head;
    }
    static Node convertBetter(int[] arr){
        Node head=null;
        Node tail=null;
        for(int num:arr){
            Node newNode=new Node(num);
            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = new Node(arr[0]);
        Node temp = head;
       for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
       }
            temp = head;
       while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
