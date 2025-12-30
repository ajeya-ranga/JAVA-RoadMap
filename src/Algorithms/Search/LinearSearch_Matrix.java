package Algorithms.Search;

import java.util.Arrays;

public class LinearSearch_Matrix {

    public static void main(String[] args) {

        int[][] mat = {{10,2,4,5},{4,7,9,7},{1,9,3,0}};
        int tar = 0;

        int[] index = linearSearchForMatrix(mat, tar);
        if(index[0] != -99){
            System.out.println("Target element found at index number " + Arrays.toString(index) + " !!");
        }
        else{
            System.out.println("Target element not found in the array");
        }
    }

    public static int[] linearSearchForMatrix(int[][] matrix, int target){

        for(int row = 0; row < matrix.length; row++){

            for(int col = 0; col < matrix[row].length; col++){

                if(matrix[row][col] == target){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-99,-99};
    }
}
