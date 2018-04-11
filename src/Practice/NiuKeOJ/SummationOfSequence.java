package Practice.NiuKeOJ;

/**
 * SummationOfSequence
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * 剑指offer
 *
 * 题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 不知道这道想干啥。。不就是个等差数列的求和么。。。
 哦， 不对，不可以用乘除法。


 */
public class SummationOfSequence
{

    public int Sum_Solution(int n){
        int ans = 0;
        boolean flag = ans>0 && ((ans+=Sum_Solution(n-1))>0);
        return ans;
    }

}
