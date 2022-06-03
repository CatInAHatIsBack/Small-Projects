class Solution{
// Given a signed 32-bit integer x, return x with its digits reversed.
// If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21

/*
    take num % 10 to get last digit
    result += num 
    result * 10
    num /10
    check int max and int min val

    long result
    while (input != 0)
        result * 10
        result += num %= 10
        num /= 10
            
    if result < int min val | result > int max val - 1
        return 0

*/
    static int solution(int input) {
        
        long result = 0;
        while(input != 0){
            result *= 10;
            result += input % 10;
            input /= 10;
        }
        if( result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return 0;
        return (int)result;
    }
    public static void main(String[] args) {
        int input = 321;
        int output = solution(input);
        // System.out.println(output);
        System.out.println(23/11);
        
    }
}