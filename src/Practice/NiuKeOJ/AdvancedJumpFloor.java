package Practice.NiuKeOJ;

/**
 * AdvancedJumpFloor
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

 嗯，进阶版了，全部压一遍栈？？会不会内存爆掉？？我试一下啊

 不会哦，只是推导计算公式的时候，不只是f(n-1) + ... + f(1),最后还要加上1，因为要考虑到青蛙还可以直接跳n阶
 */
public class AdvancedJumpFloor {

    public class Solution {
        public int JumpFloorII(int target) {
            if(target <= 0)
                return -1;
            if(target == 1)
                return 1;
            if(target == 2)
                return 2;

            int nResult = 0;

            for(int i = target-1; i>=1; i--){
                nResult += JumpFloorII(i);
            }

            return nResult+1;
        }
    }
}
