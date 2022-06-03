import java.util.Arrays;

class Solution{
// There is a robot on an m x n grid. The robot is initially 
// located at the top-left corner (i.e., grid[0][0]). 
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
// The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that 
// the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

// Example 1:


// Input: m = 3, n = 7
// Output: 28
// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down

    
    static int solution2(int m, int n){
        int total = m+n-2;
        double ans = 1;
        int smallest = Math.min(m, n);
        for (int i = 1; i <= smallest-1; i++) {
            ans *= ((double)total+1 - i)/i;
        }
        ans+= 0.000001;
        return (int)ans;
    }
    static int solution(int m, int n){
        int biggest = Math.max(m, n);
        int smallest = Math.min(m, n);
        int[] row = new int[smallest];
        Arrays.fill(row,1);
        for (int i = 1; i < biggest; i++) {
            int[] temp = new int[smallest];
            Arrays.fill(temp,1);
            for (int j = 1; j < smallest; j++) {
                temp[j] = row[j] + temp[j-1]; 
            } 
            row = temp;
        }
        return row[smallest-1];
    }
    public static void main(String[] args) {
        int m = 9; 
        int n = 8;
        int output = solution2(m,n);
        System.out.println(output);
        
    }
}