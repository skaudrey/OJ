package Practice.NetBase;

import java.text.Format;
import java.util.Scanner;

/**
 * StrMeanLen
 *
 * @author Mia Feng
 * @date 2018/3/27
 *
 * һ����Сд��ĸ��ɵ��ַ������Կ���һЩͬһ��ĸ�������Ƭ��ɵġ�����,"aaabbaaac"����������Ƭ��ɵ�:'aaa','bb','c'��ţţ���ڸ���һ���ַ���,���������������ַ�����������Ƭ��ƽ�������Ƕ��١�

��������:
�������һ���ַ���s,�ַ���s�ĳ���length(1 �� length �� 50),sֻ��Сд��ĸ('a'-'z')


�������:
���һ������,��ʾ������Ƭ��ƽ������,�������뱣����λС����

��������ʾ: s = "aaabbaaac"
������Ƭ��ƽ������ = (3 + 2 + 3 + 1) / 4 = 2.25

��������1:
aaabbaaac

�������1:
2.25
 */
public class StrMeanLen {
    public static void main(String[] args){
//        int[] coins = {1,3,5};
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        String s = "" ;
        int nStr = 1;
        int nSize = s.length();
        char nTemp = s.charAt(0);
        for(int i = 0; i < nSize; i++){
            if(nTemp!=s.charAt(i)){
                nStr++;
                nTemp = s.charAt(i);
            }
        }

        System.out.printf("%.2f",nSize/(nStr*1.0));
    }

}
