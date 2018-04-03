package Practice.NiuKeOJ;

/**
 * FindMinofCircleArray
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * *��ָoffer
 *
 * ��Ŀ����
��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��

 ����⻹�ǱȽϼ򵥵ģ�ֻҪץס�������ߵ���СֵΪ�����ˣ��ұߵ���СֵΪ�����˾Ϳ���
 �����Ļ���һ��flag����¼�Ϳ����ˡ���������һ���ȵ�ǰ��¼����Сֵ���ֵ���Ϳ�������ѭ����

 */
public class FindMinofCircleArray {
    public class Solution {
        public int minNumberInRotateArray(int [] array) {
            if(array.length==0)
                return 0;
            int nResult = Integer.MAX_VALUE;
            boolean isDescentFlag = true;
            for(int i=array.length-1; i>=0; i--){
                if(!isDescentFlag)
                    break;
                if(array[i] < nResult)
                    nResult = array[i];
                if(array[i] > nResult)
                    isDescentFlag = false;
            }
            return nResult;
        }
    }
}
