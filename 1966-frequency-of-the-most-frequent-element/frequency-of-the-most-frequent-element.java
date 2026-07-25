class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        long[] pref = new long[n];
        int mx = 1;
        long sm = 0;

        for (int i = 0; i < n; i++) {
            sm += nums[i];
            pref[i] = sm;

            long diff = (long) (i + 1) * nums[i] - pref[i];

            if (diff <= (long) k) {
                mx = Math.max(mx, i + 1);
            } else {
                int st = 0;
                int end = i;

                while (st <= end) {
                    int mid = st + (end - st) / 2;

                    int ele = i - mid;
                    long need = (long) ele * nums[i] - (pref[i] - pref[mid]);

                    if (need <= (long) k) {
                        mx = Math.max(mx, ele);
                        end = mid - 1;
                    } else {
                        st = mid + 1;
                    }
                }
            }
        }

        return mx;
    }
}