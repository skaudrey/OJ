package Practice.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MultipleTable
 *
 * @author: Mia Feng
 * @date: 2018/4/18
 *
 * 度度熊和爷爷在玩一个乘法表游戏。乘法表的第i行第j列位置的元素为i*j，并且乘法表下标编号从1开始，比如2?×?3乘法表为

1 2 3
2 4 6

爷爷十分聪明，对于n*m的乘法表，只要度度熊给出一个数k，爷爷就能立刻告诉度度熊乘法表中元素按照不减顺序排列之后，
第k个元素是多少。你能重复这个游戏吗？

 暴力法内存溢出了
  其实可以用二分查找

/**
 * 获取数字num在乘法表n*m中的最后一个位置（有可能存在多个num），比如
 *  1   2   3   4   5
 *  2   4   6   8   10
 *  3   6   9   12  15
 * 乘法表序列为： 1 2 2 3 3 4 4 5 6 6 8 9 10 12 15
 * 6在乘法表的位置为：10
 *          计算方法：min(6/1,5)+min(6/2,5)+min(6/3,5) = 10
 *          理解：第一行比6小或相等的有6/1个数，但6越过了m=5，故只有5个，第二行有6/2个数，第三行有6/3个</br>
 * 同理5的位置为： 8
 * 同理7的位置为：10，但7并不在乘法表中，这并不妨碍,按照计算结果返回
 */

public class MultipleTable {

    public static long m;
    public static long n;
    public static long k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        m = sc.nextLong();
        k = sc.nextLong();

        System.out.print(solve2(1,m*n,k));

    }

    //exceed the memory limitation
    public static int solve1(int n, int m ,int k){
        int[] table = new int[n * m];

        int nInd = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                table[nInd++] = i * j;
            }
        }

        Arrays.sort(table);

        System.out.println(table[k - 1]);

        return table[k-1];
    }


    public static long solve2(long left, long right, long k){
        long mid;
        while(left<=right){
            mid = (left+right)/2;

            if(cal(mid)<k)  //顺序不可以反，等于的情况一定要让mid-1处理
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    public static long cal(long k){
        long sum = 0;

        for(int i = 1; i<=n; i++)   // <= n
            sum += Math.min(k/i,m);

        return sum;
    }
}
