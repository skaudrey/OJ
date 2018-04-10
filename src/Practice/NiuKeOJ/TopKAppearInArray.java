package Practice.NiuKeOJ;

import java.util.HashMap;

/**
 * TopKAppearInArray
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * ��ָoffer
 *
 * ��Ŀ����
��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
��������������0��

 1. ��hashmap
 2. ����������λ�����ֵĴ���
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
            if(tmp+1>array.length/2)    //ע����tmp+1>array.length/2
                return array[i];
        }
        return nResult;
    }
}
