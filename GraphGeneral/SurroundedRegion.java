package GraphGeneral;

public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] grid = {
            {'X','X','X','X','X'},
            {'X','O','O','O','X'},
            {'X','X','O','O','X'},
            {'X','O','X','X','X'}
        };
        func(grid);

    }

    public static void func(char[][] board) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(board[i][j] != 'X'){
                    System.out.println("Found O at " + i + ", " + j);
                    if(dfs(board, i, j)){
                        System.out.println("Index " + i + ", " + j + " is fully surrounded!!");
                        mark(board, i, j, 'X');
                    }else{
                        System.out.println("Index " + i + ", " + j + " is not surrounded!!");
                        mark(board, i, j, 'O');
                    }
                }
            }
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i > board.length-1 || j > board[i].length-1){
            System.out.println("O at rim of board at " + i + ", " + j);
            return false;
        }
        if(board[i][j] != 'O'){
            System.out.println("O is surrounded at " + i + ", " + j);
            return true;
        }

        board[i][j] = 'S';
        if(!dfs(board, i-1, j)) return false;
        if(!dfs(board, i+1, j)) return false;
        if(!dfs(board, i, j-1)) return false;
        if(!dfs(board, i, j+1)) return false;

        return true;
    }

    private static void mark(char[][] board, int i, int j, char c){
        if(i < 0 || j < 0 || i > board.length-1 || j > board[i].length-1 || board[i][j] != 'S'){
            return;
        }

        System.out.printf("Set %d , %d to %s\n", i,j,c);
        board[i][j] = c;
        mark(board, i-1, j, c);
        mark(board, i+1, j, c);
        mark(board, i, j-1, c);
        mark(board, i, j+1, c);
    }
}
