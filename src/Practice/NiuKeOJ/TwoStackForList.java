package Practice.NiuKeOJ;

import java.util.Stack;

/**
 * TwoStackForList
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 *剑指offer
 *
 * 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 队列先进先出
 全部压进去？？再给另一个栈里面弹过去？
看了下答案是这样的，
但是没AC，因为要记得保持临时栈为空从而保证结果的正确性
 */
public class TwoStackForList {

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if(stack2.empty()){
            //这一句判断不能省。。要确保用空栈来做
                while(!stack1.empty())
                    stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

}


