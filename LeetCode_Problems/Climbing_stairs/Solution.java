import java.util.HashMap;
import java.util.Map;

class Solution{
// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. 
// In how many distinct ways can you climb to the top?
 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step


    // cant handle big numbers

    // static int solution(int input){
    //     if(input == 0) return 0;
    //     Map<Integer,Integer> map = new HashMap<>();
        
    //     int y = input % 2;
    //     int x = input / 2;
    //     int total = 0;

    //     while(y < input){
    //         if(x == 0 || y == 0){
    //             total++;
    //         }
    //         else{
    //         int a = x+y;
    //         map = factorial(map, a); 
    //         map = factorial(map, x);
    //         map = factorial(map, y);
    //         int b = map.get(x);
    //         int c = map.get(y);
    //         int dividend = map.get(a);
    //         int divisor= b*c;
    //         int quotient = dividend/divisor;
    //         total += quotient;
    //         }
    //         x--;
    //         y += 2;

    //     }
    //     total++;

    //     return total;        
    // }
    // static Map<Integer,Integer> factorial(Map<Integer,Integer> map, int input){
    //     if(input == 0) return map;
    //     if(map.containsKey(input)) return map;
    //     int total = 1;
    //     int curr = 1;
    //     while(curr <= input){
    //         if(map.containsKey(input)){
    //             // get value and 
    //             total *= map.get(input);
    //         } 
    //         else{
    //             total *= curr;
    //             map.put(curr,total);
    //         }
    //         curr++;
    //     }
    //     return map;
    // }
    static int solution(int input){

        int one = 1;
        int two = 0;
        int curr = 0;
        for (int i = 0; i < input; i++) {
            curr = one+two; 
            two = one;
            one = curr;
        }   
        return curr;
    }
    public static void main(String[] args) {
        int input = 7;        
        int output = solution(input);
        System.out.println(output);
    }
}