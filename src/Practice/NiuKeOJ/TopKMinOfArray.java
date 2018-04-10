package Practice.NiuKeOJ;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TopKMinOfArray
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * 剑指offer：
 * 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class TopKMinOfArray {

    public static void main(String[] args){

        int[] array = {1,2,3,2,2,2,5,4,2};

        Arrays.sort(array);

        for(int i = 0; i<array.length; i++){
            System.out.print(array[i]);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length)
            return result;


        Arrays.sort(input);

        for(int i = 0; i<k && i<input.length;i++){
            result.add(input[i]);
        }
        return result;
    }

}
