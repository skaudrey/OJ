package Practice.NiuKeOJ;

/**
 * Fibonacci
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��ָoffer
 *
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
 *
 * �ǵ�fibonacci�ĵݹ鹫ʽ�ͺܼ��ˣ�ע�� F(0) = 0��F(1) = 1
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
