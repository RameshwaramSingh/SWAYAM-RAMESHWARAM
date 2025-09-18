//leetcode ques no 239
https://leetcode.com/problems/sliding-window-maximum/description/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];   // result array of size (n - k + 1)

        // Deque will store indexes of elements in decreasing order of values
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove elements from the front if they are out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove elements from the back if they are smaller than current element
            //    because they will never be the maximum as long as nums[i] is in the window
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index to the deque
            dq.offerLast(i);

            // 4. Once the first window is complete (i >= k - 1), record the max
            //    The front of the deque always has the index of the maximum element
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res; // return the result array
    }
}
