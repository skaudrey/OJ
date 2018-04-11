package Practice.NiuKeOJ;

import java.util.Arrays;
import java.util.HashMap;

/**
 * IsContinuous
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 *
 * ��ָoffer
 * ��Ŀ����
LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,
����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
LL����ȥ��������Ʊ����
����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 */
public class IsContinuous {

    public static void main(String[] args){
        int[] array = {1,2,3,4,6};

        System.out.println(isContinuous(array) );
    }

    //Again, �ǵô���մ�
    public static boolean isContinuous(int [] numbers) {
        boolean flag = true;

        if(numbers.length==0 || numbers == null)
            return false;

        Arrays.sort(numbers);
        int nMax = numbers[numbers.length-1];
        int nMin = 0,i = 0;
        while(i<numbers.length&&numbers[i]==0  )
            i++;

//        if(i==numbers.length)
//            i = 0;

        nMin = numbers[i];

        while(i<numbers.length-1){
            if(numbers[i]==numbers[i+1])
                flag = false;
            i++;
        }
        return flag&&(nMax-nMin<5);
    }
}