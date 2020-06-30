package coffee.learn.queueandstack.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @File    :   OpenTheLock.java
 * @Time    :   2020/05/04 21:22:48
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String node = queue.poll();
                if (visited.contains(node)) continue;
                visited.add(node);
                if (target.equals(node)) return step;

                StringBuilder sb = new StringBuilder(node);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!visited.contains(s1)) queue.offer(s1);
                    if (!visited.contains(s2)) queue.offer(s2);
                }
            }
            step++;
        }
        return -1;
    }
}