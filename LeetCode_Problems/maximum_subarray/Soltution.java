// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// A subarray is a contiguous part of an array.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23

class Soltuion{
    
    /**
        itterate each element in array
        if(count < 0) set count = 0;  
        count += input[i]
        max val is max of ( max val and count)

     */

    static int solution(int[] input){
        int maxVal = input[0];
        int current = 0;
        if(input.length == 1) return input[0];
        for (int i = 0; i < input.length; i++) {
            if(current < 0) current = 0;
            current += input[i];
            maxVal = Math.max(maxVal, current);
        }
        return maxVal;
    }
    
    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        int output = solution(input);
        System.out.println(output);
    }
}