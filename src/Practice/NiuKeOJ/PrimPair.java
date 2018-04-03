package Practice.NiuKeOJ;

import java.util.Scanner;

/**
 * PrimPair
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��Ŀ����
����һ������������д��������ж��ٶ������ĺ͵���������������������������������ֵС��1000��
�磬����Ϊ10, ����Ӧ��������Ϊ2�����������������ĺ�Ϊ10,�ֱ�Ϊ(5,5),(3,7)��
��������:
�������һ������n,(3 �� n < 1000)
�������:
�������
ʾ��1
����
10
���
2

 ����һ��AC������˼���ȼ�������Ϊ�������������ı�����¼Ϊ����������ʡ������
 *
 */
public class PrimPair {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] primFlags = new int[1000];    // 0 for prim, 1 for not prim

        for(int i = 2; i < 1000 ; i++){
            for(int j = 2; i*j < 1000; j++){
                if(primFlags[i]==0)
                    primFlags[i*j] = 1;    //�����ı�������Ϊ������
            }
        }

        //�ռ任ʱ�䣬˼·����

        int nResult = 0;

        for(int i=2; i<= num/2; i++){
            if(primFlags[i]==0 && primFlags[num-i]==0)  //�о�����Ҳ������DP��˼��
                nResult++;
        }
        System.out.println(nResult);
    }
}