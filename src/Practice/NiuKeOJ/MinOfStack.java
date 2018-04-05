package Practice.NiuKeOJ;

/**
 * MinOfStack
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * 想往github上推想了几天了。。但是一直配不成功。。
 * 提示无法登陆
 * 今天发现。。什么时候自己改了github的密码而且竟然完全没有印象orz
 *
 * 剑指offer
 *
 * 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 开始没看懂题目的意思
 嗯。。原来是边入栈的过程中用另一个栈把最小值存下来，最后那个栈的栈顶就是最小值

 */
import java.util.Stack;
public class MinOfStack {
    public Stack<Integer> data = new Stack<>();//注意哇，Stack里面没有top函数的
    public Stack<Integer> min = new Stack<>();//存储入栈时的最小值
    Integer curMin = null;
    public void push(int node){
        if(null!=curMin){
            if(node<curMin){
                min.push(node);
                curMin = node;
            }
            data.push(node);
        }else {
            data.push(node);
            min.push(node);
            curMin = node;
        }
    }
    public int top(){
        int num = data.pop();
        data.push(num);
        return num;
    }
    //pop的时候两个栈要同时维护
    public void pop(){
        int num = data.pop();
        int num2 = min.pop();
        if(num2!=num)
            min.push(num2);
    }
    public int min(){
        int n = min.pop();
        min.push(n);

        return n;
    }

}
