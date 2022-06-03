class Solution{
// Given an array nums containing n distinct numbers in the range [0, n], 
// return the only number in the range that is missing from the array.
 

// Example 1:

// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 
// 2 is the missing number in the range since it does not appear in nums.
// Example 2:

// Input: nums = [0,1]
// Output: 2
// Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 
// 2 is the missing number in the range since it does not appear in nums.
// Example 3:

// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 
// 8 is the missing number in the range since it does not appear in nums.

    /*
        int result = 0;
        for(i = 1; i < arr length) 
            result ^= i
        for(for arrlength)
            result ^= arr[i]
        return result
    */
    static int solution(int[] input){
        int result = 0;
        int len = input.length;
        for (int i = 1; i < len+1; i++)
            result ^= i;
        for (int i = 0; i < len; i++)
            result ^= input[i];
        return result;
            
    }
    public static void main(String[] args) {
        int[] input = {9,6,4,2,3,5,7,0,1};
        int result = solution(input);
        System.out.println(result);
    }
}