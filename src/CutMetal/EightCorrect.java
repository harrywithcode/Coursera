package CutMetal;

import java.io.*;
import java.util.*;

public class EightCorrect {

    static int maxProfit(int cost_per_cut, int metal_price, int[] lengths) {

        int maxLength = 0;
        for (int length : lengths) {
            if (length > maxLength) {
                maxLength = length;
            }
        }

        int maxProfit = 0;

        for (int i = 1; i < maxLength; i++) {

            int sumOfLengths = 0;
            int sumOfCutCounts = 0;
            int sumOfCutWastes = 0;

            for (int length : lengths) {

                sumOfLengths += length;

                if (length % i == 0) {
                    sumOfCutCounts += (length/i - 1);
                } else {
                    sumOfCutCounts += (length/i);
                }

                sumOfCutWastes += (length%i);
            }

            int profit = sumOfLengths*metal_price - sumOfCutCounts*cost_per_cut - sumOfCutWastes*metal_price;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int cost_per_cut = 0;
        int metal_price = 0;
        List<Integer> rods = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            cost_per_cut = scanner.nextInt();
            metal_price = scanner.nextInt();

            while (scanner.hasNextInt()) {
                rods.add(scanner.nextInt());
            }
        } catch (IllegalStateException e) {
            System.out.println("Scanner is closed and failed to scan input data");
        }
        int[] rodsLength = new int[rods.size()];
        for (int i = 0; i < rods.size(); i++) {
            rodsLength[i] = rods.get(i);
        }

        EightCorrect solution = new EightCorrect();
        System.out.print(solution.maxProfit(cost_per_cut, metal_price, rodsLength));
    }
}