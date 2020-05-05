package learn.queueandstack.exercise;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @File    :   PerfectSquares.java
 * @Time    :   2020/05/05 09:45:09
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                int u = queue.poll();
                for (int i = 1; i * i <= n; i++) {
                    int v = u + i * i;
                    if (v == n) return step;
                    if (v > n) break;
                    if (!visited.contains(v)) {
                        queue.offer(v);
                        visited.add(v);
                    }
                }
            }
        }
        return step;
    }
}