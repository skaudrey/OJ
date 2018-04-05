package Practice.NiuKeOJ;

/**
 * TheSamePopOrderOfStack
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 *
 * 剑指offer
 *
 * 题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）



正常思路就是用辅助栈来做模拟就好了，两个栈顶元素相同就弹，不然就继续压
 *
 * 其实不需要辅助栈，栈每次弹出和上次弹出之间的坐标不可能相差大于1
# 比如题中最后512是错的，就是因为5和1之间跨过了2
 */

//注意，stack中类似pop的函数是peek
import java.util.Stack;

public class TheSamePopOrderOfStack {
    public class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> s = new Stack<>();
            int i= 0;

           for(int a:pushA){
               s.push(a);
               while(!s.isEmpty() && s.peek()==popA[i]){//注意这里是while不是if，只要栈顶和popA相等就弹栈，如果用if会有一些没有弹完
                   s.pop();
                   i++;
               }
           }
            return s.isEmpty();
        }
    }
}


