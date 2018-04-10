package Practice.NiuKeOJ;

import java.util.HashMap;

/**
 * TopKAppearInArray
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * 剑指offer
 *
 * 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
如果不存在则输出0。

 1. 用hashmap
 2. 排序后计算中位数出现的次数
 */
public class TopKAppearInArray {

    public static void main(String[] args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        int nResult = MoreThanHalfNum_Solution(array);
        System.out.println(nResult);
    }

    public static int MoreThanHalfNum_Solution(int [] array){
        int nResult = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<array.length; i++){
            Integer tmp = map.get(array[i]);
            if(tmp==null){
                map.put(array[i],1);
                tmp = 1;
            }else{
                map.put(array[i],tmp+1);
            }
            if(tmp+1>array.length/2)    //注意是tmp+1>array.length/2
                return array[i];
        }
        return nResult;
    }
}
