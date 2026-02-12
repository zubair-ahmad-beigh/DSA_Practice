public class ReverseNumber {
     int revreseNo(int n){
        int rev=0;
        int lastDigit=0;
        while(n>0){
            lastDigit=n%10;
            n=n/10;
            rev=(rev*10)+lastDigit;
        }
        return rev;

    }
    boolean palindrome(int n){
         int dup=n;
         int rev=0;
         int lastdigit=0;
         while(n>0){
             lastdigit=n%10;
             n=n/10;
             rev=(rev*10)+lastdigit;
         }
         return dup==rev;
    }
    int power(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            result *= base;
            exp--;
        }
        return result;
    }

    boolean armstrong(int n) {
        if (n < 0) return false;
        int temp = n;
        int digits = 0;
        int sum = 0;
        int dup = n;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        while (n > 0) {
            int lastDigit = n % 10;
            sum += power(lastDigit, digits);
            n /= 10;
        }
        return sum == dup;
    }


    void divisor(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
    boolean isPrime(int num){
         if(num<=1)return false;
         for(int i=2;i*i<=num;i++){
             if(num%i==0){
                 return false;
             }
         }
        return true;
    }
    void Prime(int low,int high){
        for (int i = low; i<=high ; i++) {
            if(isPrime(i)){
                System.out.println(i+" ");
            }

        }
    }
    int gcd(int a,int b){
         while(b!=0){
             int rem=a%b;
             a=b;
             b=rem;
         }
         return a;
    }
    boolean isPalindrome(String s){
         int left=0;
         int right=s.length()-1;
         while(left<right){
             if(s.charAt(left)!=s.charAt(right)){
                 return false;
             }
             left++;
             right--;
         }
         return true;
    }
    static void main(String[] args) {
         ReverseNumber r=new ReverseNumber();

        System.out.println( r.revreseNo(12345));
        System.out.println(r.palindrome(121));
        System.out.println(r.armstrong(371));
        r.divisor(36);
        System.out.println(r.isPrime(4));
        r.Prime(2,9);
        System.out.println(r.isPalindrome("MadaM"));


    }
}
