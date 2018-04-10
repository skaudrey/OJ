package Practice.NiuKeOJ;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TopKMinOfArray
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * ��ָoffer��
 * ��Ŀ����
����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
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
