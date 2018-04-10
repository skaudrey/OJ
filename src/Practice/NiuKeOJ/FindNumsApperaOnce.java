package Practice.NiuKeOJ;

import java.util.Arrays;

/**
 * FindNumsApperaOnce
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * 剑指offer
 *
 * 题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsApperaOnce {

    public static void main(String[] args){

        int[] result1 = new int[1];
        int[] result2 = new int[1];
        int[] array = {2,4,3,6,3,2,5,5};

        FindNumsAppearOnce(array,result1,result2);

        System.out.println(result1[0]);
        System.out.println(result2[0]);
    }


    //num1,num2分别为长度为1的数组。传出参数；将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);

        int[] tmp = new int[2];
        int nInd = 0;

        int nSize = array.length;

        for(int i = 0; i<nSize-1; i = i+2){
            if(array[i]!=array[i+1]){
                tmp[nInd++] = array[i];
                i--;
            }
        }

        //记得处理最后一位的情况
        if(nSize>=2 && array[nSize-1]!=array[nSize-2])
            tmp[nInd] = array[nSize-1];

        num1[0] = tmp[0];
        num2[0] = tmp[1];
    }

}
