package ArrayGame;

//一个数组里有一组数，每次给n-1个数+1，问最少的操作次数使得数组里的所有数相等
//假设数组长度为n，一共操作了m次，最后数组里的每个数都为x，原数组内所有数字和为sum
//于是有以下等式：sum + m * (n - 1) = x * n
//又因为x = 原数组中的最小数 + m
//所以最后sum - minNum * n = m
public class Solution {
    public long countMoves(int[] array) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i : array) {
            sum += i;
            if (i < min) {
                min = i;
            }
        }
        return (long)(sum - min * array.length);
    }
}
