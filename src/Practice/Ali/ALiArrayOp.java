package Practice.Ali;

/**
 * ALiArrayOp
 *
 * @author Mia Feng
 * @date 2018/3/22
 *
 * ������������Ϊ n ( 0 < n <= 8 ) �����ִ� (�� 1 �� 9 ����)������ϣ���Ե�һ�����ִ���һϵ�����²�����
1. �����ִ���ĳһλ�� 1
2. �����ִ���ĳһλ�� 1
3. �������ִ��������������ֵ�λ��
����ʹ�õ�һ�����ִ���ɵڶ������ִ�������������Ҫ���ٴβ���.
����:
����������У�ÿ��һ�����ִ�(������ȣ����Ҷ� <= 8)
���:
������ٲ�������
���뷶��:
142
251
�������:
2
 */
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class ALiArrayOp {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);
        int nOpsNum = 0;
        int nExchange = 0;
//        int nAdd = 0;
        for(int i=0; i < str1.length; i++){
            if(str1[i]==str2[i])
                nExchange++;
            else
                nOpsNum += Math.abs(str1[i]-str2[i]);
        }

        nOpsNum += nExchange/2;

        System.out.println(nOpsNum);

    }

}
