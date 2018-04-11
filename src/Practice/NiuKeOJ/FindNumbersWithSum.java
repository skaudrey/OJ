package Practice.NiuKeOJ;

import java.util.ArrayList;

/**
 * FindNumbersWithSum
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * 剑指offer
 * 题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {



    //自己的思路。。有点儿笨。。看看别人的思路觉得挺巧的
    public ArrayList<Integer> FindNumbersWithSum_solve1(int [] array,int sum) {
        int mult = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        int a=0, b = 0;

        int nLen = array.length;
        int i = nLen-1;

        if(array==null || nLen==0)
            return result;

        while(array[i]>sum && i>=0)
            i--;
        if(i==0)
            return result;

        for(int j = 0; j<=i; j++){
            for(int k = j+1;k<=i; k++ ){
                if(array[j]+array[k]==sum){
                    if(array[j]*array[k]<mult){
                        a = Math.min(array[j],array[k]);
                        b = Math.max(array[j],array[k]);

                        mult = a*b;
                    }
                }
            }
        }
        if(a==0&&b==0)
            return result;
        result.add(a);
        result.add(b);
        return result;
    }


    /*
    *
    * 数列满足递增，设两个头尾两个指针i和j，
    * 若ai + aj == sum，就是答案（相差越远乘积越小）
    * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
    * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
    * O(n)
    * */

    public ArrayList<Integer> FindNumbersWithSum_solve2(int [] array,int sum) {

        ArrayList<Integer> result = new ArrayList<>();

        int nLen = array.length;
        int i = 0,j=nLen-1;

        while(i<j){
            if(array[i]+array[j]==sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
            while(array[i]+array[j]<sum)
                i++;
            while(array[i]+array[j]>sum)
                j--;
        }

        return result;
    }

}