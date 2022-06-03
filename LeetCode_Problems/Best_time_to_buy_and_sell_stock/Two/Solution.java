class Solution{

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Total profit is 4 + 3 = 7.
// Example 2:

// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Total profit is 4.
// Example 3:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


/**
    4 cases
        case 1: not holding stock and arr[i] < arr[i+1] 
        case 2: holding stock and arr[i] < arr[i+1] 

        case 3: not holding stock and arr[i] > arr[i+1] 
        case 4: holding stock and arr[i] > arr[i+1] 
                    current  next
                         v   v       
        case 1: buy     {2,  4}
        case 2: nothing {2,  4}
        case 3: nothing {4,  2}
        case 4: sell    {4,  2}
    
    int current
    int next

    boolean holding stock = false;

    for(each element )     
        if(i = arrlength-1)
            if( holding stock )
                sell stock
            return profit
        current = arr[i]
        next    = arr[i+1] 
        if(holding stock)
            if(current > next)         
                sell
        else
            if(current < next)
                buy 

    return 0;

 */
    static int solution(int[] input){

        int total = 0; 
        int current = 0;
        int next = 0;

        boolean holdingStock = false;
        
        for (int i = 0; i < input.length; i++) {
            if(i == input.length-1){
                if(holdingStock) total += input[i]; 
                return total;
            } 
            current = input[i];
            next    = input[i+1];
            if(holdingStock && current > next) {
                total += input[i];
                holdingStock = false;
            }
            else if(!holdingStock && current < next){
                total -= input[i];
                holdingStock = true;
            }
        }

        return 0;
    }
    public static void main(String[] args) {

        int[] input = {7,1,5,3,6,4};
        int val = solution(input);
        System.out.println(val);
        
    }
}