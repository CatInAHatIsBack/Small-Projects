class Solution{
// Given an integer n, return an array ans of length n + 1 
// such that for each i (0 <= i <= n), 
// ans[i] is the number of 1's in the binary representation of i.
 

// Example 1:

// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// Example 2:

// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101
/*
    int[] result = new array[input.length +1]
    for each input
        int num = 0
        for(j < 32)
            if(1<<j & i != 0)
                num++
        result[i] = num;

*/
    static int[] solution(int input){
        int[] result = new int[input+1];
        for (int i = 0; i <= input; i++) {
            int num = 0;
            for (int j = 0; j < 32; j++) {
                if((1<<j & i) !=0){
                    num++;      
                } 
            }
            result[i] = num;
        }
        return result;
    }
    public static void main(String[] args) {
        int input = 5;        
        int[] result = solution(input);
        for (int i : result) {
            System.out.println(i); 
        }
    }
}