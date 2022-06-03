import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Stack;

class Solution{
// There is an m x n rectangular island that borders 
// both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean 
// touches the island's left and top edges, and the Atlantic Ocean 
// touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. 
// You are given an m x n integer matrix heights where heights[r][c] 
// represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow 
// to neighboring cells directly north, south, east, and west if the 
// neighboring cell's height is less than or equal to the current cell's height. 
// Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
// denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

 

// Example 1:


// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]


// Example 2:

// Input: heights = [[2,1],[1,2]]
// Output: [[0,0],[0,1],[1,0],[1,1]]
 

// Constraints:

// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 105
    static List<List<Integer>> solution(int[][] input){
        input = rotate(input);
        int x = input.length;
        int y = input[0].length;
        Point dim = new Point(x,y);
        BitSet pas = new BitSet(x*y);
        BitSet atl = new BitSet(x*y);

        BitSet visitedPas = new BitSet(x*y);
        BitSet visitedAtl = new BitSet(x*y);

        Stack<Point> p = new Stack<>(); 
        Stack<Point> a = new Stack<>(); 
    
        // init top and bot
        for (int i = 0; i < x; i++) {
            int top = i;
            int bot = x*(y-1)+i;
            Point currP = new Point(i, 0);
            Point currA = new Point(i, y-1);
            p.push(currP);
            a.push(currA);
            
            visitedPas.set(top);
            visitedAtl.set(bot);

            pas.set(top);
            atl.set(bot);
        }
        for (int i = 0; i < y; i++) {
            int left = x*i;
            int right = (x-1) + (x*i); 

            Point currP = new Point(0, i);
            Point currA = new Point(x-1, i);

            p.push(currP);
            a.push(currA);
            
            visitedPas.set(left);
            visitedAtl.set(right);

            pas.set(left);
            atl.set(right);
        }

        checker(pas, visitedPas, p, dim, input);
        checker(atl, visitedAtl, a, dim, input);

        pas.and(atl);

        List<Integer> results = new ArrayList<>(); 
        int curr = 0;
        while(curr < pas.length()){
            int temp = pas.nextSetBit(curr);
            results.add(temp);
            curr = temp+1;
        } 

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < results.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            int finX = (int)results.get(i) % x;
            int finY = (int)results.get(i) / x;
            temp.add(finY);
            temp.add(finX);
            result.add(temp);
        } 
        
        return result;
    }
    static int[][] rotate(int[][] input){
        
        int x = input[0].length;
        int y = input.length;
        int[][] output = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                output[i][j] = input[j][i]; 
            }
        }
        // for (int i = 0; i < y; i++) {
        //     for (int j = 0; j < x; j++) {
        //         System.out.print(output[i][j]);
        //     }
        //     System.out.println();
        // }
        
        return output;
    }
    static void checker(BitSet ocean, BitSet visited, Stack<Point> stack, Point dim, int[][] input){
        while(!stack.isEmpty()){
            Point curr = stack.pop();
            if(curr.y > 0 && checkVisit(curr.x, curr.y-1, visited, dim) && (input[curr.x][curr.y] <= input[curr.x][curr.y-1])) {// up
                stack.push(new Point(curr.x,curr.y-1));
                ocean.set(curr.x+((curr.y-1)* dim.x));
                visited.set(curr.x+((curr.y-1)*dim.x));
            }
            if(curr.y < dim.y-1 && checkVisit(curr.x, curr.y+1, visited, dim) && (input[curr.x][curr.y] <= input[curr.x][curr.y+1])) {// down
                stack.push(new Point(curr.x,curr.y+1));
                ocean.set(curr.x+((curr.y+1)* dim.x));
                visited.set(curr.x+((curr.y+1)*dim.x));
            }
            if(curr.x > 0  && checkVisit(curr.x-1, curr.y, visited, dim) && (input[curr.x][curr.y] <= input[curr.x-1][curr.y])) {// left 
                stack.push(new Point(curr.x-1,curr.y));
                ocean.set((curr.x-1)+(curr.y* dim.x));
                visited.set(curr.x-1+(curr.y*dim.x));
            }
            if(curr.x < dim.x-1 && checkVisit(curr.x+1, curr.y, visited, dim) && (input[curr.x][curr.y] <= input[curr.x+1][curr.y])) {// right 
                stack.push(new Point(curr.x+1,curr.y));
                ocean.set((curr.x+1)+(curr.y* dim.x));
                visited.set(curr.x+1+(curr.y*dim.x));
            }
        }
    }
    static boolean checkVisit(int x, int y, BitSet visited, Point row){
        if(!visited.get(x+(y*row.x))){
            
            return true;
        }
        return false;
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[][] input = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}};  

        List<List<Integer>> output = solution(input);
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j));
            }
            System.out.println();
        }
        
    }
    
}
