class Solution{
// You are given an integer array nums. You are initially positioned 
// at the array's first index, and each element in the array represents 
// your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. 
// Its maximum jump length is 0, which makes it impossible to reach the last index.
    static boolean solution2(int[] input){
        int len = input.length;
        int goal = len -1;
        for (int i = goal; i >= 0; i--) {
            if(i + input[i] >= goal)
                goal = i;    
        }
        return goal == 0;
    } 
    static boolean solution(int[] input){
        int len = input.length;
        boolean[] res = new boolean[len];
        if(len > 1 && input[0] == 0) return false;
        res[0] = true;
        for (int i = 0; i < len-1; i++) {
            if(res[i]){
                if(i+input[i] < len){
                
                    for (int j = 1; j <= input[i]; j++) {
                        res[i+j] = true;
                    }
                }
                else
                    return true;
            }
        }
        return res[len-1];
    }
    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        int[] input2 = {3,2,1,0,4};
        boolean output = solution(input2);
        System.out.println(output);
    }
}