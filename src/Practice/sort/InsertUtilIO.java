package Practice.sort;

import Practice.MyUtilIO;

/**
 * InsertUtilIO
 *
 * @author Mia Feng
 * @date 2018/3/25
 */
public class InsertUtilIO extends MyUtilIO {

    public static void main(String[] args){
        int[] arr = {5,2,4,6,1,3};

        System.out.println("Ascent");
        solutionAscent(arr);
        printArray(arr);

        System.out.println("\nDescent");
        solutionDescent(arr);
        printArray(arr);
    }
//
//    public static void solutionAscent(int[] arr){
//        for(int j=1; j<arr.length; j++){
//            int key = arr[j];
//            int i = j-1;
//            while (i>=0 && arr[i]>key){ //遍历在key之前的数，i>=0保证不越界； arr[i]>key 寻找比key大的数并交换位置
//                arr[i+1] = arr[i];//比key大的数都往后丢
//                i -= 1;
//            }
//            //遍历直到找到比key小的数，此时这个索引值的后一位就是插入key的位置
//            arr[i+1] = key;
//        }
//    }


    public static void solutionAscent(int[] arr){
        for(int j=1; j<arr.length; j++){
            int key = arr[j];
            int i = j-1;    //从主元前一位开始遍历

            //遍历找到比主元小的那个位置，把主元插入到那个位置之后的索引。如果都比主元大，就都往后挪
            while (i>=0 && arr[i]>key){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
    }

    public static void solutionDescent(int[] arr){
        for(int j=1; j<arr.length; j++){
            int key = arr[j];
            int i = j-1;

            while (i>=0 && arr[i]<key){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
    }
}
