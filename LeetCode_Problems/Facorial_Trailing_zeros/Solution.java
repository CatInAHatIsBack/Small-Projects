class Solution{
// Given an integer n, return the number of trailing zeroes in n!.

// Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 

// Example 1:

// Input: n = 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.
// Example 2:

// Input: n = 5
// Output: 1
// Explanation: 5! = 120, one trailing zero.
// Example 3:

// Input: n = 0
// Output: 0

/*
    find biggest power of 5 less than number
    divide number by each power of 5
    add

    int power = 1 
    while (5^power < n)
        power++

    int total
    for (i < power)
        total += n/5^i
        
*/
    static int solution(int input){
        
        int power = 1;
        while(Math.pow(5, power) < input)
            power++;

        int total = 0;
        for (int i = 1; i <= power; i++) {
            total += input/(Math.pow(5, i));
        }
        return total;
    }
    public static void main(String[] args) {
        int input = 25;     
        int output = solution(input);
        System.out.println(output);
        System.out.println(Math.pow(5,0));

    }
}