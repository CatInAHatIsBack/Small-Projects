import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution{
// Given an m x n 2D binary grid grid which represents a map of 
// '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting 
// adjacent lands horizontally or vertically. You may assume 
// all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.


    static int solution(int[][] input){
        int x = input.length;
        int y = input[0].length;
        Point dim = new Point(x,y);
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Point curr = new Point(i,j);
                if(input[i][j] == 1){
                    count++;
                    input[i][j] = -1;
                    bfs(curr, dim, input);
                }
            }
        }

        return count;
    } 
    static void bfs(Point p, Point dim, int[][] input){
        int[][] dir = {
            {0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = curr.x + dir[i][0];
                int b = curr.y + dir[i][1];
                if(a >= 0 && b >= 0 && a < dim.x && b < dim.y){
                    if(input[a][b] != -1){
                        if(input[a][b] == 1){
                            queue.add(new Point(a,b));
                        } 
                        input[a][b] = -1;
                    }
                } 
            }
        }
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    // char [][] 
    // public int numIslands(char[][] input) {
    //     int x = input.length;
    //     int y = input[0].length;
    //     Point dim = new Point(x,y);
    //     int count = 0;
    //     for (int i = 0; i < x; i++) {
    //         for (int j = 0; j < y; j++) {
    //             Point curr = new Point(i,j);
    //             if(input[i][j] == '1'){
    //                 count++;
    //                 input[i][j] = 'x';
    //                 bfs(curr, dim, input);
    //             }
    //         }
    //     }
    //     return count;
    // }
    // void bfs(Point p, Point dim, char[][] input){
    //     int[][] dir = {
    //         {0,1}, {0,-1}, {1,0}, {-1,0}};
    //     Queue<Point> queue = new LinkedList<>();
    //     queue.add(p);
    //     while(!queue.isEmpty()) {
    //         Point curr = queue.poll();
    //         for (int i = 0; i < 4; i++) {
    //             int a = curr.x + dir[i][0];
    //             int b = curr.y + dir[i][1];
    //             if(a >= 0 && b >= 0 && a < dim.x && b < dim.y){
    //                 if(input[a][b] != 'x'){
    //                     if(input[a][b] == '1'){
    //                         queue.add(new Point(a,b));
    //                     } 
    //                     input[a][b] = 'x';
    //                 }
    //             } 
    //         }
    //     }
    // }
    // class Point{
    //     int x;
    //     int y;
    //     Point(int x, int y){
    //         this.x = x;
    //         this.y = y;
    //     }
    // }
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}
        };    
        int output = solution(grid);
        System.out.println(output);
        
    }
}