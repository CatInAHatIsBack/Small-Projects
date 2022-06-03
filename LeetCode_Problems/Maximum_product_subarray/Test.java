// Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
// and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

// A subarray is a contiguous subsequence of the array.

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

class Test{
    /**
        input is an array of nums where some are negative
        goal is to find the longest subarray that will retur the larget product
        a negative value will make the product negative but 2 negative will make positive
        
        first thought:
            go through array and count number of negative
            if number of negative % 2 == 0 and and none of nums are 0
                multiply all nums in arr
            
        second: 
            go through each element in array and multiply by next number if not 0
            keep 2 tallies, one that stops at negative or 0,
            and another that stops just at 0 and updates when 2 negative hit but keeps going

        first draft:
        
        num1 = 1
        num2 = 1
        num1 bigges = num 1
        num2 biggest = num 2

        for each element in array
            if(arr[i] is not negative and not 0)
                num1 * arr[i]
            else 
                num1 biggest = biggest of num1 and num1 biggest
                num1 = 1
            
            if(arr[i] is not 0)
                if(arr[i] is negative and num2 is negative)
                    num2 biggest = biggest of num2*arr[i] and num2 biggest     
                num2 * arr[i]
            else
                num2 biggest = biggest of num2 and num2 biggest     



     */
                // num1 = 1
                // num2 = 32*-20
                // num3 = -8*-20
                // n1bi = 4
                // n2bi = 32
                // n3bi = 160
                // there will be exeption if ex {2,-2,4,-2, -20}
                /**
                 
                    if num1 = 0 set num1 = 1 
                    if num2 = 0 set num2 = 1 
                    keep a min value and a max value
                    itterate the array and multiply min value and max 
                    value by current input[i] and update min and max value

                    if num1 = 0 set num1 = 1 
                    if num2 = 0 set num2 = 1 
                    keep a min value and a max value
                    itterate the array and multiply min value and max 
                    value by current input[i] and update min and max value
                */                    


    static int solution(int[] input){
        /**
                   
        max value

        current min
        current max

        for(each element in array)
            get the min of (current min * input[i] and min of ( current max * input[i] and input[i]))
            get the max of (current max * input[i] and max of ( current min * input[i] and input[i]))
            max value is max of (current max and max value)

        return max value

        */
        if(input.length == 1){
            return input[0];
        }
        int maxVal = input[0];    

        int currentMin = 0;
        int currentMax = 0;

        for(int i = 0; i < input.length; i++){

            int tempMin = currentMin;        
            int tempMax = currentMax;        
            
            currentMin = getSmallest(tempMin*input[i], getSmallest(tempMax * input[i], input[i]));
            currentMax = getBiggest(tempMax*input[i], getBiggest(tempMin * input[i], input[i]));

            maxVal = getBiggest(maxVal, currentMax);
        }
        return maxVal;
    }
    static int getSmallest(int a, int b){
        if(a < b)   return a;
        else        return b;
    }
    static int getBiggest(int a, int b){
        if(a > b)   return a;
        else        return b;
    }
    public static void main(String[] args) {
        int[] input = {2,3,-2,4}; 
        int ans = solution(input);
        System.out.println(ans);
    }
}