package Practice.NiuKeOJ;

/**
 * SummationOfSequence
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * ��ָoffer
 *
 * ��Ŀ����
��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����

 ��֪��������ɶ���������Ǹ��Ȳ����е����ô������
 Ŷ�� ���ԣ��������ó˳�����


 */
public class SummationOfSequence
{

    public int Sum_Solution(int n){
        int ans = 0;
        boolean flag = ans>0 && ((ans+=Sum_Solution(n-1))>0);
        return ans;
    }

}
