import java.util.Arrays;

class Solution{
// Given an array of distinct integers nums and a target integer target, 
// return the number of possible combinations that add up to target.

// The test cases are generated so that the answer can fit in a 32-bit integer.
 

// Example 1:

// Input: nums = [1,2,3], target = 4
// Output: 7
// Explanation:
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.
// Example 2:

// Input: nums = [9], target = 3
// Output: 0
    static int solution(int[] coins, int target){

        int[] result = new int[target+1];
        Arrays.fill(result,0);
        result[target] = 1;
        for (int i = target; i >= 0; i--) {
            for (int c : coins) {
                int change = i - c;
                if(change >= 0)
                    result[change] += result[i];
            }
        }
        return result[0];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};    
        int[] coins2 = {1,3,6,9};    
        int target = 0;
        int output = solution(coins2, target);
        System.out.println(output);
    }
    
}
