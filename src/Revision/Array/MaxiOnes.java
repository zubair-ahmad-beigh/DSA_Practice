package Revision.Array;

public class MaxiOnes {
    public static int maxiOne(int []arr){
        int n= arr.length;
        int max=0;
        for (int i = 0; i < n; i++) {
            int count=0;
            for (int j = i; j <n ; j++) {
                if(arr[j]==1){
                    count++;
                    max=Math.max(count,max);
                }else{
                    break;
                }
            }
        }
        return max;
    }
    public static int  MaxiOne(int[]arr){
        int count=0;
        int max=0;
        for(int i=0;i< arr.length;i++){
            if(arr[i]==1){
                count++;
                max=Math.max(count,max);
            }else{
                count=0;
            }
        }
        return max;
    }


    static void main(String[] args) {
        int []arr={1,0,0,1,1,1,0,1,1,1,1};
        System.out.println(maxiOne(arr));
        System.out.println(MaxiOne(arr));
    }
}
