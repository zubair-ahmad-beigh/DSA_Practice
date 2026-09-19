package BinarySearch;

public class nthRootBrute {
    static int nthrootBrute(int n,int m){
        for (int  x= 0; x <=m ; x++) {
            long result=1;
            for(int i=0;i<n;i++){
                result*=x;
                if(result>m){
                    break;
                }
            }
            if(result==m){
                return x;
            }
            if(result>m){
                break;
            }
        }
        return -1;
    }
    static int powerCheck(int mid,int n,int m){
        long result=1;
        for(int i=1;i<=n;i++){
            result*=mid;
            if(result>m){
                return 2;
            }
        }
        if(result==m){
            return 1;
        }
        return 0;
    }
    static int nthRoot(int n, int m) {

        int low = 1;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result = powerCheck(mid, n, m);

            if (result == 1) {

                // Exact Nth root mil gaya
                return mid;

            } else if (result == 0) {

                // mid^n < m
                // bada answer search karo
                low = mid + 1;

            } else {

                // mid^n > m
                // chhota answer search karo
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 3;
        int m = 27;

        System.out.println(nthRoot(n, m));
    }
}

