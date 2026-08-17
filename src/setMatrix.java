public class setMatrix {
    static void setZeroes(int [][]matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    for(int k=0;k<cols;k++){
                        if(matrix[i][k]!=0){
                            matrix[i][k]=-1;
                        }
                    }
                    for(int k=0;k<rows;k++){
                        if(matrix[k][j]!=0){
                            matrix[k][j]=-1;
                        }
                    }
                }
            }
        }
        for(int i=0;i<rows;i++){
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void setZeroees(int[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean[]row=new boolean[rows];
        boolean[]col=new boolean[cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(row[i]||row[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void setZeroesss(int [][]matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean firstColZero=false;
        for(int i=0;i<rows;i++){
            if(matrix[i][0]==0){
                firstColZero=true;
            }
            for(int j=1;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<rows;i++){
            for (int j = 0; j < cols; j++) {
                if(matrix[i][0]==0 ||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<cols;j++){
                matrix[0][j]=0;
            }
        }
        if(firstColZero){
            for(int i=0;i<rows;i++){
                matrix[i][0]=0;
            }
        }
    }

    static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroes(matrix);

        // Print matrix
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

}
