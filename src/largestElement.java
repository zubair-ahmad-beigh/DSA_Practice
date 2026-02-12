public class largestElement {
   static int findLargest(int[] arr){
       int max=arr[0];
       for (int i = 0; i < arr.length; i++) {
           if(arr[i]>max){
               max=arr[i];
           }
       }
       return max;
   }

    static void main(String[] args) {
        int[] arr={5,2,3,6,3,1,4,9};
        int largest=findLargest(arr);
        System.out.println("largest:"+largest);
    }
}