package three;

class Solution {
// Given an integer array nums, in which exactly two elements appear only once
// and all the other elements appear exactly twice.
// Find the two elements that appear only once. You can return the answer in any order.

// You must write an algorithm that runs in linear runtime complexity 
// and uses only constant extra space.


// Example 1:

// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.
// Example 2:

// Input: nums = [-1,0]
// Output: [-1,0]
// Example 3:

// Input: nums = [0,1]
// Output: [1,0]

/*
    ittterate though and xor all nums
    all nums that appear twice will cancel out
    this will give us an xored num with the 2 values
    to seperate the values find the first bit that differs

    then itterate the array again 
    and multiply the xored number by all nums in the array that
    has the same last bit
    this will give x    
    then you just xor the x and the val

    int num 
    for each element
        num ^= input[i]
    
    int diff
    for i< 32
        if(1<<i & num == 0)
            diff = i
            break
        
    int x
    for each element 
        if(1<<diff & input[i] == 0)
            x^input[i]
            
    return {x, x^num}
*/

    static int[] solution(int[] input){
        
        int num = 0;
        for (int i = 0; i < input.length; i++) {
            num ^= input[i]; 
        }

        int diff = 0;
        for (int i = 0; i < 32; i++) {// find last one didgit
            if((1<<i & num) != 0){
                diff = i;
                break;
            } 
        }  

        int x = 0;
        for (int i = 0; i < input.length; i++) {
            if((1<<diff & input[i]) == 0){
                x ^= input[i];
            }
        }
        int[] ans = {x, x^num};
        return ans; 
    }
    public static void main(String[] args) {
        int[] input = {1,2,1,3,2,5};
        int[] input2 = {0,1,3,5,7,3,1,7};
        int[] output = solution(input);
        // System.out.println(output[0] + " : " + output[1]);
        // System.out.println((1<<3 & 9) !=0);
        // System.out.println((1&6));
    }    
}
// 001
// 110
// 000