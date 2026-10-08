package BinarySearch;

public class BSTwoD {
    public static boolean searchBrute(int[][]matrix,int target){
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean searchBetter(int[][]matrix,int target){
        int rows= matrix.length;
        int cols= matrix[0].length;
        for(int i=0;i<rows;i++){
            int low=0;
            int high=cols-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(matrix[i][mid]==target){
                    return true;
                }
                if(matrix[i][mid]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
    public static boolean searchOptimal(int [][]matrix,int target){
        int rows= matrix.length;
        int cols= matrix[0].length;
        int low=0;
        int high=rows*cols-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/cols;
            int col=mid%cols;
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int target = 7;

        System.out.println("Brute: " +
                searchBrute(matrix, target));

        System.out.println("Better: " +
                searchBetter(matrix, target));

        System.out.println("Optimal: " +
                searchOptimal(matrix, target));
    }
}
