package Practice.DivideConquer;

import Practice.MyUtilIO;

/**
 * MaxContinuSeries
 *
 * @author Mia Feng
 * @date 2018/3/25
 *
 * Reference: ���㷨���ۡ� page38
 * Problem:    ��֪��Ʊδ��ÿ�յļ۸������������
 * Transform�� ��ѧ�������棺������ҪO(n^2)����ԭʼ����ת��Ϊÿ�ռ۸����ǰһ�յı䶯���У�
 * Ȼ���������������������м��ɵõ�������棬��Ӧ������ֵΪ������
 *
 *
 * Algorithm: Divide and conquer
 *
 * ������������д��ڵ�λ��ֻ���������������һ�������������У�һ�������������У�����һ���ǿ�Խ�м��Ľ��������У��ݹ���ұȽϼ���
 */






public class MaxContinuSeries extends MyUtilIO {

    public class SubArray{
        public int _low;
        public int _high;
        public int[] _array;

        public SubArray(int nLen){
            _low = -1;
            _high = -1;
            _array = new int[nLen];
        }

        public void setArray(int[] array){
            for (int i = 0; i<array.length; i++)
                _array[i] = array[i];
        }
    }

    public static void diff(int[] source, int[] diffArray){
        for(int i=1; i< source.length; i++){
            diffArray[i-1] = source[i]-source[i-1];
        }
    }

    public static void maxCrossingSubArr(int[] arr, int left, int mid, int right){

    }

    public SubArray maxContinuousSubArr(int[] arr, int left, int right){
        SubArray temp = new SubArray(arr.length);

        return temp;
    }

    public static void main(String[] args){
        int[] socketPrice = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};

        int[] diffArray = new int[socketPrice.length-1];

        MaxContinuSeries solver = new MaxContinuSeries();

        solver.maxContinuousSubArr(diffArray,0,diffArray.length-1);


        printArray(diffArray);


    }

}
