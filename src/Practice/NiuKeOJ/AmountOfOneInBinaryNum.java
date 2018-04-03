package Practice.NiuKeOJ;

/**
 * AmountOfOneInBinaryNum
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��Ŀ����
����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 *
 *֮ǰ��Leetcodeˢ���Ǹ��õ��Ƕ�̬�滮����֪���Ը����ò����ã�����һ�¡����ţ�ͻȻ�����ǲ��еġ�����Ϊ�и���������û��������
 *
 * ��������������ĺ����
 *
 * ���ӣ�https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8
��Դ��ţ����

���һ��������Ϊ0����ô�������������һλ��1��
������ǰ����������1����ôԭ�������������ұߵ�1�ͻ��Ϊ0��ԭ����1��������е�0������1(������ұߵ�1���滹��0�Ļ�)��
��������λ�������ܵ�Ӱ�졣
�ٸ����ӣ�һ����������1100�����ұ��������λ�Ǵ������ұߵ�һ��1��
��ȥ1�󣬵���λ���0�����������λ0�����1����ǰ���1���ֲ��䣬��˵õ��Ľ����1011.
���Ƿ��ּ�1�Ľ���ǰ����ұߵ�һ��1��ʼ������λ��ȡ���ˡ�
���ʱ����������ٰ�ԭ���������ͼ�ȥ1֮��Ľ���������㣬��ԭ���������ұ�һ��1��һλ��ʼ����λ������0��
��1100&1011=1000.Ҳ����˵����һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұ�һ��1���0.��ôһ�������Ķ������ж��ٸ�1��
�Ϳ��Խ��ж��ٴ������Ĳ�����
 */
public class AmountOfOneInBinaryNum {

    public static void main(String[] args){
        Solution solver = new Solution();
        solver.NumberOf1(10);

    }

    public static class Solution {
        public int NumberOf1(int n) {
            int nCount = 0;
            while(n!=0){
                nCount++;
                n = n&(n-1);
                System.out.println(n);
            }
            System.out.println("Result:");
            System.out.println(nCount);
            return nCount;
        }
    }
}
