class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private static int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int leftDiff = dfs(root.left, min, max);
        int rightDiff = dfs(root.right, min, max);

        return Math.max(leftDiff, rightDiff);
    }
}
