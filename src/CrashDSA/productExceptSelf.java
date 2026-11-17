package CrashDSA;

import java.lang.reflect.Array;
import java.util.Arrays;

public class productExceptSelf {
    static int[] productExceptSelf(int[] arr){
        int n= arr.length;
        int []result=new int[n];
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=0;j<n;j++){
                if(i!=j){
                    product*=arr[j];
                }
            }
            result[i]=product;
        }
        return result;
    }
    static int[] productExceptself(int []arr){
        int n=arr.length;
        int []prefix=new int[n];
        int []suffix=new int[n];
        int []result=new int[n];
        prefix[0]=1;
        for(int i=0;i<n;i++){
            prefix[i]=prefix[i-1]*arr[i-1];
        }
        suffix[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]*arr[i+1];
        }
        for(int i=0;i<n;i++){
            result[i]=prefix[i]*suffix[i];
        }
        return result;
    }
    static int[] productExceptselfOptimal(int []arr){
        int n= arr.length;
        int []result=new int[n];
        result[0]=1;
        for(int i=1;i<n;i++){
            result[i]=result[i-1]*arr[i-1];
        }
        int suffix=1;
        for(int i=n-1;i>=0;i--){
            result[i]=result[i]*suffix;
            suffix=suffix*arr[i];
        }
        return result;
    }

    static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
        System.out.println(Arrays.toString(productExceptSelf(arr)));
        System.out.println(Arrays.toString(productExceptselfOptimal(arr)));
    }
}
