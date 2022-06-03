package one;
import java.util.Map;
import java.util.HashMap;

class Solution{
// Given an integer array nums, 
// return true if any value appears at least twice in the array, 
// and return false if every element is distinct.
 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: true
// Example 2:

// Input: nums = [1,2,3,4]
// Output: false
// Example 3:

// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

/**
    itterate array
        store values in hashmap
 */
    static boolean checkDuplicate(int[] input){
        Map<Integer,Boolean> key = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if(key.containsKey(input[i])) return true;
            key.put(input[i], true);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] input = {1,1,1,3,3,4,3,2,4,2};
        boolean containsDuplicate = checkDuplicate(input);
        System.out.println(containsDuplicate);
    }
}