package Revision;

public class GCD_HCF {
    public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    static void main(String[] args) {
        System.out.println(gcd(12,48));
    }
}
