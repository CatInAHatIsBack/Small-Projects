public class Solution {
// Write a function that takes an unsigned integer and returns 
// the number of '1' bits it has (also known as the Hamming weight).

// Note:

// Note that in some languages, such as Java, there is no unsigned integer type. 
// In this case, the input will be given as a signed integer type. It should not affect your implementation, 
// as the integer's internal binary representation is the same, whether it is signed or unsigned.
// In Java, the compiler represents the signed integers using 2's complement notation. 
// Therefore, in Example 3, the input represents the signed integer. -3.
 

// Example 1:

// Input: n = 00000000000000000000000000001011
// Output: 3
// Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
// Example 2:

// Input: n = 00000000000000000000000010000000
// Output: 1
// Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
// Example 3:

// Input: n = 11111111111111111111111111111101
// Output: 31
// Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

/*
    goal is to return num of 1 the bin representation of the num contains
    can use bitmanip to check all bits


    int total = 0;
    for(i < 32)
        if(1<<i & input != 0) // checks if 1 shifted i places & input is 1 
            total++;
    return total;

 */
    static int solution(int input){
        int total = 0;
        for (int i = 0; i < 32; i++) {
            if((1<<i & input) != 0)
                total++;
        }
        return total;
    }

    public static void main(String[] args) {
        int input = 11;       
        int sol = solution(input);
        System.out.println(sol);
    }     
}
