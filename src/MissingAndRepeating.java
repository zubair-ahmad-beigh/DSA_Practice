public class MissingAndRepeating {
    static void findNumber(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int squareSum = 0;
        for (int num : arr) {
            sum += num;
            squareSum += (long) num * num;
        }
        long s = (long) n * (n +1) / 2;
        long s2 = (long) n * (n + 1) * (2 * n + 1) / 6;
        long diff = sum - s;
        long squareDiff = squareSum - s2;
        long sumXY = squareDiff / diff;
        long repeating = (diff + sumXY) / 2;
        long missing = repeating - diff;
        System.out.println("repeating:" + repeating);
        System.out.println("missing:" + missing);
    }
    static void findNumber2(int[] arr){
        int n= arr.length;
        int freq[]=new int[n+1];
        for(int num:arr){
            freq[num]++;
        }
        int repeating=-1;
        int missing=-1;
        for (int i = 0; i <=n ; i++) {
            if(freq[i]==0){
                missing=i;
            }
            else if(freq[i]==2){
                repeating=i;
            }
        }
        System.out.println("missing:"+missing);
        System.out.println("repeating"+repeating);
    }

    static void main(String[] args) {
        int arr[]={1,2,4,4,5,6,7};
        findNumber(arr);
        findNumber2(arr);
    }
}

