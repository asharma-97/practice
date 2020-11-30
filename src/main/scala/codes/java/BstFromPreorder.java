package codes.java;

public class BstFromPreorder {

    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode helper(int[] preorder, int bound, int[] i) {
        if(preorder.length == i[0] || preorder[i[0]] > bound) return null;
        TreeNode t =  new TreeNode(preorder[i[0]++]);
        t.left = helper(preorder, t.val, i);
        t.right = helper(preorder, bound, i);
        return t;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
