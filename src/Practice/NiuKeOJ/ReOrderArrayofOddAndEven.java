package Practice.NiuKeOJ;

/**
 * ReOrderArrayofOddAndEven
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * ��ָoffer
 *
 *
 * ��Ŀ����
����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
����֤������������ż����ż��֮������λ�ò��䡣


 ˼·�ǰ�˳�����ԭ���飬���洢��һ��temp�����С�
ż��������ĩβ��ʼ�棬����������ͷ��ʼ�档
 ���������Ժ��벿�ֵ�ż����˳����ԭ�����෴��������ʱ�����ȥ�ͺ���
 */
public class ReOrderArrayofOddAndEven {

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7};
        reOrderArray(arr);
    }

    public static void reOrderArray(int [] array) {
        int[] copyArray = new int[array.length];

        int i = 0, j = array.length-1;

        for(int k=0; k< array.length; k++){
            if(array[k]%2 == 0)
                copyArray[j--] = array[k];
            else
                copyArray[i++] = array[k];
        }

        int nLen = array.length-1;
        for(int k = 0; k< array.length; k++){
            if(k>=i)
                array[k] = copyArray[nLen--];
            else
                array[k] = copyArray[k];
        }

    }
}