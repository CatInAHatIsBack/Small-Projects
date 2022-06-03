class Solution {
// Given an integer array nums where every element 
// appears three times except for one, which appears exactly once. 
// Find the single element and return it.

// You must implement a solution with a 
// linear runtime complexity and use only constant extra space.


// Example 1:

// Input: nums = [2,2,3,2]
// Output: 3
// Example 2:

// Input: nums = [0,1,0,1,0,1,99]
// Output: 99

/*
    fist thought:
        itterate array and xor nums
        if xor is less than num that means its a duplicate
        so keep second xor that does not xor when it goes down

    num1
    num2 
    for(every element)
        if(input[i] > 0)
            if(num1 xor input[i] < num1) // positive duplicate
                dont xor num2
            else                         // not duplicate
                xor num2
        if(input[i] < 0)
            if(num1 xor input[i] > num1) // negative duplicate    
                dont xor num2 
            else                         // negative not duplicate
                xor num2
        xor num1
            
    

    num1 
    num2 
    for(every element)
        if(input[i] > 0 && num1 xor input[i] > num1 )
            xor num2
        if(input[i] < 0 && num1 xor input[i] < num1 )
            xor num2
        xor num1;
*/
    // mixing positives and negatives does not work to well

    // static void solution(int[] input){
    //     int num1 = 0;
    //     int num2 = 0;
        
    //     for (int i = 0; i < input.length; i++) {
    //         int a = num1 ^ input[i];
    //         if(input[i] > 0 && a > num1) 
    //             num2 ^= input[i];
    //         if(input[i] < 0 && a < num1) 
    //             num2 ^= input[i];
    //         num1 = a;
    //         System.out.println("int a: " + a);
    //         System.out.println("num1: " + num1 + " num2: " + num2 + "    input[" + i + "]: " + input[i]);
    //         System.out.println();
    //     }

    //     System.out.println(num2);
    // }

    /*
        keep seperate count for negative and positive
        for
            if(input[i] > 0)
                if(aP > num1P) 
                    num2P ^= input[i];
                num1P = aP

            if(input[i] < 0)
                if(aN < num1N) 
                    num2N ^= input[i];
                num1N = aN

        if num2P == 0 // all positives cancel out    
            num2N

    */
    // not working since its xor is just add and does not carry
    // static int solution(int[] input){
    //     int num1P = 0;
    //     int num2P = 0;
        
    //     int num1N = 0;
    //     int num2N = 0;

    //     for (int i = 0; i < input.length; i++) {
    //         int aP = num1P ^ input[i];
    //         int aN = num1N ^ (input[i]*-1);
            
    //         if(input[i] > 0){
    //             if(aP > num1P){
    //                 num2P ^= input[i];
    //             }
    //             num1P = aP;
    //         }
    //         else if(input[i] < 0){
    //             if(aN > num1N){
    //                 num2N ^= input[i];
    //             }
    //             num1N = aN;
    //         }
    //         // System.out.println("num1P: "+num1P +"   num2P: "+num2P);
    //         // System.out.println("num1N: "+num1N +"   num2N: "+num2N);

    //         // System.out.println();
    //     }
    //     if(num2P == 0) // all positives cancel
    //         return num2N;
    //         // System.out.println(num2N);
    //     else
    //         return num2P;
    //         // System.out.println(num2P);
    // }
    static int solution(int[] input){
        int num1 = 0;
        int num2 = 0;     
        for (int i = 0; i < input.length; i++) {
            num1 = num1 ^ input[i] & (~num2);
            num2 = num2 ^ input[i] & (~num1);
            System.out.println(num1 + " : " + num2);
        }
        
        return num1;
    }
 
    public static void main(String[] args) {
        int[] input = {2,2,3,2};  
        int ans = solution(input);
        // System.out.println(ans);
    } 
}
