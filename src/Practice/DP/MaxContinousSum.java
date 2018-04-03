package Practice.DP;

/**
 * MaxContinousSum
 *
 * @author Mia Feng
 * @date 2018/4/2
 *
 *
 * 可以分治，也可以动态规划，分治的实现算法导论有提到，用到了类似归并排序的方法
 */
public class MaxContinousSum {

    public static void main(String[] args){
        int[] arr = { 1, -3, 7, 8, -4, 12, -10, 6 };
        int nSum = -1;

        int nBegin = 0;
        int nEnd = 0;
        int nTempSum = 0;

        for(int i=0; i<arr.length; i++){
            if(nTempSum>0){
                nTempSum += arr[i];

            }
            else{
                nTempSum = arr[i];
                nBegin = i;
            }
            if(nTempSum>nSum){
                nSum = nTempSum;
                nEnd = i;
            }
        }

        System.out.println(nSum);
        System.out.println(nBegin);
        System.out.println(nEnd);
    }
}
