package BinaryTree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int target, int sum){
        System.out.println(root.val);
        sum += root.val;
        if(root.left == null && root.right == null){
            System.out.println("END");
            System.out.println("sum = " + sum);
            return sum == target;
        }

        if(root.left != null) {
            if(dfs(root.left, target, sum)){
                return true;
            }
        }
        if(root.right != null) {
            if(dfs(root.right, target, sum)){
                return true;
            }
        }

        return false;
    }
}
