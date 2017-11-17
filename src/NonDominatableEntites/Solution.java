package NonDominatableEntites;
//两个数字代表了一个entity里的两个参数的级数。
//如果Entity A的x和y比Entity B的x和y都大，那么就说A占据了B
//有可能两个entities互相都不占有
//如果Entity A没有被任何一个entity占据，那么它叫做non-dominatable
//给一个list of entities，找到有多少个non-dominatable的entity

import java.util.*;

class Entity {
    int x;
    int y;
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    public List<Entity> findAllNonDominatable(List<Entity> input) {
        List<Entity> result = new ArrayList<>();

        PriorityQueue<Entity> queue = new PriorityQueue<>(new Comparator<Entity>() {
           @Override
           public int compare(Entity e1, Entity e2) {
               if (e1.x > e2.x) {
                   return -1;
               } else if (e1.x < e2.x) {
                   return 1;
               } else {
                   if (e1.y > e2.y) {
                       return -1;
                   } else {
                       return 1;
                   }
               }
           }
        });
        for (Entity e : input) {
            queue.offer(e);
        }

        Entity head = queue.poll();
        result.add(head);

        while (!queue.isEmpty()) {
            Entity current = queue.poll();
            if (current.x >= head.x || current.y >= head.y) {
                result.add(current);
                head = current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Entity> input = new ArrayList<>();
        Entity e1 = new Entity(1,2);
        input.add(e1);

        Entity e2 = new Entity(2,4);
        input.add(e2);

        Entity e3 = new Entity(3,6);
        input.add(e3);

        Entity e4 = new Entity(4,4);
        input.add(e4);

        Entity e5 = new Entity(5,7);
        input.add(e5);

        List<Entity> result = solution.findAllNonDominatable(input);

        for (Entity e : result) {
            System.out.println(e.x + " " + e.y);
        }
    }
}
