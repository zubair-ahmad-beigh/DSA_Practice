package BinarySearch;

import java.util.Arrays;

public class mediumInTwoDim {
    public static int mediumBrute(int [][]mat){
        int rows= mat.length;
        int cols=mat[0].length;
        int[] arr=new int[rows*cols];
        int k=0;
        for(int i=0;i<rows;i++){
            for (int j = 0; j <cols ; j++) {
                arr[k++]=mat[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
    public static int upperBound(int []row,int target){
        int low=0;
        int high= row.length;
        while(low<high){
            int mid=low+(high-low)/2;
            if(row[mid]<=target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
    public static int medium(int [][]mat){
        int n=mat.length;
        int m=mat[0].length;
        int low=mat[0][0];
        int high=mat[0][m-1];
        for(int i=1;i<n;i++){
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][m-1]);
        }
        int required=(n*m)/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=0;
            for(int i=0;i<n;i++){
                count+=upperBound(mat[i],mid);
            }
            if(count<=required){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    static void main(String[] args) {
        int[][] mat = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println("Median " +medium(mat));
    }
}
