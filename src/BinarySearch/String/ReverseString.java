package BinarySearch.String;

public class ReverseString {
    public static String reverseWordsBrute(String s){
        String[] words=s.trim().split("\\s+");
        String result= "";
        for (int i = words.length-1; i >-0 ; i--) {
            result+=words[i];
            if(i>0){
                result +=" ";
            }
        }
        return result;
    }
    public static String reverseWordsBetter(String s){
        String []words=s.trim().split("\\s+");
        StringBuilder result=new StringBuilder();
        for (int i= words.length-1;i>=0;i--){
            result.append(words[i]);
            if(i>0){
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        String s="the sky is blue";
        System.out.println("Brute: "+reverseWordsBrute(s));
        System.out.println("Better: "+ reverseWordsBetter(s));
    }
}
