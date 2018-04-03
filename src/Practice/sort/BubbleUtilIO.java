package Practice.sort;

import Practice.MyUtilIO;

/**
 * BubbleUtilIO
 *
 * @author Mia Feng
 * @date 2018/3/25
 *
 * ð�ݵ�˼�뻹�ǱȽϼ򵥵ġ�������һֱ����Ȼ�󿴵�������˳��ľͽ����ͺ���
 */
public class BubbleUtilIO extends MyUtilIO {

    public static void main(String[] args){
        int[] arr = {5,2,4,6,1,3};

        System.out.println("Ascent");
        solutionAscent(arr);
        printArray(arr);

        System.out.println("\nDescent");
        solutionDescent(arr);
        printArray(arr);
    }

    public static void solutionAscent(int[] arr){
        for(int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    int nTemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = nTemp;
                }
            }
        }
    }

    public static void solutionDescent(int[] arr){

        for (int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    int nTemp = arr[i];

                    arr[i] = arr[j];
                    arr[j] = nTemp;
                }
            }
        }

    }

}
