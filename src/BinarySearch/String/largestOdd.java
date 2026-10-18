package BinarySearch.String;

public class largestOdd {
    public static Boolean largestOddBrute(String num){
        for (int i = 0; i < num.length(); i++) {
            String sub = num.substring(0, i + 1);

            int lastDigit = sub.charAt(sub.length() - 1) - '0';

            if (lastDigit % 2 == 1) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args){
        String num="354269";
        System.out.println(largestOddBrute(num));
    }

}
