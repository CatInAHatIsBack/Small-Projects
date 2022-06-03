class Solution{
// Given two integers a and b, return the sum of the 
// two integers without using the operators + and -.

// Example 1:

// Input: a = 1, b = 2
// Output: 3
// Example 2:

// Input: a = 2, b = 3
// Output: 5

/**
    this is a bitwise problem
    1 = 01
    2 = 10
    
    or(^) operation adds but does not carry (xor)
    and(&) operation carries but does not add (xand)
    
    so 
    while(b!=0) // still remainder
        set temp = (a & b)<<1
        a = a ^ b
        b = temp
    return a

 */
    static int solution(int a, int b){
        while(b!=0){
            int temp = (a & b)<<1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int output = solution(a,b); 
        System.out.println(output);
    }
}