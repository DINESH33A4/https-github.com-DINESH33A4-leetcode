class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                q.offer(c);
            }
            else{
                while(!q.isEmpty() && q.peek() != c){
                char popped = q.poll();
                set.remove(popped);
                }
                q.poll();
                q.add(c);   
            }
            ans = Math.max(ans, q.size());
        }
        return ans;
    }
}