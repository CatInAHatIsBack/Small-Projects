import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution{
    
// Given an integer array nums, 
// return all the triplets [nums[i], nums[j], nums[k]] 
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:

// Input: nums = []
// Output: []
// Example 3:

// Input: nums = [0]
// Output: []

/**
    naive solution: 
        add every element in array with all elements in array exept self
        then add all elements in array with ^
    Time complexity O(n^3)
    Space comlexity O(n^3)

    slighly better solution?: 
        for every element
            get 2 sum problem 
    
    2 sum problem is itterating the array and
        taking checking if HashMap contains current
        where current = goal - input[i]
    Time complexity:  0(n)
    space complexity  0(n)

    since we have to do this for every element in the array 
        for the 3 sum problem 
    Time complexity:  O(n^2)
    space complexity:  

    List<list<int> all triplets
    for(every element)
        int new total = 0 + input[i]
        List<int> currentlist 
        for(every element in array)
        hashmap<int,int> 
            if(j != i)
                check if hashmap contains input[j] 
                    if so add input[i], input[j], map.get(input[j])
                    add currentlist to all triplets
    return all triplets    


 */
    // unfinished & does not account for duplicates
    
    // static List<List<Integer>> solution(int[] input){

    //     List<ArrayList<Integer>> allTriplets = new ArrayList<ArrayList<Integer>>();

    //     for (int i = 0; i < input.length; i++) {
    //         int goalVal = input[i];     
    //         HashMap<Integer,Integer> twoSum = new HashMap<>();

    //         for (int j = 0; j < input.length; j++) {
    //             if(j != i) {
    //                 if(twoSum.containsKey(input[j])){
    //                     ArrayList<Integer> currentList = new ArrayList<>();
    //                     currentList.add(input[i]); 
    //                     currentList.add(input[j]); 
    //                     currentList.add(twoSum.get(input[j])); 
    //                     allTriplets.add(currentList);
    //                 }
    //                 twoSum.put(goalVal + input[j], input[j]);
    //             }
    //         }
    //     }

    //     return null;
    // }
    

    /**
        since this will run in O(n^2) time, 
        sorting it will not add time complexity.
        array can be sorted in O(n*log(n)) with arrays.sort

        that way we can use pointers instead to avoid duplicate triplets, 
        by checking if j == j-- or k == k++ and itterating j & k respectively 
        this needs to be done for as well

        sort input
        List<list<int> restults
        
        for( each input in arr)
            if(input[i] == input[i--])
                continue
            int goal = input[i]
            int j
            int k
            List<int> temp;
            while(j < k)
                int curr = goal + input[j] + input[k] 
                if(curr == 0)
                    temp.add(input[i])
                    temp.add(input[j])
                    temp.add(input[k])
                    retul.add(temp)   
                    while (input[j] == input[j--]) 
                        j++
                    while (input[k] == input[k++]) 
                        k--
                if(curr < 0) // curr to small so inc j
                    j++
                if(curr > 0) // curr to big so inc k
                    k--

     */
    static List<List<Integer>> solution(int[] input){
        Arrays.sort(input);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        int len = input.length;
        for (int i = 0; i < len; i++) {
            if(i > 0 && input[i] == input[i-1]) continue;

            int j = i + 1;
            int k = len - 1;
            
            while(j < k) {
                int curr = input[i] + input[j] + input[k];
                if(curr == 0){
                    List<Integer> temp = new ArrayList<>();
                    // add to list
                    temp.add(input[i]);
                    temp.add(input[j]);
                    temp.add(input[k]);
                    result.add(temp);
                    // increment to skip duplicates
                    while( j<k && input[j] == input[j+1]) j++;
                    while( j<k && input[k] == input[k-1]) k--;
                }
                if(curr < 0) j++; // inc j if to small
                // if(curr > 0) k--; // dinc k if to big
                else k--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] input = {0,0,0};           
        List<List<Integer>> output = solution(input);       
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + ","); 
            }
            System.out.println();
        }
    }
}