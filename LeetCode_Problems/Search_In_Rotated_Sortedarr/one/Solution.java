package one;


class Solution {

    // input unsorted: [4,5,6,7,0,1,2] 
    // input sorted: [0,1,2,4,5,6,7]

    /**
        use bin search to find the pivot
        bin search the part where answer is 

        edge cases when arr len is 1 &&
        since no duplicates you can check if arr is not rotated 
        if arr[start] < arr[end] the arr is not rotated around pivot


        find pivot
            left pointer at start
            right pointer at end
            take the middle 
            if arr mid > arr mid+1 you found the middle
        
        if pivoted do bin search on part with answer
            if tartget > arr pivot && target < arr start
                target will be in right side of arr
            else 
                target will be in left side
        bin search 
            on the part of the arr that will contain the answer
            while Lpoint <= Rpoint
        
     */
    
    static int search_Rotatedarr(int[] arr, int target){
        int len = arr.length;
        int start = 0; 
        int end = len -1;
        // len == 1 edge case
        if(len == 1){
            if(arr[0] == target){ return 0; }
            else{ return -1; }
        }
        // not rotated around pivot edge case
        if(arr[start] > arr[end]){
            int pivot = find_Pivot(arr);
            if(target >= arr[pivot] && target < arr[start]){
                start = pivot; 
            }
            else{
                end = pivot;
            }
        }
        int indexOfTarget = bin_Search(arr, target, start, end);
        System.out.println();
        System.out.println(indexOfTarget);
        return indexOfTarget;

    }
    static int bin_Search(int[] arr, int target, int start, int end){
        int mid;
        int Rpoint = end;
        int Lpoint = start;
        
        while(Lpoint <= Rpoint){
            mid = (Lpoint + Rpoint) /2;
            if(arr[mid] == target){ return mid;}
            if(arr[mid] < target) { Lpoint = mid + 1;}
            if(arr[mid] > target) { Rpoint = mid - 1;}
        }
        return -1;
    }
    static int find_Pivot(int[] arr){
        int len = arr.length;
        int start = 0;
        int end = len-1;
        
        int Lpoint = start;
        int Rpoint = end;
        
        int mid; 
        while(Lpoint <= Rpoint){
            mid = (Lpoint + Rpoint) /2;
            // [5,1] found pivot 
            if(arr[mid] > arr[mid+1]){
                return mid+1;
            }
            else{
                // move Lpoint to mid+1
                if(arr[Lpoint] <= arr[mid]){
                    Lpoint = mid+1;
                }
                // move Rpoint to mid -1
                else{
                    Rpoint = mid-1;
                }
            }
        }
        return 0;
    } 
    public static void main(String[] args) {
        int target = 1; 
        int[] nums = {4,5,1,2,3}; 
        search_Rotatedarr(nums, target);
    }
}