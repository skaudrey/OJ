package Practice.DP;

/**
 * TowerTreeMaxSum
 *
 * @author Mia Feng
 * @date 2018/3/25
 *
 * 塔树选择和最大问题
 *
 * 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
 *
 *      5
 *     8 4
 *    3 6 9
 *   7 2 9 5
 *
 * 倒序填充比较理想
 * 从定到底比较难算法，但是从底到顶有规律
 * 用[i,j]表示第i行第j列
 * dp[i][j]存储下一层到[i.j]时的最大和
 *
 * dp[3][2] = max(dp[3+1][2],dp[3+1][2+1]) + a[3][2]
 *
 * 根据上述公式编程思路如下
1、初始化最下面一排dp
2、由下往上，安装上述公式对dp进行赋值
3、dp[0][0]为最终所求
 */
public class TowerTreeMaxSum {

    public static void main(String[] args){
        int[][] tower = {{5},{8,4},{3,6,9},{7,2,9,5}};
        int nFloor = 4;
        int[][] dp = new int[nFloor][nFloor];

//        //Initialize
//        for(int i=0; i<nFloor;i++)
//            dp[nFloor-1][i] = tower[nFloor-1][i];
//
//        for(int i = nFloor-2; i>=0; i--){
//            for(int j=0; j<=i; j++)
//                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1])+tower[i][j];
//        }
        solution(tower,dp);
        System.out.println(dp[0][0]);
    }

    public static void solution(int[][] tower, int[][] dp){
        int nFloor = tower.length;

        //Initialization
        for(int i=0; i<nFloor; i++){
            dp[nFloor-1][i] = tower[nFloor-1][i];
        }

        //Derive optimal summation
        for(int i = nFloor-2; i>=0; i--){
            for(int j = 0; j<=i; j++)
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1]) + tower[i][j];
        }
    }
}
