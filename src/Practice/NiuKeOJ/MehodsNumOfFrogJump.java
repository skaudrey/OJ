package Practice.NiuKeOJ;

/**
 * MehodsNumOfFrogJump
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 剑指offer
 *
 * 题目描述
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 这个题就跟我之前碰到的一个面试题比较像了，当时没有AC
 *
 * 觉得还是应该用DP来做，但是当前被卡在DP是最优子序列了，我要怎么拿到所有的方法数呢？？
 *
 * 好吧，看了解析才知道自己又蠢了。。不是DP，是个递归
 * 青蛙跳一级台阶只有一种方法，青蛙跳两级台阶有两种方法，跳三级有三种，跳四级有5种
 *
 * 麻烦自己，以后碰到这种题自己画画图找找规律，别一看到就慌了
 *
 * 假设有一个函数f得到跳台阶的方法数
 * 最后一步有两种情况：跳一阶，剩下的方法数就是f(n-1); 跳两阶，剩下的方法数就是f(n-2)；所以总共的方法数是 f(n-1) + f(n-2)
 */
public class MehodsNumOfFrogJump {

    public class Solution {
        public int JumpFloor(int target) {



            return 0;
        }
    }

}
