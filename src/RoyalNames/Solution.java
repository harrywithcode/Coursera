package RoyalNames;

import java.util.Comparator;
import java.util.PriorityQueue;

//给你一串名字，让你排序
//名字都是皇室的名字，名字+空格+第几世
//第几世是用罗马数字表示的
//按字母顺序排，重名的话，按照世从小到大排序
class RoyalName {
    String originalRoyalName;
    String name;
    int level;

    public RoyalName(String originalRoyalName, String name, String romanLevel) {
        this.originalRoyalName = originalRoyalName;
        this.name = name;
        this.level = romanToInt(romanLevel);
    }
    private int romanToInt(String s) {
        int sum=0;
        if(s.indexOf("IV") != -1){sum -= 2;}
        if(s.indexOf("IX") != -1){sum -= 2;}
        if(s.indexOf("XL") != -1){sum -= 20;}

        char c[] = s.toCharArray();


        for(int count = 0; count <= s.length() - 1; count++) {
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;
        }
        return sum;
    }
}
public class Solution {
    public String[] getSortedList(String[] names) {
        if (names.length < 2) {
            return names;
        }
        PriorityQueue<RoyalName> queue = new PriorityQueue<>(new Comparator<RoyalName>() {
            @Override
            public int compare(RoyalName n1, RoyalName n2) {
                if (n1.name.compareTo(n2.name) > 0) {
                    return 1;
                } else if (n1.name.compareTo(n2.name) < 0) {
                    return -1;
                } else {
                    if (n1.level > n2.level) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        for (String name : names) {
            String wordName = name.split(" ")[0];
            String level = name.split(" ")[1];

            RoyalName currentName = new RoyalName(name, wordName, level);
            queue.offer(currentName);
        }

        String[] result = new String[names.length];
        int index = 0;

        while (!queue.isEmpty()) {
            RoyalName current = queue.poll();
            result[index++] = current.originalRoyalName;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] names = new String[]{"Philippe II", "Philip II"};
        String[] result = solution.getSortedList(names);

        for (String str : result) {
            System.out.println(str);
        }
    }
}
