public class MaximumProduct {
    static int maxProduct(int[]arr){
        int n= arr.length;
        int prefix=1;
        int suffix=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0)prefix=1;
            if (suffix==0)suffix=1;
            prefix*=arr[i];
            suffix*=arr[n-1-i];
            max=Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }

    static void main(String[] args) {
        int arr[]={2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
}
