package Practice.NiuKeOJ;

/**
 * AddWithoutOperator
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * ��ָoffer
 *
 * ��Ŀ����
дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�

˼·��λ����
����������൱��ÿһλ��ӣ��������ǽ�λ��(num1^num2)
���������룬������һλ���൱����ý�λ��(num1&num2)<<1
�����������Ľ�����
 */
public class AddWithoutOperator {

    public int Add(int num1,int num2) {
        while(num2!=0){
            int tmp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = tmp;
        }
        return num1;
    }


}
