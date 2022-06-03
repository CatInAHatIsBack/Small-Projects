class Solution{
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.


/**
 
    naive approach: 0(n^2) time 
        for every element 
            take value of every other element in arr - arr[i]    

    other: 0(n) time
        keep track of lowest number so far
        keep track of profit if selling now
        max profit
    
        loop though array  
            price if sold is current - lowest so far 
            check if price if sold is greater than max
        
        return max profit
    
 */

    static int solution(int[] input){
        if(input.length < 2) return 0;
        int lowestSoFar = input[0];
        int profitIfSoldNow = 0;
        int maxProfit = 0;

        for (int i = 0; i < input.length; i++) {
            if(lowestSoFar > input[i]) lowestSoFar = input[i];
            profitIfSoldNow = input[i] - lowestSoFar;
            if(maxProfit < profitIfSoldNow) maxProfit = profitIfSoldNow;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        int val = solution(input); 
        System.out.println(val);
    }
}
