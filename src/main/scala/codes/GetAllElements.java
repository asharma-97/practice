package codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetAllElements {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l = new ArrayList<Integer>();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        postOrder(root1, s1);
        postOrder(root2, s2);
        while(!(s1.isEmpty() && s2.isEmpty())) {
            if(!s1.isEmpty() && !s2.isEmpty()) {
                if(s1.peek() < s2.peek()) l.add(s1.pop());
                else l.add(s2.pop());
            } else if(s1.isEmpty()) {
                l.add(s2.pop());
            } else {
                l.add(s1.pop());
            }
        }
        return l;
    }
    public void postOrder(TreeNode root, Stack<Integer> s) {
        if(root == null) return;
        postOrder(root.right, s);
        s.add(root.val);
        postOrder(root.left, s);
    }

}
