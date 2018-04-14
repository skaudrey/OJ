package Practice.NiuKeOJ;

/**
 * parseInt
 *
 * @author: Mia Feng
 * @date: 2018/4/12
 *
 * ��ָoffer
 *
 * ��Ŀ����
��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
��������:
����һ���ַ���,����������ĸ����,����Ϊ��
�������:
����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
ʾ��1
����
+2147483647
1a33
���
2147483647
0

�߽�������
�������� ���
���ַ���
ֻ��������
����������
�����־���


 �ð��ҵķ����ɡ��������
 */
public class parseInt {

    public static void main(String[] args){
        String str = "+";

        StrToInt(str);
    }

    public static int StrToInt(String str) {
        if(str==null || str.length()==0)
            return 0;

        char[] array = str.toCharArray();
        int i = 0;
        int nLen = str.length();
        boolean isLeagal = true;
        while(i<nLen ){
            if(array[i]>'9')
                isLeagal = false;
            i++;
        }

        if(!isLeagal)
            return 0;

        int nBegin = 0;

        boolean isPositive = true;
        if(array[0]<'0'){
            nBegin = 1;
            if(array[0]=='-')
                isPositive = false;
        }
        else{
            isPositive = true;
            nBegin = 0;
        }

        String sTmp  = str.substring(nBegin);
        if(sTmp==null || sTmp.length()==0)
            return 0;
        int tmp = Integer.parseUnsignedInt(str.substring(nBegin));

        if(isPositive )
            return tmp;
        else
            return tmp*-1;

    }
}

