package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if((root.left == null && root.right != null) || (root.left != null && root.right == null)) return false;
        
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        left.add(root.left);
        while (!left.isEmpty()) {
            TreeNode node = left.remove();
            if(node == null){
                leftList.add(null);
                System.out.println("null");
                continue;
            }else {
                leftList.add(node.val);
                System.out.println(node.val);
            }

            left.add(node.left);
            left.add(node.right);
        }

        System.out.println();

        right.add(root.right);
        while (!right.isEmpty()) {
            TreeNode node = right.remove();
            if(node == null){
                rightList.add(null);
                System.out.println("null");
                continue;
            }else {
                rightList.add(node.val);
                System.out.println(node.val);
            }

            right.add(node.right);
            right.add(node.left);
        }

        System.out.println(Arrays.toString(leftList.toArray()));
        System.out.println(Arrays.toString(rightList.toArray()));

        System.out.println(leftList.equals(rightList));

        return leftList.equals(rightList);
    }

    public boolean isSymmetric2(TreeNode root) {
        return compare(root.left, root.right);
    }


    private boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null)   return true;
        if(left != null && right == null)   return false;
        if(left == null && right != null)   return false;
        if(left.val != right.val)   return false;

        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
