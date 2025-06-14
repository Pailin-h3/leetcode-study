package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,2,0},
            {3,4,5,2},
            {1,5,1,5}
        };

        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        List<Integer> colList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ",matrix[i][j]);
                if(matrix[i][j] == 0){
                    for (int j2 = 0; j2 < matrix[i].length; j2++) {
                        if(matrix[i][j2] == 0){
                            colList.add(j2);
                        }
                        matrix[i][j2] = 0;
                    }
                    break;
                }
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(colList.toArray()));
        for (Integer col : colList) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix.length; j++) {
        //         if(matrix[i][j] == 0){
        //             setZeroes2(matrix, i, j);
        //         }
        //     }
        // }

        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }

    // public static void setZeroes2(int[][] matrix, int i, int j) {
    //     if(i < 0 || j < 0 || i == matrix.length || j == matrix[i].length || matrix[i][j] == 0){
    //         return;
    //     }
        
    //     matrix[i][j] = 0;
    //     setZeroes2(matrix, i-1, j); // up
    //     setZeroes2(matrix, i+1, j); // down
    //     setZeroes2(matrix, i, j-1); // left
    //     setZeroes2(matrix, i, j+1); // right
    // }

}
