class Solution{
// You are given an integer array height of length n. 
// There are n vertical lines drawn such that 
// the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, 
// such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

// Example 1:


// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
// In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1

/**
    goal is to find the numbers with the biggest area
    where 
        x is j - i
        y is min(input[i] && input[j]) 
    and area is x*y

    naive solution: O(n^2) 
        for every element
            check area with all other elements
            check if current area is greater than max

    {1,10,5,6,9}
    may solution: O(n)? 
        have 2 pointers
            one at start
            one at end
        get the area of current and update max
        check shortest line
            itterate until you find a larger value
            get area with new value 
            update max
            repeat

    int i = 0
    int j = length - 1
    int max
    while(i != j)
        int x = j - i
        int y = min (input[j], input[y])
        int area = x*y
        if( area > max ) max = area
        if(input[j] > input[i])
            i++
        else
            j++
    return max
 */
    static int solution(int[] input){

        int len = input.length;
        int i = 0;
        int j = len - 1; 
        int max = 0;
        while(i < j){
            int x = j - i;
            int y = getMin(input[i], input[j]);
            int area = x * y;
            if(area > max) max = area;
            if(input[j] > input[i]) i++;
            else j--;
        }
        return max;
    } 
    static int getMin(int a, int b){
        return (a > b) ? b : a;
    }
    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        int maxArea = solution(input);
        System.out.println(maxArea);
        System.out.println();
    }
}