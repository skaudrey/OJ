package Practice.NiuKeOJ;

/**
 * StringBufferReplaceBlank
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 *
 * ��ָoffer
 *
 * ��Ŀ����
��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class StringBufferReplaceBlank {
    public class Solution {
        public String replaceSpace(StringBuffer str) {

            String temp = str.toString();

            temp.replaceAll(" ","%20");

            return temp;
        }
    }


}
