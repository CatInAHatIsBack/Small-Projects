import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
// Given an integer array nums and an integer k, return the k most frequent elements. 
// You may return the answer in any order.


// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]


// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

// Constraints:

// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
 

// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] output = kFreq(nums,k);
        for (int i : output) {
            System.out.println(i);
        }
    }
    static int[] kFreq(int[] nums, int k){
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.putIfAbsent(nums[i], 0);
            count.put(nums[i], count.get(nums[i])+1);
        }
        List<Integer>[] res = new ArrayList[nums.length+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = new ArrayList<>(); 
        }
        for (Map.Entry<Integer,Integer> entry: count.entrySet()) {
            res[entry.getValue()].add(entry.getKey());
        }
        int index = nums.length;
        int[] fin = new int[k];
        int c = 0;
        while(k > 0){
            if(res[index].size() == 0){
                index--;
                continue;
            }
            fin[c] = res[index].get(res[index].size()-1);
            res[index].remove(res[index].size()-1);
            c++;
            k--;
        }
        return fin;
    }


}