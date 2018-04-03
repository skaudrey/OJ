package Practice.NiuKeOJ;

/**
 * StringBufferReplaceBlank
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 *
 * 剑指offer
 *
 * 题目描述
请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
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
