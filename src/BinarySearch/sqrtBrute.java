package BinarySearch;

public class sqrtBrute {
    static int floorSqrtBrute(int n){
        int ans=0;
        for(int i=1;i<=n;i++){
            if((long)i*i<=n){
                ans=i;
            }else{
                break;
            }
        }
        return ans;
    }
    static int floorSqrt(int n){
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((long)mid*mid<=n){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    static int maxInteger(int n){
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((long)mid*mid<=n){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    static void main(String[] args) {
        int n=27;
        System.out.println(floorSqrtBrute(n));
        System.out.println(floorSqrt(n));
        System.out.println(maxInteger(n));
    }
}
