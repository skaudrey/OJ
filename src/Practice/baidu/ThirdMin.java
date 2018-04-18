package Practice.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ThirdMin
 *
 * @author: Mia Feng
 * @date: 2018/4/18
 *
 * �ȶ�����ȥ�̳���һ��ñ�ӣ��̳�����N��ñ�ӣ���Щñ�ӵļ۸������ͬ���ȶ�������һ���۸�������˵�ñ�ӣ�
 * �ʵ������˵�ñ�Ӽ۸��Ƕ��٣�
��������:
��������һ��������N��N <= 50��������������N������ʾÿ��ñ�ӵļ۸񣨼۸��������������С�ڵ���1000��

�������:
������ڵ������˵�ñ�ӣ����������۸��Ƕ��٣��������-1

��������1:
10
10 10 10 10 20 20 30 30 40 40

�������1:
30
 */
public class ThirdMin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nSize = sc.nextInt();

        int[] A = new int[nSize];

        for(int i = 0;i<nSize;i++){

            A[i]  = sc.nextInt();

        }

        Arrays.sort(A);

        int nResult = A[0];
        int nK = 1;

        for(int i = 0; i<nSize; i++){
            if(nK==3)
                break;

            if(A[i]>nResult){
                nK++;
                nResult = A[i];
            }
        }

        System.out.println(nK==3?nResult:-1);
    }


}
