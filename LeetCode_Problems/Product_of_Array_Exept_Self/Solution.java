import java.util.Arrays;

class Solution{
    
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:
            //    1  2  6  4
            //    1  24 12 4
            //    24 12 8  6 
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

/**
  
    naive solution without using the div operator: O(n^2)
        for every int in arr
            multiply all that are not arr[i]
            then put into new array
    
     
    O(n) solution: 
        multiply all elements with elements before and after

    int[] result = new int[input.length]
    Arrays.fill(result,1)

    use 2 pointers 
    int forward
    int backward

    for(arr length)
        multiply result[i] with forward
        forward * input[i]

        multiply result[input.length - 1 - i] with backwards 
        backward * input[input.lenth - 1 - i]
    
    return reuslt
        
        


 */
    static int[] solution(int[] input){

        int len = input.length;

        int[] result = new int[len];
        Arrays.fill(result, 1); 

        int forward = 1;        
        int backward = 1;

        for (int i = 0; i < len; i++) {

            result[i] *= forward; 
            forward *= input[i];
        
            result[len - 1 - i] *= backward;
            backward *= input[len - 1 - i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {-1,1,0,-3,3}; 
        int[] ans = solution(input);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]); 
        }
        System.out.println();
    }
}