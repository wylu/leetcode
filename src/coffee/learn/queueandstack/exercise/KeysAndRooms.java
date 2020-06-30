package coffee.learn.queueandstack.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @File    :   KeysAndRooms.java
 * @Time    :   2020/05/06 22:02:11
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        seen[0] = true;
        while (!stack.isEmpty()) {
            for (int key: rooms.get(stack.pop())) {
                if (!seen[key]) {
                    seen[key] = true;
                    stack.push(key);
                }
            }
        }
        for (boolean visited: seen) {
            if (!visited) return false;
        }
        return true;
    }
}