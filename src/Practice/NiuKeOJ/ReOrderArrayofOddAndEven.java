package Practice.NiuKeOJ;

/**
 * ReOrderArrayofOddAndEven
 *
 * @author Mia Feng
 * @date 2018/3/29
 *
 * 剑指offer
 *
 *
 * 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。


 思路是按顺序遍历原数组，并存储在一个temp数组中。
偶数从数组末尾开始存，奇数从数组头开始存。
 这样存完以后后半部分的偶数的顺序与原数组相反，拷贝的时候逆回去就好了
 */
public class ReOrderArrayofOddAndEven {

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7};
        reOrderArray(arr);
    }

    public static void reOrderArray(int [] array) {
        int[] copyArray = new int[array.length];

        int i = 0, j = array.length-1;

        for(int k=0; k< array.length; k++){
            if(array[k]%2 == 0)
                copyArray[j--] = array[k];
            else
                copyArray[i++] = array[k];
        }

        int nLen = array.length-1;
        for(int k = 0; k< array.length; k++){
            if(k>=i)
                array[k] = copyArray[nLen--];
            else
                array[k] = copyArray[k];
        }

    }
}