package Practice.NiuKeOJ;

/**
 * RoateStrLeft
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * ��ָoffer
 *
 * ��Ŀ����
    �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
    ����һ���������ַ�����S���������ѭ������Kλ������������
    ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 */
public class RoateStrLeft {

    public static void main(String[] args){
        String str = "abcXYZdef";
        String result = LeftRotateString(str,3);
        System.out.println(result);
    }

    //�ǵô���մ�
    public static String LeftRotateString(String str,int n) {
        if(str==null || str.length()==0)
            return "";

        String result = str.substring(n);
        result += str.substring(0,n);

        return result;
    }

}
