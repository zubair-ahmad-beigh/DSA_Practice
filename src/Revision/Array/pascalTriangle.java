package Revision.Array;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    static long combination(int n,int r){
        long result=1;
        for(int i=0;i<n;i++){
            result=result*(n-i)/(i+1);
        }
        return result;
    }
    /*static List<List<Integer>> generate(int numRow){
        List<List<Integer>>triangle=new ArrayList<>();
        for(int row=0;row<numRow;row++){
            List<Integer>currentRow=new ArrayList<>();
            for(int col=0;col <= row;col++){
                currentRow.add((int)combination(row,col));
            }
            triangle.add(currentRow);
        }
        return triangle;
    }*/
    static List<List<Integer>>generate(int numRows){
        List<List<Integer>>triangle=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>row=new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1)
                        + triangle.get(i - 1).get(j);
                row.add(value);
            }
            if(i>0){
                row.add(1);
            }
            triangle.add(row);
        }
        return triangle;
    }
    static List<List<Integer>>generatee(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(value);
            }
            if (i > 0) {
                row.add(1);
            }
            triangle.add(row);
        }
        return triangle;
    }



    static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
        System.out.println(generatee(numRows));

    }
}