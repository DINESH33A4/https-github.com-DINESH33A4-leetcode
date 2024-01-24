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
    public int pseudoPalindromicPaths (TreeNode root) {
        // Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        return dfs(m, root);
    }
    private static int dfs(HashMap<Integer, Integer> m, TreeNode root){
        if(root != null){
            m.put(root.val, m.getOrDefault(root.val, 0)+1);
            if(root.left == null && root.right == null){//leafnode condition
                int a = check(m);
                m.put(root.val, m.get(root.val)-1);
                return a;
            }
            int left = dfs(m, root.left);
            int right = dfs(m, root.right);
            m.put(root.val, m.get(root.val)-1);
            return left+right;
        }
        return 0;
    }
    private static int check(HashMap<Integer, Integer> m){
        boolean one = false;
        for(int i : m.values()){
            if(i%2 == 1)
                if(!one)
                    one = true;
                else
                    return 0;
        }
        return 1;
    }
}