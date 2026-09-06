package Revision.Array;

import java.util.Arrays;

public class MergeTwoSortedArrNoExtraSpace {
    static void mergeTwo(int []arr1,int []arr2){
        int i= arr1.length-1;
        int j=0;
        while (i>=0 && j< arr2.length){
            if(arr1[i]>arr2[j]){
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                i--;
                j++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8};
        int[] arr2 = {2, 3, 9};

        mergeTwo(arr1, arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}

