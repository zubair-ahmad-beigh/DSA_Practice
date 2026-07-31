package Revision.Array;

public class moveZeroes {
    public static void Movezeroe(int []arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    static void main(String[] args) {
        int []arr={1,2,3,0,3,0,6};
        Movezeroe(arr);
        System.out.print("Array after moving zeroes: ");
        for (int num:arr){
            System.out.print(num+" ");
        }

        }
    }
