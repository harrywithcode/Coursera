package TaskManager;

import java.util.*;

//https://www.evernote.com/shard/s393/sh/937de015-9921-46c1-aad6-0fcdb1d381d7/44b86b7b7855ebe4
//老板给了n个任务，其中m个任务是有顺序的，必须先完成a才能完成b
//另外一条规则是，先完成了b，然后老板给了任务a，但是任务a必须是在b之前完成的才可以，这种情况下，a不能做
//总结一下，也就是说，a->b这个顺序不但应用于b，还要应用于a，执行a的时候要查看b没执行，执行b的时候要查看a执行了
//b -> a
class Task implements Comparable<Task> {

    public long D;
    public long M;

    public Task(long D, long M) {
        this.D = D;
        this.M = M;
    }

    public int compareTo(Task task) {
        if (this.D < task.D) {
            return -1;
        } else if (this.D > task.D) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class TaskManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<Long> tasks = new ArrayList<Long>(T);
        for (int i = 0; i < T; i++) {
            long D = scanner.nextLong();
            long M = scanner.nextLong();
            System.out.println(solve(tasks, D, M, i));
        }
    }

    public static Map<Long, Long> map = new HashMap<Long, Long>();
    public static long maxSoFar = -1;
    public static long deadlineOfMax = -1;

    public static long solve(List<Long> tasks, long D, long M, int upIndex) {
        if (maxSoFar >= 0 && D <= deadlineOfMax) {
            map.put(deadlineOfMax, map.get(deadlineOfMax) + M);
            maxSoFar += M;
            return Math.max(0, maxSoFar);
        }


        if (!map.containsKey(D)) {
            map.put(D, M);
        } else {
            map.put(D, map.get(D) + M);
        }

        if (tasks.size() == 0) {
            tasks.add(D);
            return Math.max(0, M - D);
        } else {
            long total = 0;
            int index = 0;
            long max = -1;
            boolean found = false;
            while (index < tasks.size() &&
                    tasks.get(index) <= D) {
                if (tasks.get(index) == D)
                    found = true;
                total += map.get(tasks.get(index));
                long diff = total - tasks.get(index);
                if (diff > max) {
                    max = diff;
                    maxSoFar = max;
                    deadlineOfMax = tasks.get(index);
                }
                index++;
            }
            if (!found)
                tasks.add(index, D);       // linear, can we avoid this?
            while (index < tasks.size()) {
                total += map.get(tasks.get(index));
                long diff = total - tasks.get(index);
                if (diff > max) {
                    max = diff;
                    maxSoFar = max;
                    deadlineOfMax = tasks.get(index);
                }
                index++;
            }
            return Math.max(0, max);
        }
    }
}