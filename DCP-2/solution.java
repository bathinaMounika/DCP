import java.util.*;

class Solution {

    public int[] solve(int[] nums) {
    
        int product = 1;
        for(int i: nums){
            product *= i;
        }
        
        int[] arr = new int[nums.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = product/nums[i];
        }
        return arr;
        
    }
}