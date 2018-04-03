package Practice.DP;

/**
 * PackageComplete
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * 完全背包(CompletePack):
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。
 * 第i种物品的费用是c[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。

完全背包按其思路仍然可以用一个二维数组来写出：

用当前的背包不断加上当前物品，就可以完成多个物品的加入
之前0,1背包的时候是用前一个物品加上当前；这个确保了物品不会重复进入背包
hhhhhhhh,这个思路很巧妙啊

f[i][v]=max{f[i][j-w[i]]+v[i],f[i-1][j]| w[i]>=0 && w[i] <= j}
 */
public class PackageComplete {

    public static void main(String[] args){
        int nSize = 3;
        int nMaxValue = 10;
        int[] weight = {0,3,4,5};
        int[] value = {0,4,5,6};

        int[][] result = new int[nSize+1][nMaxValue+1];

        for(int i = 1; i <= nSize; i++){
            for(int j = 1; j <= nMaxValue; j++){
                if(weight[i] <= j)
                    result[i][j] = Math.max(result[i-1][j],result[i][j-weight[i]]+value[i]);
                else
                    result[i][j] = result[i-1][j];
            }
        }
        System.out.println(result[nSize][nMaxValue]);
    }


    //another idea

    public static void solve2(){

        int nSize = 3;
        int nMaxValue = 10;

        int[] weight = {0,3,4,5};
        int[] value = {0,4,5,6};
        int[] amout = {0,1,2,3};
        int[][] result = new int[nSize+1][nMaxValue+1];

        for(int i=1; i <= nSize; i++){
            for (int j=1; j <= nMaxValue; j++){
                for(int k = 0; k*weight[i]<=j; k++)
                    result[i][j] = Math.max(result[i][j],result[i-1][j-k*weight[i]]+k*value[i]);
            }
        }

        System.out.println(result[nSize][nMaxValue]);
    }
}
