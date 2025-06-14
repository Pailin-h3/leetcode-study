package Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiralMetrix {
    public static void main(String[] args) {
        int[][] metrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        func(metrix);
    }
    
    public static List<Integer> func(int[][] matrix) {
        List<Integer> numList = new ArrayList<>();
        Map<String, Integer> currentSpot = new HashMap<>();
        currentSpot.put("h", 0);
        currentSpot.put("v", 0);

        int moveRound = 0;
        while (matrix[currentSpot.get("v")][currentSpot.get("h")] != 888) {
            System.out.println(currentSpot);
            numList.add(matrix[currentSpot.get("v")][currentSpot.get("h")]);
            matrix[currentSpot.get("v")][currentSpot.get("h")] = 888;

            int moveDirection = moveRound%4;

            if(moveDirection == 0 && currentSpot.get("h")+1 < matrix[currentSpot.get("v")].length && matrix[currentSpot.get("v")][currentSpot.get("h")+1] != 888){
                System.out.println("MOVE LEFT");
                moveLeft(currentSpot);
            }else if(moveDirection == 2 && currentSpot.get("h") > 0 && matrix[currentSpot.get("v")][currentSpot.get("h")-1] != 888){
                System.out.println("MOVE RIGHT");
                moveRight(currentSpot);
            }else if(moveDirection == 1 && currentSpot.get("v")+1 < matrix.length && matrix[currentSpot.get("v")+1][currentSpot.get("h")] != 888){
                System.out.println("MOVE DOWN");
                moveDown(currentSpot);
            }else if(moveDirection == 3 && currentSpot.get("v") > 0 && matrix[currentSpot.get("v")-1][currentSpot.get("h")] != 888){
                System.out.println("MOVE UP");
                moveUp(currentSpot);
            }else{
                moveRound++;
                moveDirection = moveRound%4;
                System.out.println("change direction to " + moveDirection);
                if(moveDirection == 0 && currentSpot.get("h")+1 < matrix[currentSpot.get("v")].length && matrix[currentSpot.get("v")][currentSpot.get("h")+1] != 888){
                    System.out.println("MOVE LEFT");
                    moveLeft(currentSpot);
                }else if(moveDirection == 2 && currentSpot.get("h") > 0 && matrix[currentSpot.get("v")][currentSpot.get("h")-1] != 888){
                    System.out.println("MOVE RIGHT");
                    moveRight(currentSpot);
                }else if(moveDirection == 1 && currentSpot.get("v")+1 < matrix.length && matrix[currentSpot.get("v")+1][currentSpot.get("h")] != 888){
                    System.out.println("MOVE DOWN");
                    moveDown(currentSpot);
                }else if(moveDirection == 3 && currentSpot.get("v") > 0 && matrix[currentSpot.get("v")-1][currentSpot.get("h")] != 888){
                    System.out.println("MOVE UP");
                    moveUp(currentSpot);
                }
            }
        }

        System.out.println(numList);
        return numList;
    }

    private static Map<String, Integer> moveLeft(Map<String, Integer> currentSpot){
        currentSpot.put("h", currentSpot.get("h") +1);
        return currentSpot;
    }

    private static Map<String, Integer> moveRight(Map<String, Integer> currentSpot){
        currentSpot.put("h", currentSpot.get("h") -1);
        return currentSpot;
    }

    private static Map<String, Integer> moveUp(Map<String, Integer> currentSpot){
        currentSpot.put("v", currentSpot.get("v") -1);
        return currentSpot;
    }

    private static Map<String, Integer> moveDown(Map<String, Integer> currentSpot){
        currentSpot.put("v", currentSpot.get("v") +1);
        return currentSpot;
    }

    public static List<Integer> func2(int[][] matrix) {
        List<Integer> numList = new ArrayList<>();
        int v = 0;
        int h = 0;

        int moveRound = 0;
        while (matrix[v][h] != 888) {
            numList.add(matrix[v][h]);
            matrix[v][h] = 888;

            int moveDirection = moveRound%4;

            if(moveDirection == 0 && h+1 < matrix[v].length && matrix[v][h+1] != 888){
                h++;
            }else if(moveDirection == 2 && h > 0 && matrix[v][h-1] != 888){
                h--;
            }else if(moveDirection == 1 && v+1 < matrix.length && matrix[v+1][h] != 888){
                v++;
            }else if(moveDirection == 3 && v > 0 && matrix[v-1][h] != 888){
                v--;
            }else{
                moveRound++;
                moveDirection = moveRound%4;
                if(moveDirection == 0 && h+1 < matrix[v].length && matrix[v][h+1] != 888){
                    h++;
                }else if(moveDirection == 2 && h > 0 && matrix[v][h-1] != 888){
                    h--;
                }else if(moveDirection == 1 && v+1 < matrix.length && matrix[v+1][h] != 888){
                    v++;
                }else if(moveDirection == 3 && v > 0 && matrix[v-1][h] != 888){
                    v--;
                }
            }
        }

        System.out.println(numList);
        return numList;
    }
}