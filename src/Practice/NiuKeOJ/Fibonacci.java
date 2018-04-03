package Practice.NiuKeOJ;

/**
 * Fibonacci
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 剑指offer
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 *
 * 记得fibonacci的递归公式就很简单了，注意 F(0) = 0；F(1) = 1
 */
public class Fibonacci {
    public class Solution {
        public int Fibonacci(int n) {
            if(n==0)
                return 0;
            if(n==1)
                return 1;
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
}
