package Practice.NiuKeOJ;

import java.util.Scanner;

/**
 * PrimPair
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 题目描述
给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
输入描述:
输入包括一个整数n,(3 ≤ n < 1000)
输出描述:
输出对数
示例1
输入
10
输出
2

 看到一个AC很有意思，先记所有数为素数，将素数的倍数记录为非质数，很省计算量
 *
 */
public class PrimPair {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] primFlags = new int[1000];    // 0 for prim, 1 for not prim

        for(int i = 2; i < 1000 ; i++){
            for(int j = 2; i*j < 1000; j++){
                if(primFlags[i]==0)
                    primFlags[i*j] = 1;    //素数的倍数都置为非素数
            }
        }

        //空间换时间，思路很赞

        int nResult = 0;

        for(int i=2; i<= num/2; i++){
            if(primFlags[i]==0 && primFlags[num-i]==0)  //感觉这里也类似于DP的思想
                nResult++;
        }
        System.out.println(nResult);
    }
}