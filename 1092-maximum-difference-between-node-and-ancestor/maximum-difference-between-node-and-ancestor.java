/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        ArrayList<Integer> track = new ArrayList<>();
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        return dfs(root, track, ans);
    }
    private static int dfs(TreeNode root, ArrayList<Integer> track, int[] ans){
        if(root!=null){
            track.add(root.val);
            dfs(root.left, track, ans);
            dfs(root.right, track, ans);
            int a = track.get(track.size() - 1);
            track.remove(track.size() - 1);
            for(int i  = 0; i<track.size(); i++){
                ans[0] = Math.max(ans[0], Math.abs(track.get(i) - a));
            }
        }
        return ans[0];
    }
}