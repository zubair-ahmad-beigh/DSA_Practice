package Revision.Array;

public class ArrayRev {
    public static int findMaximum(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

            }
        }
        return max;
    }

    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static double findAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public static void countEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even =" + even);
        System.out.println("Odd =" + odd);
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void ReverseOrder(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print
                    (arr[i] + " ");

        }
    }
    public static void findLargestSecondLargest(int[]arr){
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>largest){
                secondLargest=largest;
                largest=num;
            } else if (num>secondLargest && num!=largest) {
                secondLargest=num;
            }
        }
        System.out.println("Largest="+largest);
        System.out.println("SecondLargest");
    }
    public static int duplicates(int []arr){
        int i=0;
        for(int j=1;j< arr.length;j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }


    public static void main(String[] args) {

        int[] arr = {5, 4, 2, 8, 9,1, 1};

        System.out.println("Maximum number is: " + findMaximum(arr));

        System.out.println("Minimum number is: " + findMinimum(arr));

        System.out.println("Sum of the Array is: " + findSum(arr));

        System.out.println("Average of the Array is: " + findAverage(arr));

        countEvenOdd(arr);

        reverseArray(arr);

        System.out.print("Reversed Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] newArray = copyArray(arr);

        System.out.print("Copied Array: ");
        for (int num : newArray) {
            System.out.print(num + " ");
        }

        System.out.println();

        System.out.print("Reverse Order: ");
        ReverseOrder(arr);
        System.out.println( );
        int length = duplicates( arr);

        System.out.println("Unique Elements:");

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Total Unique Elements = " + length);
    }
}