import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] answers = new int[n];

        Map<Integer, Integer> last = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int v = rains[i];

            if (v == 0) {
                dry.add(i);
                answers[i] = 1;
                continue;
            }

            answers[i] = -1;

            if (last.containsKey(v)) {
                int prev = last.get(v);
                Integer d = dry.higher(prev);
                if (d == null) {
                    return new int[0];
                }

                answers[d] = v;
                dry.remove(d);
            }

            last.put(v, i);
        }

        return answers;
    }
}
