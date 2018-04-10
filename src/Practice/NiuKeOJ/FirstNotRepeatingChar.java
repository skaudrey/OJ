package Practice.NiuKeOJ;



import java.util.HashMap;

/**
 *
 * FirstNotRepeatingChar
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * 题目描述
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置

 用hashmap嘛？？

 AC了

 但是注意要判断字符串为空
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args){
        int nResult = FirstNotRepeatingChar("AABBCCDDDGFE");

        System.out.println(nResult);
    }

    public static int FirstNotRepeatingChar(String str) {

        if(str.length()==0 || str==null)
            return -1;
        if(str.length()==1)
            return 0;

        char[] array = str.toCharArray();

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i< array.length; i++){
            Integer nTmp = map.get(array[i]);

            if(nTmp==null)
                map.put(array[i],1);

            else
                map.put(array[i],++nTmp);

        }

        for(int i = 0; i<array.length; i++){
            int nFreq = map.get(array[i]);
            if(nFreq==1)
                return i;
        }
        return 0;
    }

}
