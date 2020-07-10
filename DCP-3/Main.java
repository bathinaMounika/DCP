class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Main{
    public static void main(String[] args){
        Codec codec= new Codec();
        TreeNode root = new TreeNode(12);
        //root.left = new TreeNode(6);
        root.right = new TreeNode(13);
        root.right.right = new TreeNode(300);
        root.left = new TreeNode(100);
        root.left.left = new TreeNode(99);
        System.out.println(codec.serialize(root));
        
    }
}

class Codec {

    public int height(TreeNode root){
        //root is at height 0
        if(root == null|| (root.left == null && root.right == null)){
            return 0;
        }
        else{ 
            return Math.max(1 + height(root.left), 1 + height(root.right));
        }
    }

    public String serialize(TreeNode root) {
        int height = height(root);
        int nodesCount = (int)Math.pow(2, height+1) - 1;
        TreeNode arr[] = new TreeNode[nodesCount];
        arr[0] = root;
        TreeNode node = null;
        TreeNode lchild = null;
        TreeNode rchild = null;
        int t;
        for(int i = 0; i < nodesCount; i ++){
            node = arr[i];
            if(node == null) continue;
            lchild = node.left;
            rchild = node.right;
            if(lchild != null){
                arr[2*i + 1] = lchild;
            }
            if(rchild != null){
                arr[2*i + 2] = rchild;
            }
        }
        String s = "";
        String sep = ",";
        for(TreeNode nd: arr){
            if(nd != null) s += nd.val + sep;
            else s += "null" + sep;
        }
        if (s != null && s.length() > 0) {
            s = s.substring(0, s.length() - 1);
        }
        s = "[" + s + "]";
        return s;
    }
}