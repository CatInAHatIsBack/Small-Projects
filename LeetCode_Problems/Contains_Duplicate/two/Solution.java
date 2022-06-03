package two;

import java.util.Map;
import java.util.HashMap;

// Given an integer array nums and an integer k, 
// return true if there are two distinct indices i and j in the array
// such that nums[i] == nums[j] and abs(i - j) <= k.
 

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1
// Output: true
// Example 3:

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

class Solution {

    /**
        itterate array
            store values in hashmap < int , i > 
            if allready in hashmap see if current i - value i
                if its less than k 
                    return ture;
        
        hasmap<int, int>
        for each element
            if(hasmap contains key)
                if( if i - value of key <= k)
                    return ture;
            put key in hashmap <key, i>
        return false
        
     */
    static boolean solution(int[] input, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if(map.containsKey(input[i])){
                if(i - map.get(input[i]) <= k) return true;
            }
            map.put(input[i],i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,1};
        boolean ans = solution(input, 3); 
        System.out.println(ans); 
    }    
}
