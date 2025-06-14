package BinarySearch;

public class Search2dMetrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,34,40,50}
        };
        int target = 11;

        searchMatrix(matrix, target);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == target) return true;
            if(matrix[i][0] > target){
                if(i == 0) return false;

                for (int j = 1; j < matrix[i-1].length; j++) {
                    if(matrix[i-1][j] == target) return true;
                }
                break;
            } 
            if(i == matrix.length-1){
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == target) return true;
                }
                break;
            }
        }

        return false;
    }
}
