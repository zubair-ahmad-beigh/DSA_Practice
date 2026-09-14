package Revision.Array;

public class StringReverse {
    public static String reverse1(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public static String reverse2(String str){
        char[] arr=str.toCharArray();
        int left=0;
        int right= arr.length-1;
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return new String(arr);
    }
    public static String reverse3(String str){
        String result="";
        for(int i=str.length()-1;i>=0;i--){
            result+=str.charAt(i);
        }
        return result;
    }
    public static String reverse4(String str){
        StringBuilder result=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            result.append(str.charAt(i));
        }
        return result.toString();
    }
    public static String reverse5(String str) {

        if (str == null || str.length() <= 1) {
            return str;
        }

        return reverse5(str.substring(1)) + str.charAt(0);
    }
    public static String reverse6(String str) {

        char[] chars = str.toCharArray();

        for (int left = 0, right = chars.length - 1;
             left < right;
             left++, right--) {

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }

        return String.valueOf(chars);
    }
    public static void main(String[] args) {

        String str = "hello";

        System.out.println("Method 1: " + reverse1(str));
        System.out.println("Method 2: " + reverse2(str));
        System.out.println("Method 3: " + reverse3(str));
        System.out.println("Method 4: " + reverse4(str));
        System.out.println("Method 5: " + reverse5(str));
        System.out.println("Method 6: " + reverse6(str));
    }
}
