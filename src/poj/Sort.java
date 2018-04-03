package poj;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 各种排序算法
 * 排序大的分类可以分为两种：内排序和外排序。在排序过程中，全部记录存放在内存，则称为内排序，如果排序过程中需要使用外存，则称为外排序。下面讲的排序都是属于内排序。

　　内排序可以分为以下几类：

　　(1)、插入排序：直接插入排序、二分法插入排序、希尔排序。

　　(2)、选择排序：简单选择排序、堆排序。

　　(3)、交换排序：冒泡排序、快速排序。

　　外排序可以分为一下几类（既使用内部存储也使用外部存储，内存不够时建议使用）：

　　(4)、归并排序

　　(5)、基数排序

稳定性：就是能保证排序前两个相等的数据其在序列中的先后位置顺序与排序后它们两个先后位置
顺序相同。再简单具体一点，如果A i == A j，Ai 原来在 Aj 位置前，排序后 Ai  
仍然是在 Aj 位置前。

　　不稳定：简单选择排序、快速排序、希尔排序、堆排序不是稳定的排序算法

　　稳定：冒泡排序、直接插入排序、二分法插入排序，归并排序和基数排序都是稳定的排序算法。

平均时间复杂度

　　O(n^2):直接插入排序，简单选择排序，冒泡排序。

　　在数据规模较小时（9W内），直接插入排序，简单选择排序差不多。
当数据较大时，冒泡排序算法的时间代价最高。
性能为O(n^2)的算法基本上是相邻元素进行比较，基本上都是稳定的。

　　O(nlogn):快速排序，归并排序，希尔排序，堆排序。

　　其中，快排是最好的， 其次是归并和希尔，堆排序在数据量很大时效果明显。
排序算法的选择

　　1.数据规模较小

  　　（1）待排序列基本序的情况下，可以选择直接插入排序；

  　　（2）对稳定性不作要求宜用简单选择排序，对稳定性有要求宜用插入或冒泡

　　2.数据规模不是很大

　　（1）完全可以用内存空间，序列杂乱无序，对稳定性没有要求，快速排序，此时要付出log（N）的额外空间。

　　（2）序列本身可能有序，对稳定性有要求，空间允许下，宜用归并排序

　　3.数据规模很大

   　　（1）对稳定性有求，则可考虑归并排序。

    　　（2）对稳定性没要求，宜用堆排序

　　4.序列初始基本有序（正序），宜用直接插入，冒泡
 * **/
/**
 * 下面所有算法都是按升序排列
 * **/
public class Sort {
	/**
     * 直接插入排序
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置
     * （从后向前找到合适位置后），直到全部插入排序完为止
     * @param a
     * @return
     */
    public static int[] zhiJieChaRu(int[] a) {
        // 直接插入排序
        for (int i = 1; i < a.length; i++) {
            // 待插入元素
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
        return a;
    }
    
    /**
     * 二分插入排序
     * 二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，
     * 这里是按二分法找到合适的位置，可以减少比较的次数。
     * 停止条件：high<low
     * 算法的移动次数与直接插入排序算法的相同，最坏的情况为n2/2，最好的情况为n，平均移动次数为O(n2)。
     * @param a
     * @return
     */
    public static int[] erFenChaRu(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //后面的数据右移
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            if (left != i) {
                a[left] = temp;
            }
        }
        return a;
    }
    
    
    /**
     * 希尔排序
     * 基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。
     * 先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)
     * 即所有记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法。
     * @param a
     * @return
     */
    public static int[] xiErSort(int[] a) {
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        return a;
    }
    
    
    /**
     * 直接选择排序
     * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     * @param a
     * @return
     */
    public static int[] zhiJieXuanZe(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int n = i; // 最小数的索引
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) { // 找出最小的数
                    min = a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;

        }
        return a;
    }
    
    
    
    
    /**
     * 堆排序
     * @param a
     * @return
     */
    public static int[] heapSort(int a[]) {
        int arrayLength = a.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(a, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
        }
        return a;
    }
    // 对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }
    // 交换
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    
    
    /**
     * 冒泡排序。
     * @param a
     * @return
     */
    public static int[] maoPaoSort(int a[]) {
        //冒泡排序
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j<a.length-i-1; j++){
                //这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
    
    /**
     * 快速排序。
     * @param a
     * @return
     */
    public static int[] quick(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) { // 如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }
    public static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];// 基准元素
        while (low < high) {
            // 找到比基准元素小的元素位置
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }
    
    /**
     * 归并排序。
     * 
     * @param a
     * @return
     */
    public static int[] guiBingSort(int[] a) {
        mergeSort(a, 0, a.length-1);
        return a;
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            // 对左边进行递归
            mergeSort(a, left, middle);
            // 对右边进行递归
            mergeSort(a, middle + 1, right);
            // 合并
            merge(a, left, middle, right);
        }
    }

    public static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[a.length];
        int mid = middle + 1; // 右边的起始位置
        int tmp = left;
        int third = left;
        while (left <= middle && mid <= right) {
            // 从两个数组中选取较小的数放入中间数组
            if (a[left] <= a[mid]) {
                tmpArr[third++] = a[left++];
            } else {
                tmpArr[third++] = a[mid++];
            }
        }
        // 将剩余的部分放入中间数组
        while (left <= middle) {
            tmpArr[third++] = a[left++];
        }
        while (mid <= right) {
            tmpArr[third++] = a[mid++];
        }
        // 将中间数组复制回原数组
        while (tmp <= right) {
            a[tmp] = tmpArr[tmp++];
        }
    }
    
    /**
     * 基数排序
     * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     * **/
    
    public static int[] jiShuSort(int[] array) {
        //找到最大数，确定要排序几趟
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(max<array[i]){
                max = array[i];
            }
        }
        //判断位数
        int times = 0;
        while(max>0){
            max = max/10;
            times++;
        }
        //建立十个队列
        ArrayList<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList queue1 = new ArrayList();
            queue.add(queue1);
        }
        //进行times次分配和收集
        for (int i = 0; i < times; i++) {
            //分配
            for (int j = 0; j < array.length; j++) {
                int x = array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
                ArrayList queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x,queue2);
            }
            //收集
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while(queue.get(j).size()>0){
                    ArrayList<Integer> queue3 = queue.get(j);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
        return array;
    }

    /**
     * main function
     * **/
    public static void main(String[] args) {
        //输入参数
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String inStr = in.nextLine();
            String[] str = inStr.split(" ");
            int a[] = new int[str.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            
            //获得结果
            //int[] results = zhiJieChaRu(a);
            int[] results = null;
            
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < results.length; i++) {
                result.append(results[i]).append(",");
            }
            //删除最后一个逗号
            if (result.length() > 0) {
                result.deleteCharAt(result.length() -1);
            }
            System.out.println(result);
            
        }
    }
}
