package Practice.NiuKeOJ;

/**
 * TileFillNum
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 剑指offer
 *
 * 题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

 好吧，竟然还是菲波那切数列

 这个计算方法可以的

 分析可以看看这里

https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6
 */
public class TileFillNum {

    public class Solution {
        public int RectCover(int target) {
            if(target < 1)
                return 0;
            if(target == 1)
                return 1;
            if(target == 2)
                return 2;

            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
