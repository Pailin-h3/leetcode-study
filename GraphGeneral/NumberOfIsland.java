package GraphGeneral;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int result = func(grid);

        System.out.println(result);
    }

    public static int func(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    numIslands++;
                    markIsland(grid,i,j);
                }
            }
        }
        
        return numIslands;
    }

    private static void markIsland(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i+1 >= grid.length || j+1 >= grid[i].length || grid[i][j] != '1'){
            return;
        }

        System.out.printf("Set %d , %d to 0\n", i,j);
        grid[i][j] = 0;
        markIsland(grid, i-1, j);
        markIsland(grid, i+1, j);
        markIsland(grid, i, j-1);
        markIsland(grid, i, j+1);
    }
}
