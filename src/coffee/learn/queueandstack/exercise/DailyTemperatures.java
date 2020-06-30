package coffee.learn.queueandstack.exercise;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @File    :   DailyTemperatures.java
 * @Time    :   2020/05/05 10:57:27
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class DailyTemperatures {
    /**
     * Process indices i in descending order.
     * We'll keep a stack of indices such that T[stack[-1]] < T[stack[-2]] < ...,
     * where stack[-1] is the top of the stack, stack[-2] is second from the top,
     * and so on; and where stack[-1] > stack[-2] > ...; and we will maintain this
     * invariant as we process each temperature.
     *
     * After, it is easy to know the next occurrence of a warmer temperature:
     * it's simply the top index in the stack.
     *
     * Here is a worked example of the contents of the stack as we work through
     * T = [73, 74, 75, 71, 69, 72, 76, 73] in reverse order, at the end of the
     * loop (after we add T[i]). For clarity, stack only contains indices i, but
     * we will write the value of T[i] beside it in brackets, such as 0 (73).
     *
     * When i = 7, stack = [7 (73)]. ans[i] = 0.
     * When i = 6, stack = [6 (76)]. ans[i] = 0.
     * When i = 5, stack = [5 (72), 6 (76)]. ans[i] = 1.
     * When i = 4, stack = [4 (69), 5 (72), 6 (76)]. ans[i] = 1.
     * When i = 3, stack = [3 (71), 5 (72), 6 (76)]. ans[i] = 2.
     * When i = 2, stack = [2 (75), 6 (76)]. ans[i] = 4.
     * When i = 1, stack = [1 (74), 2 (75), 6 (76)]. ans[i] = 1.
     * When i = 0, stack = [0 (73), 1 (74), 2 (75), 6 (76)]. ans[i] = 1.
     *
     * @param T temperature
     * @return the days have to wait until a warmer temperature
     */
    public int[] dailyTemperatures(int[] T) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] res = new DailyTemperatures().dailyTemperatures(T);
        // res = [8, 1, 5, 4, 3, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(res));
    }
}