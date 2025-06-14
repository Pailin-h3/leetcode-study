package GraphBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakesNLadders {
    public static void main(String[] args) {
        int[][] grid = {
            {-1,-1,-1},
            {-1,9,8},
            {-1,8,9},
        };

        leetCodeSolution(grid);

        // func(grid);

    }

    public static int func(int[][] board) {
        Integer[] boardArr = converToBoardArr(board);
        Integer result = bfs(boardArr);

        System.out.println(result);

        return 0;
    }

    private static Integer[] converToBoardArr(int[][] board){
        Integer[] boardArr = new Integer[board.length * board.length];

        int curr = 0;
        boolean reversed = false;
        for(int i = board.length-1 ; i >=0 ; i--){
            if(reversed){
                for(int j = board.length-1 ; j >=0 ; j--){
                    boardArr[curr] = board[i][j];
                    System.out.printf("%d[%d]  ", curr, boardArr[curr]);
                    curr++;
                }
            }else{
                for(int j = 0 ; j < board.length ; j++){
                    boardArr[curr] = board[i][j];
                    System.out.printf("%d[%d]  ", curr, boardArr[curr]);
                    curr++;
                }
            }
            System.out.println();

            reversed = !reversed;
        }

        return boardArr;
    }

    private static Integer bfs(Integer[] boardArr){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean[] visited = new boolean[boardArr.length];
        for(int i = 0 ; i < visited.length ; i++){
            visited[i] = false;
        }
        visited[0] = true;

        Integer[] prev = new Integer[boardArr.length];

        while(!queue.isEmpty()){
            Integer curr = queue.remove();
            if(boardArr[curr] != -1){
                System.out.println("Jump from " + curr + " to " + (boardArr[curr] - 1));

                if(!visited[boardArr[curr]-1]){
                    queue.add(boardArr[curr]-1);
                    visited[boardArr[curr]-1] = true;
                    prev[boardArr[curr]-1] = curr;
                    System.out.println(Arrays.toString(prev));
                    System.out.println(Arrays.toString(boardArr));
                }
                curr = boardArr[curr] - 1;
            }

            for(int i = 1 ; i <= 6 ; i++){
                if(curr + i < boardArr.length){
                    if(!visited[curr+i]){
                        queue.add(curr+i);
                        visited[curr+i] = true;
                        prev[curr+i] = curr;
                        System.out.println(Arrays.toString(prev));
                        System.out.println(Arrays.toString(boardArr));
                    }
                }
            }
        }

        return reconstructPath(0, boardArr.length-1, prev, boardArr);
    }

    private static Integer reconstructPath(int start, int end, Integer[] prev, Integer[] boardArr){
        System.out.println(Arrays.toString(prev));
        List<Integer> path = new ArrayList<>();
        int jumpNum = 0;

        for(Integer at = end ; at != null ; at = prev[at]){
            if(boardArr[at] != -1){
                jumpNum++;
            }
            path.add(at);
        }
        
        Collections.reverse(path);
        System.out.println(Arrays.toString(path.toArray()));
        System.out.println(jumpNum);
        
        if(path.get(0) == start){
            return path.size() - 1 - jumpNum;
        }

        return 0;
    }

    private static int leetCodeSolution(int[][] board){
        int n = board.length;
        int lbl = 1;

        int[][] cells = new int[(n*n)+1][2];
        int[] columns = new int[n];
        for(int i = 0 ; i<n ; i++){
            columns[i] = i;
        }

        for(int row = n-1 ; row >= 0 ; row--){
            for(int column : columns){
                int[] cell = {row, column};
                cells[lbl++] = cell;
            }

            Collections.reverse(Arrays.asList(columns));
        }

        int[] dist = new int[(n*n)+1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for(int next = curr+1 ; next <= curr + 6 && next <= n*n ; next++){
                int[] cell = cells[next];
                int row = cell[0];
                int column = cell[1];

                int destination = board[row][column] != -1 ? board[row][column] : next;

                if(dist[destination] == -1){
                    dist[destination] = dist[curr] +1;
                    queue.add(destination);
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        return dist[n*n];
    }
}
