package MoveFromOnePointToAnother;
import java.util.*;
//移动一个点，每次这个点只能有两种移动方式，(x,y)每次只能移动到(x, x+y) 或者(x+y, y)两个方向
//问你，这个点能不能移动到另一个点上,如果能的话，返回路径
//和Bloomberg的面试题一样，二叉树bfs
class Node {
    int[] point;
    List<int[]> trace;
    public Node(int[] point) {
        this.point = point;
        this.trace = new ArrayList<>();
    }
}

public class MovePoint {
    public List<int[]> move(int[] start, int[] end) {
        List<int[]> result = new ArrayList<>();

        Node root = new Node(start);
        root.trace.add(start);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int[] left = new int[]{current.point[0], current.point[0] + current.point[1]};
            int[] right = new int[]{current.point[0] + current.point[1], current.point[1]};

            boolean leftStatus = true;
            boolean rightStatus = true;

            if (left[0] <= end[0] && left[1] <= end[1]) {
                Node leftNode = new Node(left);
                leftNode.trace.addAll(current.trace);
                leftNode.trace.add(left);

                if (left[0] == end[0] && left[1] == end[1]) {
                    result = leftNode.trace;
                    break;
                } else {
                    queue.offer(leftNode);
                }
            } else {
                leftStatus = false;
            }

            if (right[0] <= end[0] && right[1] <= end[1]) {
                Node rightNode = new Node(right);
                rightNode.trace.addAll(current.trace);
                rightNode.trace.add(right);

                if (right[0] == end[0] && right[1] == end[1]) {
                    result = rightNode.trace;
                    break;
                } else {
                    queue.offer(rightNode);
                }
            } else {
                rightStatus = false;
            }

            if (leftStatus == false && rightStatus == false) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MovePoint m = new MovePoint();
        int[] start = new int[]{1,4};
        int[] end = new int[]{5,9};

        List<int[]> result = m.move(start, end);

        for (int[] point : result) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
}
