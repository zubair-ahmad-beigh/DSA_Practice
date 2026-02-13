public class SecondLargest {
    static int findSecondLargest(int[] arr){
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];

            } else if (arr[i]>secondLargest && arr[i]!=largest) {
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }

    static void main(String[] args) {
        int arr[]={5,2,3,1,6,2,6,4};
        int result=findSecondLargest(arr);
        System.out.println("secondLargest:"+result);
    }

}
