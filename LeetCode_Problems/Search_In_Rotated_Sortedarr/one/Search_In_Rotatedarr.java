package one;

/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an 
unknown pivot index k (1 <= k < nums.length) such that the resulting array is 
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, 
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

*/

/**
    
    input unsorted: [4,5,6,7,0,1,2] 
    input sorted: [0,1,2,4,5,6,7]
    
    arr is rotated around pivot k
    check first and last element, bc of distinct values 
    if arr[0] <= arr[len-1] the arr is sorted 

    use binary search to find the pivot
    check which side of the arr will contain the number
    use binary search to find the target
    return index of target

    solution(int[] arr, int target){
        int start = 0;
        int end = arr.len -1
        
        int pivot = find pivot(arr)
        if pivot is -1 return -1

        if arr[pivot] == target 
            return pivot
        if arr[start] < target
            start = 0 
            end = pivot -1 
        else 
            start = pivot
            end = arr.len -1
        
        return bin search(arr,start,end,target)
    }
    bin search(int[] arr, int start, int end, int target){
        
        int Lpoint = start  
        int Rpoint = end
        int mid = Lpoint + Rpoint / 2

        while(Rpoint != Lpoint){
            if(arr[mid] == target)
                return mid 

        // 4,5,6,1,2,3
            if(arr[mid] < arr[target])
                Lpoint = mid+1 
            else
                Rpoint = mid-1

            mid = Lpoint + Rpoint /2              
        }
        return -1
    }
    find pivot(int[] arr){
        if arr[0] < arr[len-1]
            return -1
        int Lpoint = 0
        int Rpoint = arrlen-1
        int mid = Rpoint / 2

        while(Rpoint != Lpoint){
            if(arr[mid] > arr[mid+1] && Rpoint != Lpoint)
                return mid + 1
            if(arr[mid] < arr[mid-1]) 
                return mid
        // 4,5,6,1,2,3

            if(arr[start] < arr[mid])
                Lpoint = mid+1 
            else
                Rpoint = mid-1

            mid = Lpoint + Rpoint /2              
        }
        return -1
    }
 */
class Search_In_Rotatedarr{
    
    public static int search_Rotatedarr(int[] arr, int target){
        int len = arr.length;
        int start = 0;
        int end = len-1;
        if(len == 1){
            if(arr[0] == target){return 0;}
            else{ return -1;}
        }
        int pivot = find_Pivot(arr);
        System.out.println("pivot: "+pivot);

        if(arr[pivot] == target){ return pivot;}
        if(arr[start] < target){
            start = 0;
            end = pivot-1;
        }
        else{
            start = pivot;
            end = len-1;
        }
        int index = bin_Search(arr, start, end, target);
        System.out.println("index: "+ index);

        return index;
    }
    public static int bin_Search(int[] arr, int start, int end, int target){
        int Lpoint = start;
        int Rpoint = end;
        int mid = (Lpoint + Rpoint) / 2;
        if(arr[start] == target){
            return start;
        }
        if(arr[end]== target){
            return end;
        }
        while(Rpoint != Lpoint){

            if(arr[mid] == target){ return mid;}
            if(arr[mid] < target){
                Lpoint = mid+1;
            }
            else{
                Rpoint = mid -1;
            }
            mid = (Lpoint + Rpoint)/2;
        }
        
        return -1;

    }
    public static int find_Pivot(int[] arr){
        int len = arr.length;
        if (arr[0] < arr[len-1]){ return -1;}

        int start = 0;
        int end = len-1;

        int Lpoint = 0;
        int Rpoint = len-1;
        int mid = Rpoint / 2;

        while(Rpoint != Lpoint){
            if(arr[mid] > arr[mid+1])
                return mid + 1;
            if(arr[mid] < arr[mid-1]) 
                return mid;
        // 4,5,6,1,2,3
            if(arr[start] < arr[mid])
                Lpoint = mid+1;
            else
                Rpoint = mid-1;
            System.out.println(arr[mid]);
            System.out.println("L: "+Lpoint + "  R: "+ Rpoint);

            mid = (Lpoint + Rpoint)/2;              
        }

        
        return -1;
    }
    public static void main(String[] args) {
        int target = 3; 
        int[] nums = {4,5,6,7,8,9,10,11,12,13,14,15,0,1,2,3}; 
        search_Rotatedarr(nums, target);
    }
}