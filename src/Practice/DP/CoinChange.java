package Practice.DP;

import java.util.Scanner;

/**
 * CoinChange
 *
 * @author Mia Feng
 * @date 2018/3/24
 *
 * Given coins = {1,3,5}
 * Total coins = 11
 * Solve the number of coins
 *
 * Given d as the state array, which means it contains the total value of coins with some coins.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int value = 98;

        int[] solution = new int[value];

        int min = solution(coins, value, solution);

        System.out.println(min);

        for (int i = value - 1; i >= 0; ) {
            System.out.println(solution[i]);
            System.out.println("-->");
            i = i - solution[i];
        }

    }


    public static int solution(int[] coins, int value, int[] solution) {
        int[] mins = new int[value + 1];

        for (int i = 1; i <= value; i++)
            mins[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= value; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && mins[i] > mins[i - coins[j]] + 1) {
                    mins[i] = mins[i - coins[j]] + 1;
                    solution[i - 1] = coins[j];
                }
            }
        }

        return mins[value];
    }


    //参考完全背包的一种解法
    public static void solve() {

        int nSize = 3;
        int nMaxValue = 100; //

        int[] value = {0, 1, 3, 5};


//        int[] value = {0,4,5,6};
//        int[] amout = {0,1,2,3};
        int[][] result = new int[nSize + 1][nMaxValue + 1];

        for (int i = 1; i <= nSize; i++) {
            for (int j = 1; j <= nMaxValue; j++)
                result[i][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= nSize; i++) {
            for (int j = 1; j <= nMaxValue; j++) {
                if (value[i] <= j)
                    result[i][j] = Math.min(result[i][j], result[i][j - value[i]] + 1);
            }
        }

        System.out.println(result[nSize][nMaxValue]);

    }
}


//
//    public static void main(String[] args){
//        int[] coins = {1,3,5};
//        int value = 100;    //target value
//        int[] solu = new int[value];
//        int min = solution(coins,value,solu);
//
//        for(int i = value-1; i>=0; ){
//            System.out.println(solu[i]+"-->");
//            i = i - solu[i];
//        }
//        System.out.println();
//        System.out.println(min);
//    }
//
//    private static int solution(int[] coins, int value, int[] solu){
//        int[] mins = new int[value+1];  //mins[i] 表示凑够i元时最少需要多少个硬币
//
//        for(int i=1; i<=value; i++)
//            mins[i] = Integer.MAX_VALUE;
//
//        for(int i=1; i <= value; i++){
//            for(int j=0; j<coins.length; j++){
//                if(coins[j] <= i && mins[i] > mins[i-coins[j]]+1){//这里的技巧是i-coins[j]；如果用当前硬币凑到i元时所需的硬币数量
//                    mins[i] = mins[i-coins[j]] + 1;
//                    solu[i-1] = coins[j];
//                }
//            }
//        }
//        return mins[value];
//    }
//
//
//
//    public static void main(String[] args){
//        int[] coins = {1,3,5};
//        int value = 72;
//
//        int[] solu = new int[value];    //solu[i]表示凑到当前硬币值i所需要增加的一枚硬币
//
//        int min = solution(coins, value, solu);
//
//        for(int i=value-1; i>=0;){    //注意这里是倒序输出
//            System.out.println(solu[i]);
//            System.out.println("-->");
//            i = i - solu[i];
//        }
//        System.out.println(min);
//    }
//
//    public static int solution(int[] coins, int value, int[] solu){
//
//        int[] mins = new int[value+1]; //当前0元时需要的最少硬币为0枚
//
//        for(int i=1; i<=value; i++){
//            mins[i] = Integer.MAX_VALUE;
//        }
//
//        for(int i = 1; i<= value; i++){
//            for(int j=0; j < coins.length; j++){
//                if(coins[j] <= i && mins[i] > mins[i-coins[j]]+1){  //注意这里的coins[j]<=i 而不能是coins[j]<i,否则永远不会有与当前硬币数匹配的时候
//                    mins[i] = mins[i-coins[j]]+1;
//                    solu[i-1] = coins[j];
//                }
//            }
//        }
//        return mins[value];
//    }