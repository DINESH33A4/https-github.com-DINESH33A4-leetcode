class Solution {
    public int findContentChildren(int[] greed, int[] sizes) {
        Arrays.sort(greed);
        Arrays.sort(sizes);
        int ans = 0;
        int cookiesIDX = 0;
        while (cookiesIDX < sizes.length && ans < greed.length) {
            if (sizes[cookiesIDX] >= greed[ans]) {
                ans++;
            }
            cookiesIDX++;
        }
        return ans;
    }
}