package Practice.sort;

import Practice.MyUtilIO;

/**
 * MergeUtilIO
 *
 * @author Mia Feng
 * @date 2018/3/25
 *
 * 分治算法
 * 归并排序的思想是分支
 * 递归计算：算法的最简子问题是递归触底时对应的基本情况
 * 即数组长度为1的情况
 * 调试看一下也的确是这样的，现在左半边递归至触底（左半边分左右：索引0，1归并，索引2,3归并）；再到右半边递归至触底（分左右：索引4,5归并，索引6，7归并）；最后归并左右半边
 */
public class MergeUtilIO extends MyUtilIO {
    public static void main(String[] args){
        int[] arr = {5,2,4,6,1,3,2,6};

        System.out.println("Ascent");
        solution(arr, true); //true for ascent
        printArray(arr);

        System.out.println("\nDescent");//false for descent
        solution(arr, false);
        printArray(arr);

    }

    public static void solution(int[] arr, boolean isAscent){
        mergeSort(arr, 0, arr.length - 1, isAscent);
    }

    public static void mergeSort(int[] arr, int left, int right, boolean isAscent){
        //To understand the idea of recursion, you'd better debug it.
        if(left<right){
            int mid = (left+right)/2;

            mergeSort(arr,left,mid,isAscent);
            mergeSort(arr,mid+1,right,isAscent);
            merge(arr,left,mid,right,isAscent);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right, boolean isAscent){
        int[] tmp = new int[arr.length];

        int i = left,j = middle+1;
        int m = middle, n = right;
        int k = 0;

        //choose the minimum one from left array and right array and put into array tmp
        while (i<=m && j<=n){
            if(isAscent){
                if(arr[i]<arr[j])
                    tmp[k++] = arr[i++];
                else
                    tmp[k++] = arr[j++];
            }
            else {
                if(arr[i]>arr[j])
                    tmp[k++] = arr[i++];
                else
                    tmp[k++] = arr[j++];
            }
        }

        //copy the rest
        while (i<=m)
            tmp[k++] = arr[i++];
        while (j<=n)
            tmp[k++] = arr[j++];

        // update origin array
        for(i=0; i<k; i++){
            arr[left+i] = tmp[i];
        }
    }

}
