import java.util.Arrays;

class Solution{
// You are given an integer array coins representing coins of different 
// denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

    static int solution(int[] input, int target){

        if(target == 0) return 0;
        int[] dp = new int[target+1];
        Arrays.fill(dp, target+1);
        dp[0] = 0;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < input.length; j++) {
                int x = i - input[j]; 
                if(x >= 0)
                    dp[i] = Math.min(dp[i], dp[x]+1);
            }
        }
        if(dp[target] == target+1) return -1;
        return dp[target];
    }
    public static void main(String[] args) {
        int[] input = {1,2,5};
        int target = 11; 
        int output = solution(input, target);
        System.out.println(output);
    }
}