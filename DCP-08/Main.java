import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {

    public int solve(Tree root) {
        // Write your code here
        if(root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        return isUnival(root) ? (1 + left + right) : (left + right);
    }

    public boolean unival_helper(Tree root,int value){
        if( root == null) return true;
        if(root.val == value){
            return unival_helper(root.left, value) && unival_helper(root.right, value);
        }
        return false;
    }

    public boolean isUnival(Tree root){
        if(root == null) return true;
        return unival_helper(root, root.val);
    }
}
