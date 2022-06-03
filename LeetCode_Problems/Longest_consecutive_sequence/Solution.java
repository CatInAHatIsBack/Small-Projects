import java.util.HashSet;
import java.util.Set;

class Solution{
// Given an unsorted array of integers nums, 
// return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.


// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements 
// sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109

    static int solution(int[] input){
        int max = 0;
        Set<Integer> map = new HashSet<>();
        for (int i : input) {
            map.add(i); 
        }
        for (int i: input) {
            int count = 1;
            if(map.contains(i)){
                int front = i+1;
                int back = i-1;
                while(map.contains(front)){
                    map.remove(front);
                    front++;
                    count++;
                }
                while(map.contains(back)){
                    map.remove(back);
                    back--;
                    count++;
                }
                
            } 
            max = Math.max(count, max);
        }
        return max; 
    }
    public static void main(String[] args) {
        int[] input = {0,3,7,2,5,8,4,6,0,1}; 
        int[] input2 = {100,4,200,1,3,2}; 
        int output = solution(input2);
        System.out.println(output);
    }
}