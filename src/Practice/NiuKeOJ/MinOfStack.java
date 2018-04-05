package Practice.NiuKeOJ;

/**
 * MinOfStack
 *
 * @author Mia Feng
 * @date 2018/4/3
 *
 * ����github�������˼����ˡ�������һֱ�䲻�ɹ�����
 * ��ʾ�޷���½
 * ���췢�֡���ʲôʱ���Լ�����github��������Ҿ�Ȼ��ȫû��ӡ��orz
 *
 * ��ָoffer
 *
 * ��Ŀ����
����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 ��ʼû������Ŀ����˼
 �š���ԭ���Ǳ���ջ�Ĺ���������һ��ջ����Сֵ������������Ǹ�ջ��ջ��������Сֵ

 */
import java.util.Stack;
public class MinOfStack {
    public Stack<Integer> data = new Stack<>();//ע���ۣ�Stack����û��top������
    public Stack<Integer> min = new Stack<>();//�洢��ջʱ����Сֵ
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
    //pop��ʱ������ջҪͬʱά��
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
