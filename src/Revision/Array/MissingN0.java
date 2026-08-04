package Revision.Array;

public class MissingN0 {
    public static int Miss(int[] arr) {

        int n = arr.length;

        for (int i = 1; i <= n; i++) {

            boolean found = false;

            for (int j = 0; j < n; j++) {

                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return i;
            }
        }

        return -1;
    }
    public static int Msss(int []arr){
        int n= arr.length;
        int []hash=new int[n+1];
        for(int i=1;i<n;i++){
            hash[arr[i]]++;
        }
        for (int i = 0; i <=n ; i++) {
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }
    public static int MissingNumber(int []arr){
        int n = arr.length+1;

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    public static int MissXor(int []arr){
        int n= arr.length+1;
        int xor1=0;
        int xor2=0;
        for (int i = 0; i <=n ; i++) {
            xor1^=i;
        }
        for (int num:arr){
            xor2^=num;
        }
        return xor1^xor2;
    }

    static void main(String[] args) {
        int []arr={1,2,4,5};
        //   System.out.println(Miss(arr));
        System.out.println(MissingNumber(arr));
        System.out.println(MissXor(arr));
    }
}
