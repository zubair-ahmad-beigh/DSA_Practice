public class MoveZeroes {
    static void moveZeroe(int[] arr){
        int i=0;
        for(int j=0;j< arr.length;j++){
            if(arr[j]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
    }

    static void main(String[] args) {
        int []arr={0,0,9,0,6,4};
        moveZeroe(arr);
        for (int num:arr){
            System.out.print(num+" ");
        }
    }
}
