import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an integer array nums, return the length 
// of the longest strictly increasing subsequence.

// A subsequence is a sequence that can be derived from an 
// array by deleting some or no elements without changing the order 
// of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// Example 2:

// Input: nums = [0,1,0,3,2,3]
// Output: 4
// Example 3:

// Input: nums = [7,7,7,7,7,7,7]
// Output: 1


/*
    brute force:
    for each element in array
        
*/
class Solution{
    
    // t = O(n^2)
    static int solution(int[] input){
        int len = input.length;
        int max = 1;
        int[] result = new int[len];
        Arrays.fill(result,1);
        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if(input[i] < input[j])
                    result[i] = Math.max(result[i], result[j]+1);
            }
            if(result[i] > max)
                max = result[i];
        }
        return max;
    }


    static int solution2(int[] input){
        int len = input.length;
        List<Integer> result = new ArrayList<>();
        result.add(input[0]);
        for (int i = 0; i < len; i++) {
            int target = input[i];
            int a = bin_Search(result, target);
            if(a == -1) // input[i] > max in result
                result.add(input[i]);
            else
                result.set(a, input[i]);
        }
        return result.size();
    }
    static int bin_Search(List<Integer> result, int target){
        int ans = Integer.MAX_VALUE;
        int mid;
        int left = 0;
        int right = result.size()-1;
        while(left <= right){
            mid = (left+right)/2;
            if(result.get(mid) >= target){
                ans = Math.min(mid,ans);
                right = mid - 1;
            }
            else left = mid + 1;
        }
        if(ans != Integer.MAX_VALUE)
            return ans;
        return -1;
    }
    public static void main(String[] args) {
        int[] input = {10,9,2,5,3,7,101,18};   
        int[] input2 = {0,1,0,3,2,3};   
        int[] input3 = {7,7,7,7,7,7,7};   
        int output = solution2(input2);
        System.out.println(output);
    }
}