package Practice.NiuKeOJ;

import java.util.Arrays;

/**
 * FindNumsApperaOnce
 *
 * @author: Mia Feng
 * @date: 2018/4/10
 *
 * ��ָoffer
 *
 * ��Ŀ����
һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
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


    //num1,num2�ֱ�Ϊ����Ϊ1�����顣������������num1[0],num2[0]����Ϊ���ؽ��
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

        //�ǵô������һλ�����
        if(nSize>=2 && array[nSize-1]!=array[nSize-2])
            tmp[nInd] = array[nSize-1];

        num1[0] = tmp[0];
        num2[0] = tmp[1];
    }

}
