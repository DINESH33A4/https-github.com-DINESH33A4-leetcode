class Solution {
    public int findNumberOfLIS(int[] nums) {
        int x = nums.length;
    int lengths[] = new int[x];
    int counts[] = new int[x]; 
    for (int i = 0; i < x; i++) {
        lengths[i] = 1;
        counts[i] = 1;
    }

    for (int i = 0; i < x; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                if (lengths[j] + 1 > lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    counts[i] = counts[j];
                } else if (lengths[j] + 1 == lengths[i]) {
                    counts[i] += counts[j];
                }
            }
        }
    }

    int maxLen = 0;
    for (int i = 0; i < x; i++) {
        if (lengths[i] > maxLen) {
            maxLen = lengths[i];
        }
    }

    int result = 0;
    for (int i = 0; i < x; i++) {
        if (lengths[i] == maxLen) {
            result += counts[i];
        }
    }

    return result;
    }
}