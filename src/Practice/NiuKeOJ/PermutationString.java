package Practice.NiuKeOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * PermutationString
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * 剑指offer
 *
 * 字符串全排列
 *
 * 回溯法，递归完成，递归出口为字符串长度为1时
 *
 * 回溯问题的两个注意点：
 * 1.   递归出口
 * 2.   递归传出去了什么递归结束后要保证传出去的不变
 *
 * 题目：
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

注意：字典序的话还要求对最后的结果做排序

 去重全排思路：
 从第一个字符起，每个字符分别与它后面非重复出现的字符交换
 */
public class PermutationString {

    public static void main(String[] args){
        String str = "abb";

        ArrayList<String> result = Permutation(str);

        for(int i = 0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();

        if(str!=null && str.length()>0){
            permutationHelper(list,str.toCharArray(),0);
            Collections.sort(list); //按字典序
        }
            return list;
        }

        public static void permutationHelper(ArrayList<String> list, char[] array, int nBegin){    //从begin开始全排列

            if(nBegin == array.length-1)    //递归出口
                list.add(String.valueOf(array));
            else{
                //这个else块的作用有1：交换第一个位置的字符，比如第一个位置的全排列字符串全部打印后

                //就把第一个字符和第二个交换；2：递归打印每次第一个字符串的全排列字符串；3：每次

//递归的时候都会传递一个字符串数组，最后三行代码就是控制这个字符串数组不变，意思就是

//什么样子传递出去，就什么样子传递回来，一点不能变化，因为最后三行代码不是用于改变

//字符串数组的
                Set<Character> set = new HashSet<>();

                for(int j = nBegin; j<array.length; j++){
                    if(j==nBegin || !set.contains(array[j])){   //用set来判断后面是否有重复字符
                        set.add(array[j]);
                        swap(array, nBegin, j);   //将开始的字符与后面不重复的字符交换
                        permutationHelper(list,array,nBegin+1);
                        swap(array,nBegin,j);   //为防止重复的情况，还需要将begin处的元素重新换回去
                    }
                }
            }
        }

        public static void swap(char[] array,int i, int j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

        }


}
