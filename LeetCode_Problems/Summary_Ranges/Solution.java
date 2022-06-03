import java.util.ArrayList;
import java.util.List;

class solution{
// You are given a sorted unique integer array nums.

// A range [a,b] is the set of all integers from a to b (inclusive).

// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
// That is, each element of nums is covered by exactly one of the ranges, 
// and there is no integer x such that x is in one of the ranges but not in nums.

// Each range [a,b] in the list should be output as:

// "a->b" if a != b
// "a" if a == b
 

// Example 1:

// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"
// Example 2:

// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"

/*

    itterate array
        keep track of first
        if input[i] != input[i-1] +1                   
            put first and input[i-1] into string
            check if first and input[i-1] match
            first is input[i]
        
    list string anser

    int first = input[0]
    for(each element starting at 1)

        if input[i] != input[i-1] +1
            if first == input[i-1]
                string temp = first 
                anser.add temp
                first = input[i]
            else  
                string temp = first+"->"+input[i-1]

*/
    // does not deal with last element 

    // static List<String> solution(int[] input){
    //     List<String> result = new ArrayList<String>();
        
    //     int first = input[0];

    //     for (int i = 1; i < input.length; i++) {
    //         if(input[i] != input[i-1] + 1){ // not consecutive or last element
    //             if(first == input[i-1]){
    //                 result.add(String.valueOf(first));
    //             }
    //             else
    //                 result.add(String.valueOf(first)+"->"+String.valueOf(input[i-1]));
    //             first = input[i];
    //         }
    //     }        
    //     return result;
    // }

    /*

        check forward instead
        
        List<String> result = new ArrayList<String>();
        int first = input[0]
        for(each element)
            int current = input[i]

            if(input[i+1] != current+1 || i == input.length -1) // non contiguous
                if(first == current) only one element
                    result.add(String.valueOf(first));
                    first = input[i+1];
                else
                    result.add(String.valueOf(first)+"->"+String.valueOf(current));
                    first = input[i+1] 
            
        return result         
     */
    static List<String> solution(int[] input){

        List<String> result = new ArrayList<String>();
        if(input.length == 0)
            return result;
        Integer first = input[0];
        for (int i = 0; i < input.length; i++) {
            int current = input[i]; 
            
            if(i == input.length-1 || input[i+1] != current+1){
                if(first == current)
                    result.add(String.valueOf(first));
                else
                    result.add(String.valueOf(first)+"->"+String.valueOf(current));
                if(i != input.length-1)
                    first = input[i+1];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] input = {0,2,3,4,6,8,9};  
        int[] input2 = {0,1,2,4,5,7};
        List<String> ans = solution(input);
        for (String string : ans) {
            System.out.println(string);
            
        }
    }
}