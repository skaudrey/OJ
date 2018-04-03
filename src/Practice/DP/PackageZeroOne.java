package Practice.DP;

/**
 * PackageZeroOne
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 * 有N件物品和一个容量为V的背包。（每种物品均只有一件）第i件物品的费用是c[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使价值总和最大。

这是最基础的背包问题，特点是：每种物品仅有一件，可以选择放或不放。
 */
public class PackageZeroOne {

    public static void main(String[] args){
        int nSize = 3;//三件物品
        int nMaxWeight = 10;    // 背包最大容量为10

        int[] weight = {0,3,4,5};  //数组大小为 nSize+1,为了好推索引添加了0号物品，重量0，价值0
        int[] value = {0,4,5,6};   //数组大小为 nSize+1，为了好推索引添加了0号物品，重量0，价值0
        int[][] result = new int[nSize+1][nMaxWeight+1];    // result[i][j] 表示当前加入物品i后达到重量j所对应的最大价值

        for(int i = 1; i<=nSize; i++){
            for (int j = 1; j<=nMaxWeight; j++){
                if(weight[i] <= j )
                    result[i][j] = Math.max(result[i-1][j], result[i-1][j-weight[i]]+value[i]);
                else    //如果当前物品的重量大于当前背包的承重，物品不可以放入背包中，所以背包的价值不变
                    result[i][j] = result[i-1][j];
            }
        }

        System.out.println(result[nSize][nMaxWeight]);
        //如果要找对应放了哪几个物品的话，可以从遍历最后一列从第一行往下，直至数值达到最大value且不改变为止，行号就是对应的物品号


    }
}
