import java.util.*;

class Solution {
    public boolean solve(int[] nums, int k) {
        Hashtable htable = new Hashtable();
        for(int n: nums){
            if(htable.containsKey(k - n)){
                return true;
            }
            htable.put(n, 1);
        }
        return false;
    }
}
