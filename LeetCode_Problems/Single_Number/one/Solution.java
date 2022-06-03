package one;
class Solution{
// Given a non-empty array of integers nums, 
// every element appears twice except for one. Find that single one.

// You must implement a solution with a 
// linear runtime complexity and use only constant extra space.


// Example 1:

// Input: nums = [2,2,1]
// Output: 1
// Example 2:

// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:

// Input: nums = [1]
// Output: 1

/**
 
    not sure if it will work but 
        xor of 2 identical val is 0
        if i keep a number and xor all numbers in array
        it should return either the number or binary rep

 */

    static int solution(int[] input){
        int num = 0;
        for (int i = 0; i < input.length; i++) {
            num ^= input[i];
            // System.out.println("num: " + num + "    input[" + i + "]: " + input[i]);
        }
        return num;
    }
    public static void main(String[] args) {
    
        int[] input = {4,1,2,1,2};
        solution(input);
    }
}