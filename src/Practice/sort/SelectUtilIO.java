package Practice.sort;

import Practice.MyUtilIO;

/**
 * SelectUtilIO
 *
 * @author Mia Feng
 * @date 2018/3/25
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 */
public class SelectUtilIO extends MyUtilIO {

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

        for (int i=0; i<arr.length; i++){
            int key = arr[i];
            int keyIndex = i;

            for (int j=i+1; j<arr.length; j++){
                if(arr[j]<key){ //查找最小的
                    keyIndex = j;
                    key = arr[j];
                }
            }
            arr[keyIndex] = arr[i];
            arr[i] = key;
        }

    }

    public static void solutionDescent(int[] arr){
        for(int i=0; i<arr.length; i++){
            int key = arr[i];
            int keyIndex = i;

            for(int j=i+1;j<arr.length; j++){   //遍历查找最大的
                if(arr[j]>key){
                    key = arr[j];
                    keyIndex = j;
                }
            }
            arr[keyIndex] = arr[i];
            arr[i] = key;
        }
    }

}
