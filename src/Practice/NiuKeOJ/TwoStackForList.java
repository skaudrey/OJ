package Practice.NiuKeOJ;

import java.util.Stack;

/**
 * TwoStackForList
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 *��ָoffer
 *
 * ��Ŀ����
������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 �����Ƚ��ȳ�
 ȫ��ѹ��ȥ�����ٸ���һ��ջ���浯��ȥ��
�����´��������ģ�
����ûAC����ΪҪ�ǵñ�����ʱջΪ�մӶ���֤�������ȷ��
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
            //��һ���жϲ���ʡ����Ҫȷ���ÿ�ջ����
                while(!stack1.empty())
                    stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

}


