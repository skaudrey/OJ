package Practice.Any;

/**
 * compStrLen
 *
 * @author Mia Feng
 * @date 2018/3/22
 */

/**
 * ����������������
 * �ַ�������
 ʱ�����ƣ�C/C++���� 2000MS���������� 4000MS
 �ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
 ��Ŀ������
 ����������ͬ���ȵ����ַ� a �� b ���ɵ��ַ������������ǵľ���Ϊ��Ӧλ�ò�ͬ���ַ����������紮��aab���봮��aba���ľ���Ϊ 2������ba���봮��aa���ľ���Ϊ 1������baa���ʹ���baa���ľ���Ϊ 0��������������ַ��� S �� T������ S �ĳ��Ȳ�С�� T �ĳ��ȡ�������|S|���� S �ĳ��ȣ�|T|���� T �ĳ��ȣ���ô�� S ��һ����|S|-|T|+1 ���� T ������ͬ���Ӵ�����������Ҫ���� T ������Щ|S|-|T|+1 ���Ӵ��ľ���ĺ͡�
 ����
 ��һ�а���һ���ַ��� S��

 �ڶ��а���һ���ַ��� T��

 S �� T �����ַ� a �� b ��ɣ�1 �� |T| �� |S| ��105 ��

 ���
 �����Ӧ�Ĵ𰸡�


 ��������
 aab

 aba

 �������
 2
 * **/
import java.util.Scanner;

public class compStrLen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s_str = sc.nextLine();
            String t_str = sc.nextLine();

            int result = 0;

            for(int i = 0; i<=s_str.length()-t_str.length();i++){
                String str1 = s_str.substring(i,i+t_str.length());

                result += getLen(str1,t_str);
            }
            System.out.println(result);
        }
    }

    public static int getLen(String str1, String str2){

        int nLen = 0;
        for(int i = 0; i< str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
                nLen++;
        }
        return nLen;
    }
}
