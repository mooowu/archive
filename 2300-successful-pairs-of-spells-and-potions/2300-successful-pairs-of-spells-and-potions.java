import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] answers = new int[n];

        for (int i = 0; i < n; i++) {
            long s = spells[i];

            // s * p ≥ success
            // p ≥ ceil(success / s)
            long need = (success + s - 1) / s;
            int idx = binarySearch(potions, need);
            answers[i] = (idx >= m) ? 0 : (m - idx);
        }

        return answers;
    }

    private int binarySearch(int[] arr, long target) {
        int lo = 0, hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if ((long) arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
