package BinarySearch;

public class peakTwoDim {
    public static int[]findPeakBrute(int[][]mat){
        int n= mat.length;
        int m=mat[0].length;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<m;j++){
                boolean up=(i==0||mat[i][j]>mat[i-1][j]);
                    boolean down=(i==n-1||mat[i][j]>mat[i+1][j]);
                    boolean left=(j==0 || mat[i][j]>mat[i][j-1]);
                    boolean right=(j==m-1 || mat[i][j]>mat[i][j+1]);
                    if(up && down && left && right){
                        return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] findPeak(int [][]mat){
        int n= mat.length;
        int m=mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int maxRow=0;
            for(int i=1;i<n;i++){
                if(mat[i][mid]>mat[maxRow][mid]){
                    maxRow=i;
                }
            }
            int left=(mid>0)?mat[maxRow][mid - 1]: Integer.MIN_VALUE;
            int right = (mid < m - 1) ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;
            if (mat[maxRow][mid] > left &&
                    mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            }

            // Bigger neighbour on the right
            if (right > mat[maxRow][mid]) {
                low = mid + 1;
            } else {
                // Bigger neighbour on the left
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
        };
        int[] result = findPeak(mat);
        System.out.println("Peak element: "+ mat[result[0]][result[1]]);
        System.out.println("Row: " + result[0]);
        System.out.println("Column: " + result[1]);
    }
}
