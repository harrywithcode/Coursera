package SlidingWindow;
import java.util.*;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] result = new int[a.length - k + 1];
        int index = 0;
        // store index
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && a[queue.peekLast()] < a[i]) {
                queue.pollLast();
            }
            // q contains index... r contains content
            queue.offer(i);
            if (i >= k - 1) {
                result[index++] = a[queue.peek()];
            }
        }
        return result;
    }
}
