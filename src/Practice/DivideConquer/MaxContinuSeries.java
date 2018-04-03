package Practice.DivideConquer;

import Practice.MyUtilIO;

/**
 * MaxContinuSeries
 *
 * @author Mia Feng
 * @date 2018/3/25
 *
 * Reference: 《算法导论》 page38
 * Problem:    已知股票未来每日的价格，求买进卖出点
 * Transform： 数学真是神奇：暴力法要O(n^2)，将原始序列转换为每日价格相对前一日的变动序列，
 * 然后求解最大连续公共子序列即可得到最大收益，对应的索引值为买卖点
 *
 *
 * Algorithm: Divide and conquer
 *
 * 最大连续子序列存在的位置只可能有三种情况，一种是在左子序列，一种是在右子序列，还有一种是跨越中间点的交叉子序列，递归查找比较即可
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
