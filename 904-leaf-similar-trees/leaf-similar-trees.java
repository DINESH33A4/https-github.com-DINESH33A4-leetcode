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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        dfs(l1, root1);
        dfs(l2, root2);
        return l1.equals(l2);
        // return check(l1, l2);
    }
    private static boolean check(ArrayList<Integer> a, ArrayList<Integer> b){
        int m = a.size();
        int n = b.size();
        if(m!=n)    return false;
        for(int i = 0; i<m; i++){
            if(a.get(i)!=b.get(i))
                return false;
        }
        return true;
    }
    private static void dfs(ArrayList<Integer> a, TreeNode root){
        if(root!=null){
            if(root.left==null && root.right == null){
                a.add(root.val);
                return;
            }
            dfs(a, root.left);
            dfs(a, root.right);
        }
    }
}