package Practice.DP;

/**
 * MaxContinuousMultiple
 *
 * @author Mia Feng
 * @date 2018/4/2
 */
public class MaxContinuousMultiple {

    public static void main(String[] args){
        int[] arr = { 1, -3, 7, 8, -4, 12, -10, 6 };
//        int nSum = -1;

        int nBegin = 0;
        int nEnd = 0;

        double dResult = 1.0;
        double dMax = 1.0;
        double dMin = 1.0;
        double dTempMax = 1.0;
        double dTempMin = 1.0;

        for(int i=0; i<arr.length; i++){
            dTempMax = Math.max(arr[i],Math.max(arr[i]*dMax,arr[i]*dMin));
            dTempMin = Math.min(arr[i], Math.min(arr[i] * dMax, arr[i] * dMin));

            dMax = dTempMax;
            dMin = dTempMin;

            dResult = Math.max(dTempMax,dTempMin);
        }

        System.out.println(dResult);

    }

}
