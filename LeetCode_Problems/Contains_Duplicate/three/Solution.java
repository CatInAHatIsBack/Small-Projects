package three;

import java.util.TreeSet;

public class Solution {
// Given an integer array nums and two integers k and t, 
// return true if there are two distinct indices i and j 
// in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.


// Example 1:

// Input: nums = [1,2,3,1], k = 3, t = 0
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1, t = 2
// Output: true
// Example 3:

// Input: nums = [1,5,9,1,5,9], k = 2, t = 3
// Output: false


/**
    have a window of max size k, not including input[i]
    get the biggest that is smaller or equal to input[i]
    get the smallest that is bigger or equal to input[i]
    add input[i] to treeset 
    if treeset length is greater than k
        remove input[i-k]

        
    smallest possible num is int.min_val
    biggest possible nim is int.max_val
    if num[i] = int.min_val and num[j] is int.max_val
        num[i] - num[j] will be 2*int.min_val
        so need to use long

    
    


    if(input lenght == 1)  
        return false
    
    treeset<long> tree = new treeset<>()
    for(each element)

        // treeset floor(x) gives biggest value less than or equal to x
        long floor = tree.floor(input[i])       
        if(floor != null && input[i] - floor <= t)
            return true
            
        // treeset cieling(x) gives smallest value greater than or equal to x
        long cieling = tree.ceiling(input[i])
        if(cieling != null && input[i] - cieling <= t)
            return true
        
        // none of the checks have turned out true so far
        // we know that the window makes makes it so abs(i-j) <= k
        // and the floor and cieling func check the window for a value 
            // that is less than t away from input[i]
                // input[i] - floor/cieling <=t
        // this means that there is no value in current window that
            // makes abs(nums[i] - nums[j]) <= t && abs(i-j) <= k
        // so add input[i] to window
            // if window size is greater than k
                // remove input[i-k]

        treeset add input[i]
        if treeset.size > k
            remove input[i-k]
    
        
    

 */
    static boolean solution(int[] input, int k, int t){

        if(input.length < 2) return false;
        
        TreeSet<Long> treeset = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {

            Long floor = treeset.floor((long) input[i]);
            if(floor != null && input[i] - floor <= t) 
                return true;

            Long ceiling = treeset.ceiling((long) input[i]);
            if(ceiling != null && ceiling - input[i] <= t) 
                return true;

            // no checks passed 

            treeset.add((long)input[i]);
            if(treeset.size() > k)
                treeset.remove((long)input[i-k]);
        }
        return false; 
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,1};
        int[] input2 = {1,5,9,1,5,9};
        boolean ans = solution(input2, 2, 3);
        System.out.println(ans);
    } 
}
