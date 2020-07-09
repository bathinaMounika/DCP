import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 0, arr.length, 1);
        int leftProduct = 1;
        int rightProduct = 1;

        for(int i = 0; i < nums.length; i++){
            arr[i] *= leftProduct;
            leftProduct *= nums[i];
        }

        for(int j = nums.length - 1; j >= 0; j--){
            arr[j] *= rightProduct;
            rightProduct *= nums[j];
        }
        return arr;
    }
}