package poj;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ���������㷨
 * �����ķ�����Է�Ϊ���֣������������������������У�ȫ����¼������ڴ棬���Ϊ��������������������Ҫʹ����棬���Ϊ���������潲������������������

������������Է�Ϊ���¼��ࣺ

����(1)����������ֱ�Ӳ������򡢶��ַ���������ϣ������

����(2)��ѡ�����򣺼�ѡ�����򡢶�����

����(3)����������ð�����򡢿�������

������������Է�Ϊһ�¼��ࣨ��ʹ���ڲ��洢Ҳʹ���ⲿ�洢���ڴ治��ʱ����ʹ�ã���

����(4)���鲢����

����(5)����������

�ȶ��ԣ������ܱ�֤����ǰ������ȵ��������������е��Ⱥ�λ��˳������������������Ⱥ�λ��
˳����ͬ���ټ򵥾���һ�㣬���A i == A j��Ai ԭ���� Aj λ��ǰ������� Ai  
��Ȼ���� Aj λ��ǰ��

�������ȶ�����ѡ�����򡢿�������ϣ�����򡢶��������ȶ��������㷨

�����ȶ���ð������ֱ�Ӳ������򡢶��ַ��������򣬹鲢����ͻ����������ȶ��������㷨��

ƽ��ʱ�临�Ӷ�

����O(n^2):ֱ�Ӳ������򣬼�ѡ������ð������

���������ݹ�ģ��Сʱ��9W�ڣ���ֱ�Ӳ������򣬼�ѡ�������ࡣ
�����ݽϴ�ʱ��ð�������㷨��ʱ�������ߡ�
����ΪO(n^2)���㷨������������Ԫ�ؽ��бȽϣ������϶����ȶ��ġ�

����O(nlogn):�������򣬹鲢����ϣ�����򣬶�����

�������У���������õģ� ����ǹ鲢��ϣ�������������������ܴ�ʱЧ�����ԡ�
�����㷨��ѡ��

����1.���ݹ�ģ��С

  ������1���������л����������£�����ѡ��ֱ�Ӳ�������

  ������2�����ȶ��Բ���Ҫ�����ü�ѡ�����򣬶��ȶ�����Ҫ�����ò����ð��

����2.���ݹ�ģ���Ǻܴ�

������1����ȫ�������ڴ�ռ䣬�����������򣬶��ȶ���û��Ҫ�󣬿������򣬴�ʱҪ����log��N���Ķ���ռ䡣

������2�����б���������򣬶��ȶ�����Ҫ�󣬿ռ������£����ù鲢����

����3.���ݹ�ģ�ܴ�

   ������1�����ȶ���������ɿ��ǹ鲢����

    ������2�����ȶ���ûҪ�����ö�����

����4.���г�ʼ�����������򣩣�����ֱ�Ӳ��룬ð��
 * **/
/**
 * ���������㷨���ǰ���������
 * **/
public class Sort {
	/**
     * ֱ�Ӳ�������
     * ÿ����һ��������ļ�¼������˳�����С���뵽ǰ���Ѿ�����������еĺ���λ��
     * ���Ӻ���ǰ�ҵ�����λ�ú󣩣�ֱ��ȫ������������Ϊֹ
     * @param a
     * @return
     */
    public static int[] zhiJieChaRu(int[] a) {
        // ֱ�Ӳ�������
        for (int i = 1; i < a.length; i++) {
            // ������Ԫ��
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // ������temp�������ƶ�һλ
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
     * ���ֲ�������
     * ���ַ����������˼���ֱ�Ӳ���һ����ֻ���Һ��ʵĲ���λ�õķ�ʽ��ͬ��
     * �����ǰ����ַ��ҵ����ʵ�λ�ã����Լ��ٱȽϵĴ�����
     * ֹͣ������high<low
     * �㷨���ƶ�������ֱ�Ӳ��������㷨����ͬ��������Ϊn2/2����õ����Ϊn��ƽ���ƶ�����ΪO(n2)��
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
            //�������������
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
     * ϣ������
     * ����˼�룺��ȡһ��С��n������d1��Ϊ��һ�����������ļ���ȫ����¼�ֳ�d1���顣���о���Ϊd1�ı����ļ�¼����ͬһ�����С�
     * ���ڸ����ڽ���ֱ�Ӳ�������Ȼ��ȡ�ڶ�������d2<d1�ظ������ķ��������ֱ����ȡ������dt=1(dt<dt-l<��<d2<d1)
     * �����м�¼����ͬһ���н���ֱ�Ӳ�������Ϊֹ���÷���ʵ������һ�ַ�����뷽����
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
     * ֱ��ѡ������
     * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������Ȼ����ʣ�µ�������������С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
     * @param a
     * @return
     */
    public static int[] zhiJieXuanZe(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int n = i; // ��С��������
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) { // �ҳ���С����
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
     * ������
     * @param a
     * @return
     */
    public static int[] heapSort(int a[]) {
        int arrayLength = a.length;
        // ѭ������
        for (int i = 0; i < arrayLength - 1; i++) {
            // ����
            buildMaxHeap(a, arrayLength - 1 - i);
            // �����Ѷ������һ��Ԫ��
            swap(a, 0, arrayLength - 1 - i);
        }
        return a;
    }
    // ��data�����0��lastIndex���󶥶�
    public static void buildMaxHeap(int[] data, int lastIndex) {
        // ��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k���������жϵĽڵ�
            int k = i;
            // �����ǰk�ڵ���ӽڵ����
            while (k * 2 + 1 <= lastIndex) {
                // k�ڵ�����ӽڵ������
                int biggerIndex = 2 * k + 1;
                // ���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����
                if (biggerIndex < lastIndex) {
                    // �������ӽڵ��ֵ�ϴ�
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex���Ǽ�¼�ϴ��ӽڵ������
                        biggerIndex++;
                    }
                }
                // ���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
                if (data[k] < data[biggerIndex]) {
                    // ��������
                    swap(data, k, biggerIndex);
                    // ��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }
    // ����
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    
    
    /**
     * ð������
     * @param a
     * @return
     */
    public static int[] maoPaoSort(int a[]) {
        //ð������
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j<a.length-i-1; j++){
                //����-i��Ҫ��ÿ����һ�ζ�������i�������������ȥ�ˣ�û�б�Ҫ���滻��
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
     * ��������
     * @param a
     * @return
     */
    public static int[] quick(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) { // �����������жϵݹ���޷��˳����¶�ջ����쳣
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }
    public static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];// ��׼Ԫ��
        while (low < high) {
            // �ҵ��Ȼ�׼Ԫ��С��Ԫ��λ��
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
     * �鲢����
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
            // ����߽��еݹ�
            mergeSort(a, left, middle);
            // ���ұ߽��еݹ�
            mergeSort(a, middle + 1, right);
            // �ϲ�
            merge(a, left, middle, right);
        }
    }

    public static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[a.length];
        int mid = middle + 1; // �ұߵ���ʼλ��
        int tmp = left;
        int third = left;
        while (left <= middle && mid <= right) {
            // ������������ѡȡ��С���������м�����
            if (a[left] <= a[mid]) {
                tmpArr[third++] = a[left++];
            } else {
                tmpArr[third++] = a[mid++];
            }
        }
        // ��ʣ��Ĳ��ַ����м�����
        while (left <= middle) {
            tmpArr[third++] = a[left++];
        }
        while (mid <= right) {
            tmpArr[third++] = a[mid++];
        }
        // ���м����鸴�ƻ�ԭ����
        while (tmp <= right) {
            a[tmp] = tmpArr[tmp++];
        }
    }
    
    /**
     * ��������
     * �����д��Ƚ���ֵ����������ͳһΪͬ������λ���ȣ���λ�϶̵���ǰ�油�㡣
     * Ȼ�󣬴����λ��ʼ�����ν���һ���������������λ����һֱ�����λ��������Ժ�,���оͱ��һ���������С�
     * **/
    
    public static int[] jiShuSort(int[] array) {
        //�ҵ��������ȷ��Ҫ������
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(max<array[i]){
                max = array[i];
            }
        }
        //�ж�λ��
        int times = 0;
        while(max>0){
            max = max/10;
            times++;
        }
        //����ʮ������
        ArrayList<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList queue1 = new ArrayList();
            queue.add(queue1);
        }
        //����times�η�����ռ�
        for (int i = 0; i < times; i++) {
            //����
            for (int j = 0; j < array.length; j++) {
                int x = array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
                ArrayList queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x,queue2);
            }
            //�ռ�
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
        //�������
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String inStr = in.nextLine();
            String[] str = inStr.split(" ");
            int a[] = new int[str.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            
            //��ý��
            //int[] results = zhiJieChaRu(a);
            int[] results = null;
            
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < results.length; i++) {
                result.append(results[i]).append(",");
            }
            //ɾ�����һ������
            if (result.length() > 0) {
                result.deleteCharAt(result.length() -1);
            }
            System.out.println(result);
            
        }
    }
}
