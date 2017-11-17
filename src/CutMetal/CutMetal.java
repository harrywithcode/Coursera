package CutMetal;
//有一些长度不一样的metal，要卖出去的话必须是长度相同的，每cut一次有一个费用，
// 然后最后能卖出去的利润跟相同长度的mental的数量有关，长度有关，具体的利润计算题里给了公式，求能得到的最大利润。
//totalProfit = numberOfRods * length * price - numberOfCuts * costPerCut
//长度越短越不值钱，而且越短说明cut的次数也多，但是number of Rod就会少
//感觉这题就直接暴力解法，但最起码首先你要保证所有的rod一样长，不然卖不出去

import java.io.InputStreamReader;
import java.util.*;

public class CutMetal {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(new InputStreamReader(System.in));
        int costpercut=scanner.nextInt();
        int price=scanner.nextInt();
        int n=scanner.nextInt();
        int arr[] =new int[n];
        for (int j = 0; j < n; j++) {
            arr[j]=scanner.nextInt();
        }
        int max = arr[0];
        int maxProfit = 0;
        for(int i = 0 ; i < arr.length; i++)
            if(max < arr[i])
                max = arr[i];
        for(int size = 1 ; size <= max; size++) {
            int profit = 0;
            for(int i = 0 ; i < arr.length; i++) {
                if(size > arr[i])
                    continue;
                int currPrice = (arr[i] / size) * price * size; // current Rod price after cutting it.
                int cuts = arr[i] % size == 0 ? (arr[i] / size) - 1 : (arr[i] / size); // Number of cuts depend on the length of rod.
                int currProfit = currPrice - costpercut * cuts;
                if(currProfit > 0)
                    profit += currProfit;
            }
            if(profit > maxProfit)
                maxProfit = profit;
        }

        System.out.println(maxProfit);
    }
}
