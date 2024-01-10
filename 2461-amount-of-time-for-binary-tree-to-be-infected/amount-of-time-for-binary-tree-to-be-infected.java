
// Definition for a binary tree node.
public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode par;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        // allocate par
        TreeNode tar = allocatePar(root, null, null, start);
        int ans = -1;
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(tar);
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                if(!visited.contains(temp.val)){
                    visited.add(temp.val);
                }
                else{
                    continue;
                }
                if(temp.par != null && !visited.contains(temp.par.val))
                    q.add(temp.par);
                if(temp.left != null && !visited.contains(temp.left.val))
                    q.add(temp.left);
                if(temp.right != null && !visited.contains(temp.right.val))
                    q.add(temp.right);
            }
        } 
        // System.out.println(root.par);

        return ans==-1?0:ans;
    }
    private static TreeNode allocatePar(TreeNode root, TreeNode par, TreeNode tar, int start){
        if(root!=null){
            root.par = par;
            if(root.val == start)
                tar = root;
            TreeNode left = allocatePar(root.left, root, tar, start);
            TreeNode right = allocatePar(root.right, root, tar, start);
            if(tar == null)
                tar = left==null?right:left;
        }
        return tar;
    }

}