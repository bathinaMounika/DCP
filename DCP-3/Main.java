//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.Arrays;

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
        System.out.println(codec.serialize(codec.deserialize("[12,13,null,null,89,null,null]")));
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

    // Encodes a tree to a single string.
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        if(data != null && data.length() > 0 && data.charAt(0) == '[' && data.charAt(data.length() - 1) == ']')
            data = data.substring(1, data.length() - 1); //removing brackets
        String values[] = data.split(",");
        System.out.println("Arrays.toString" + Arrays.toString(values));
        TreeNode nodeList[] = new TreeNode[values.length];
        if(values.length > 0 ){ //checking atleeast one node is present
            for(int i = 0; i < values.length; i++){
                    if(values[i].compareTo("null") != 0){
                        nodeList[i] =new TreeNode(Integer.parseInt(values[i]));
                    }
                    else{
                        nodeList[i] = null;
                    }
            }
        }
        int nodeCount = nodeList.length;
        for(int i = 0; i < nodeCount; i++){
            if(nodeList[i] != null && 2*i + 1 < nodeCount){
                nodeList[i].left = nodeList[2*i + 1];
                nodeList[i].right = nodeList[2*i + 2];
            }
        }
        return nodeList[0]; //root
    }
}