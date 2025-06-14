package Matrix;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        func(matrix);

    }

    public static void func(int[][] matrix) {
        for(int i = 0 ; i<matrix.length ; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        transpose(matrix);
        System.out.println();

        for(int i = 0 ; i<matrix.length ; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        flipH(matrix);
        System.out.println();

        for(int i = 0 ; i<matrix.length ; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void transpose(int[][] matrix){
        for(int i = 0 ; i<matrix.length ; i++){
            for (int j = i; j < matrix[i].length; j++) {
                System.out.printf("%d swapped to %d\n", matrix[i][j], matrix[j][i]);
                int p = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = p;
            }
        }
    }

    public static void flipH(int[][] matrix){
        for(int j = 0 ; j<matrix.length/2 ; j++){
            for (int i = 0; i < matrix.length; i++) {
                System.out.printf("%d swapped to %d\n", matrix[i][j], matrix[i][matrix.length -j-1]);
                int p = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length -j-1];
                matrix[i][matrix.length -j-1] = p;
            }
        }
    }
}
