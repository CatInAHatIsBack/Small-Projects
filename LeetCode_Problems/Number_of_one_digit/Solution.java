class Solution{

// Given an integer n, count the total number of digit 1 appearing 
// in all non-negative integers less than or equal to n.
 

// Example 1:

// Input: n = 13
// Output: 6
// Example 2:

// Input: n = 0
// Output: 0

/*
    naive solution:
        go though every element less than num see if %10
        is one for every num.

    
    excluding  
    1 to 10 - 1 
    1 to 100 - ones place 10 tens place 10 == 20
    1 to 1000 - ones place 10*10 tens place 10*10 100s place 100-199 so == 300

 */
    // bug with ones
    
    // static int solution(int input){
    //     int total = 0;
    //     int place = 0;
    //     int prev = 0;
    //     int used = 0;
    //     while(input > 0){
    //         int num = input % 10;
    //         input /= 10;

    //         if(num > 0){
    //             int x = (int) Math.pow(10, place -1);
    //             int y = (int) Math.pow(10, place);
    //             int pre = (num*x*place);
                  
    //             if(num < 2){
    //                 y /= 10;
    //                 y *= prev;
    //                 y++;
    //                 total += used;
    //             }
    //             total += pre+y;
    //         }
    //         used += num*(int)Math.pow(10, place);
    //         place++;
    //         prev = num;
    //     }
    //     return total;
    // }
    /*
        
        
    */
    static int solution(int input){
        int place = 0;
        int num = input;
        int total = 0;
        while(num > 0){
            int curr = num % 10;
            num /= 10;
            if(curr > 0){
                int x = (int) Math.pow(10, place -1);
                int y = (int) Math.pow(10, place);
                int pre = (curr*x*place);
                if(curr == 1){
                    total += input%(y);
                    y = 1;
                }
                total += pre+y;
            }
            place++;
        }
        return total;
    }
    public static void main(String[] args) {
        int input = 120034;        
        int output = solution(input);
        System.out.println(output);
        // System.out.println(456 %1);
    }
}