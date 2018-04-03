package Practice.DP;

/**
 * PackageMultiple
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * 多重背包(MultiplePack):
 * 有N种物品和一个容量为V的背包。第i种物品最多有n[i]件可用，每件费用是c[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 *
 * 可以直接模仿完全背包，只是要限制放入物品的数目，而不像完全那样以背包的最大容量为上界
 */
public class PackageMultiple {
    public static void main(String[] args){

        int nSize = 3;
        int nMaxValue = 10;

        int[] weight = {0,3,4,5};
        int[] value = {0,4,5,6};
        int[] amount = {0,1,2,3};

        int[][] result = new int[nSize+1][nMaxValue+1];

        for (int i = 1; i <= nSize; i++){
            for (int j = 1; j <= nMaxValue; j++){
                for (int k = 0; k <= amount[i] && k*weight[i] <= j; k++){
                        result[i][j] = Math.max(result[i][j],  result[i-1][j - k * weight[i]]+k*value[i]);
                }
            }
        }

        System.out.println(result[nSize][nMaxValue]);

    }
}
