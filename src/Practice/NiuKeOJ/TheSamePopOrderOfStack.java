package Practice.NiuKeOJ;

/**
 * TheSamePopOrderOfStack
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 *
 * ��ָoffer
 *
 * ��Ŀ����
���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�



����˼·�����ø���ջ����ģ��ͺ��ˣ�����ջ��Ԫ����ͬ�͵�����Ȼ�ͼ���ѹ
 *
 * ��ʵ����Ҫ����ջ��ջÿ�ε������ϴε���֮������겻����������1
# �����������512�Ǵ�ģ�������Ϊ5��1֮������2
 */

//ע�⣬stack������pop�ĺ�����peek
import java.util.Stack;

public class TheSamePopOrderOfStack {
    public class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> s = new Stack<>();
            int i= 0;

           for(int a:pushA){
               s.push(a);
               while(!s.isEmpty() && s.peek()==popA[i]){//ע��������while����if��ֻҪջ����popA��Ⱦ͵�ջ�������if����һЩû�е���
                   s.pop();
                   i++;
               }
           }
            return s.isEmpty();
        }
    }
}


