/* 
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

*/
/**
    Above explanation is terrible. problem is basically just find the pivot and return num at that index
    
    input = [3,4,5,1,2]

    do binary search to find pivor and return num at index

    arr len 1 exeption
    arr unrotated exeption  
    start = 0
    end = input length

    left pointer = start
    right pointer = end
    int mid;
    while(left pointer <= right pointer)

        mid = (left pointer + right pointer) /2
    
        if(arr[mid] > arr[mid+1] )
            return arr[mid+1]
        if(arr[left pointer] < arr[mid])
            left pointer = mid+1
        else
            right pointer = mid-1
 */
class solution{
    static int findPivot(int[] arr){
        int len = arr.length;
        int Lpoint = 0; 
        int Rpoint = len-1;
        int mid;
        // len 1 exeption
        if(len == 1){ return arr[0]; }
        // unrotated exeption
        if(arr[Lpoint] < arr[Rpoint]){ return arr[0]; }

        while(Lpoint <= Rpoint){
            mid = (Lpoint + Rpoint) /2;
            if(arr[mid] > arr[mid+1]){ return arr[mid+1];}
            if(arr[Lpoint] <= arr[mid]){
                Lpoint = mid+1;
            }
            else{
                Rpoint = mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] input = {5,6,7,8,1,2,3,4};
        findPivot(input);
    }
}