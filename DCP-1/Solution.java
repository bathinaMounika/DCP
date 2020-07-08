import java.util.*;

class Solution {
    public boolean solve(int[] nums, int k) {
        Set hset = new HashSet();
        for(int n: nums){
            if(hset.contains(k - n))
                return true;
            hset.add(n);
        }
        return false;
    }
}
