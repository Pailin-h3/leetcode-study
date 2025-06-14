package Matrix;

public class ValidateSudoku {
    public static void main(String[] args) {
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        func(board1);
    }

    public static boolean func(char[][] board) {
        boolean rowIsValid = validateRow(board);
        System.out.println();
        boolean columnIsValid = validateColumn(board);
        System.out.println();
        boolean squareIsValid = validateSquare(board);
        System.out.println();

        System.out.println();
        System.out.println(rowIsValid);
        System.out.println(columnIsValid);
        System.out.println(squareIsValid);
        
        return rowIsValid && columnIsValid && squareIsValid;
    }

    private static boolean validateRow(char[][] board){
        for(char[] row : board){
            String rowStr = "";
            for(char c : row){
                if(c != '.'){
                    rowStr += c;
                }
            }
            System.out.println(rowStr);

            for(int i = 0 ; i<rowStr.length()-1 ; i++){
                for(int k = i+1 ; k<rowStr.length() ; k++){
                    if(rowStr.charAt(i) == rowStr.charAt(k)){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean validateColumn(char[][] board){
        for(int j = 0 ; j < board[0].length ; j++){
            String colStr = "";
            for(int c = 0 ; c < board.length ; c++){
                if(board[c][j] != '.'){
                    colStr += board[c][j];
                }
            }
            System.out.println(colStr);

            for(int i = 0 ; i<colStr.length()-1 ; i++){
                for(int k = i+1 ; k<colStr.length() ; k++){
                    if(colStr.charAt(i) == colStr.charAt(k)){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean validateSquare(char[][] board){
        for(int s = 0 ; s < 3 ; s++){
            for(int sb = 0 ; sb < 3 ; sb++){
                String squareStr = "";
                for(int i = s*3 ; i < (s*3) + 3 ; i++){
                    for(int j = sb*3 ; j < (sb*3) + 3 ; j++){
                        if(board[i][j] != '.'){
                            squareStr += board[i][j];
                        }
                    }
                }
                System.out.printf("%s\n", squareStr);
                
                for(int i = 0 ; i<squareStr.length()-1 ; i++){
                    for(int k = i+1 ; k<squareStr.length() ; k++){
                        if(squareStr.charAt(i) == squareStr.charAt(k)){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
