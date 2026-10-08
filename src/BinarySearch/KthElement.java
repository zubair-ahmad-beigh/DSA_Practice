package BinarySearch;

public class KthElement {
    public static int kthElementBrute(int []arr1,int []arr2,int k){
        int n=arr1.length;
        int m=arr2.length;
        int []merged=new int [n+m];
        int i=0,j=0,index=0;
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                merged[index++]=arr1[i++];
            }else{
                merged[index++]=arr2[j++];
            }
        }
        while(i<n){
            merged[index++]=arr1[i++];
        }
        while(j<m){
            merged[index++]=arr2[j++];
        }
        return merged[k-1];
    }
    public static int kthElementBetter(int[]arr1,int []arr2,int k){
        int i=0;
        int j=0;
        int count=0;
        while(i<arr1.length && j<arr2.length){
            int current;
            if(arr1[i]<=arr2[j]){
                current=arr1[i++];
            }else{
                current=arr2[j++];
            }
            count++;
            if(count==k){
                return current;
            }
        }
        while(i<arr1.length){
            count++;
            if(count==k){
                return arr1[i];
            }
            i++;
        }
        while(j<arr2.length){
            count++;
            if(count==k){
                return arr2[j];
            }
            j++;
        }
        return -1;
    }
    public static int kthElementOptimal(int []arr1,int[]arr2,int k){
        if(arr1.length>arr2.length){
            return kthElementOptimal(arr2,arr1,k);
        }
        int n=arr1.length;
        int m=arr2.length;
        int low=Math.max(0,k-m);
        int high=Math.max(k,n);
        while(low<=high){
            int cut1=low+(high-low)/2;
            int cut2=k-cut1;
            int left1=(cut1==0)?Integer.MIN_VALUE:arr1[cut1-1];
            int right1=(cut1==n)?Integer.MAX_VALUE:arr1[cut1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int right2 = (cut2 == m) ? Integer.MAX_VALUE : arr2[cut2];
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            }

            // arr1's left part is too large
            else if (left1 > right2) {

                high = cut1 - 1;
            }

            // arr1's left part is too small
            else {

                low = cut1 + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {

        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};

        int k = 5;

        System.out.println("Brute: " +
                kthElementBrute(arr1, arr2, k));

        System.out.println("Better: " +
                kthElementBetter(arr1, arr2, k));

        System.out.println("Optimal: " +
                kthElementOptimal(arr1, arr2, k));
    }
}
