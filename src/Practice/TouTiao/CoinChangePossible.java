package Practice.TouTiao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * CoinChangePossible
 *
 * @author: Mia Feng
 * @date: 2018/4/15
 */
public class CoinChangePossible {
    public static void main(String[] args)    {
        Scanner sc = new Scanner(System.in);

        int nMon1 = sc.nextInt();
        int nMon2 = sc.nextInt();
        int nValue = sc.nextInt();

        int[] mon1 = new int[nMon1];
        int[] mon2 = new int[nMon2];

        for(int i = 0; i<nMon1;i++)
            mon1[i] = sc.nextInt();

        for(int i = 0; i<nMon2;i++)
            mon2[i] = sc.nextInt();
//        int[] d = new int[nValue+1];
//        d[0] = 1;
//        for(int i = 0; i<nMon1;i++){
//            for(int j = 0;j<nMon2; j++){
//                for (int k = mon1[i];k<nValue+1; k++){
//                    d[k] = d[k-mon1[i]];
//                }
//            }
//        }
        int[][] result = new int[nMon1+nMon2+1][nValue+1];

        for(int i = 1; i<=nMon1+nMon2; i++){
            for (int j = 1; j<= nValue; j++){
                if(i<=nMon2){
                    if(mon2[i] <= j )
                        result[i][j] = Math.max(result[i-1][j], result[i-1][j-mon2[i]]+1);
                    else    //如果当前物品的重量大于当前背包的承重，物品不可以放入背包中，所以背包的价值不变
                        result[i][j] = result[i-1][j];
                }
                else{
                    if(mon1[i-nMon2] <= j)
                        result[i][j] = Math.max(result[i-1][j],result[i][j-mon2[i]]);
                    else
                        result[i][j] = result[i-1][j];
                }
            }
        }


        System.out.println(result[nMon1+nMon2][nValue]%1000000007);
    }

//    public static int getNum(int n,int k,int[] v1,int[] v2){
//        if(n==0)
//            return 1;
//        else if (n<0 || k<=0)
//            return 0;
//        else
//            return (getNum(n,k-1,v1,v2) + getNum(n-v1[k]-v2[k-1],k,v1,v2))%1000000007;
//    }

}
