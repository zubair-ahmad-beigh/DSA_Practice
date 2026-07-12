package Revision.Recusion;

public class Print1_5 {
    static void printNumbers(int n){
        if(n==6){
            return;
        }
        System.out.println(n);
        printNumbers(n+1);
    }
    static int SumNumbers(int n){
        if(n==1){
            return 1;
        }
        return n+SumNumbers(n-1);
    }
    static int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    static int fib(int n) {
        if (n == 0)return 0;
        if(n==1)return 1;
        return fib(n-1)+fib(n-2);
    }
    static void reverse(String str,int index ){
        if(index==str.length())return;
        reverse(str,index+1);
        System.out.print(str.charAt(index));
    }

    static void main(String[] args) {
        printNumbers(1);
        System.out.println(SumNumbers(5));
        System.out.println(factorial(5));
        System.out.println(fib(6));
        reverse("Hello",0);
    }
}
