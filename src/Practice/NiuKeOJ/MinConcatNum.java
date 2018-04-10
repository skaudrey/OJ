package Practice.NiuKeOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * MinConcatNum
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * 剑指offer
 *
 * 题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

 重点在于自定义一个排序方法，确定数组中那些应该在前哪些应该在后，这样排序完后直接concat就好

  排序规则如下：
?* 若ab > ba 则 a > b，
?* 若ab < ba 则 a < b，
?* 若ab = ba 则 a = b；
?* 解释说明：
    比如 "3" < "31" 但是 "331" > "313"，所以要将二者拼接起来进行比较
 */
public class MinConcatNum {

    public static void main(String[] args){

        int[] array = {3,32,321};

        String result = PrintMinNumber(array);

        System.out.println(result);
    }

    public static String PrintMinNumber(int [] numbers) {
        String s = "";

        ArrayList<String> list = new ArrayList<>();

        if(numbers==null && numbers.length==0)
            return s;

        for(int i = 0; i<numbers.length; i++)
            list.add(Integer.toString(numbers[i]));


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String str1 = o1 + o2;
                String str2 = o2 + o1;

                return str1.compareTo(str2);
            }
        });

        for(int i=0; i<list.size(); i++){
            s += list.get(i);
        }
        return s;
    }

}
