package DiscountPrice;
import java.util.*;

//一共有n个商品，每个商品都可能打折，打折的原则是
//从这个商品a的右边开始数，找到第一个小于等于该商品价格的商品b，然后此时a的价格就变成了a-b
//也就是说这个商品便宜了b元
//输出两行信息，第一行信息是打折以后所有商品的总价格：可以先求出总原价和总打折价，然后相减
//第二行输出一个array，没打折的商品的index

//暴力解，每个数都往他的右侧遍历，不好
//可以这么想，所有上坡的点都不需要被考虑，我们只需要找出所有的下坡点（也就是刚刚下坡），这个点之前的所有上坡点
//全都会按照这个下坡点的值而打折。最后这道题其实就是求所有的下坡点的和
//以上说法也不对。

//就先用暴力解吧
public class DiscountPrice {
    public void finalPrice(int[] prices) {
        int totalPrice = 0;
        int discount = 0;
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            totalPrice += prices[i];

            int j = i + 1;
            boolean find = false;

            while (j < prices.length) {
                if (prices[j] <= prices[i]) {
                    discount += prices[j];
                    find = true;
                    break;
                }
                j++;
            }
            if (find == false) {
                indices.add(i);
            }
        }
        System.out.println(totalPrice - discount);
        for (int i : indices) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        DiscountPrice d = new DiscountPrice();
        int[] input = new int[]{1,3,3,2,5};
        d.finalPrice(input);
    }

    //根据提示，可以用栈做，但其实时间复杂度应该是一样的吧
    //暴力解是去的时候走重复路，回来的时候不走重复路。栈的话是去的时候不走重复路，回来的时候走重复路
    //先写一下吧，当练习了.写不了，index的信息丢失
//    public void useStack(int[] prices) {
//        int totalPrice = 0;
//        int discount = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(prices[0]);
//
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] <= stack.peek()) {
//                while (!stack.isEmpty()) {
//                    int price = stack.pop();
//                    if (price >= prices[i]) {
//                        discount += prices[i];
//                    } else
//                }
//            }
//        }
//    }
}
