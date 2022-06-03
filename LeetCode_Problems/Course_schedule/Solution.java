import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
// There are a total of numCourses courses you have to take, 
// labeled from 0 to numCourses - 1. You are given an array prerequisites 
// where prerequisites[i] = [ai, bi] indicates that you must take course bi 
// first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.


// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 
// you should also have finished course 1. So it is impossible.
 

// Constraints:

// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

    
    static boolean solution(int numC, int[][] pre){
        Map<Integer, List<Integer>> adj = getMap(pre); 
        
        boolean[] visited = new boolean[numC];
        boolean[] cleared = new boolean[numC];
        Arrays.fill(visited, false);
        Arrays.fill(cleared, false);

        for (int i = 0; i < numC; i++) {
            List<Integer> temp = adj.get(i);
            if(detectCycle(adj, i, visited, cleared)) return false;
        }
            
        return true;
    }
    static boolean detectCycle(Map<Integer,List<Integer>> adj, int i, boolean[] visited, boolean[] cleared){
        if(!cleared[i]){
            if(visited[i]) return true;
            visited[i] = true;
            if(adj.get(i) != null){
                for (Integer ints: adj.get(i)) {
                    boolean cyc = detectCycle(adj, ints, visited, cleared);
                    if(cyc) return true;
                }
            }
            cleared[i] = true;
        }
        return false;
    }
    static Map<Integer, List<Integer>> getMap(int[][] pre){

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            List<Integer> temp = new ArrayList<>();
            int a = pre[i][1];
            int b = pre[i][0];
            if(adj.containsKey(a))
                temp = adj.get(a);
            temp.add(b);
            adj.put(a,temp);
        }
        return adj;
    }
    public static void main(String[] args) {
        int numC = 2;
        int[][] pre = {{1,0},{0,1}};
        boolean output = solution(numC, pre);
        System.out.println(output);
    }
    
}
