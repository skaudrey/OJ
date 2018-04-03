package Practice.DP;

/**
 * GetStudent
 *
 * @author Mia Feng
 * @date 2018/3/22
 *
 * ???????
?? n ????????????????????????????????????? n ??????��???????? k ???????????????????????��??????
?????? d??????? k ??????????????????????????????????
????????:
?????????? 1 ???????????????????????????��?????????? n (1 <= n <= 50)?????????????????????????��?
???? n ???????????????????????????? ai??-50 <= ai <= 50??????????????��?????????????
k ?? d (1 <= k <= 10, 1 <= d <= 50)??
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class GetStudent {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        String[] inputStr = new String[3];
//        int i = 0;
//        int std_size = 0;
//        int[] cap = null;
//        int k = 0; int d = 0;
        while(sc.hasNext()){
//            inputStr[i++] = sc.nextLine();
           int std_size = sc.nextInt();
            int[] cap = new int[std_size+1];

            for (int i=1; i<=std_size;i++){
                cap[i] = sc.nextInt();
            }
           int  kk = sc.nextInt();
            int dd = sc.nextInt();
            long[][] fn = new long[std_size+1][kk+1];   //maximum for positive capability
            long[][] gn = new long[std_size+1][kk+1];   //minimum for negative capability


            //��ʼ�����һ���˵�std_size�п�����ѡ�񣬲��Żس���
            for(int one=1; one<=std_size; one++){
                fn[one][1] = cap[one];
                gn[one][1] = cap[one];
            }

            //�����һ���˿�ʼ�������
            for(int k=2; k<kk;k++){
                for(int one = k; one <= std_size; one++){   //˳��ѡȡ
                    //ÿȷ��һ���˿�����std_size��ѡ���Ժ�����һ���˵�����ֵһ����ȵ�ǰ����˵�����ֵС

                    // get the maximum division point when k and one is determined
                    long tempmax = Long.MIN_VALUE;
                    long tempmin = Long.MAX_VALUE;

                    for(int left = Math.max(k-1,one-dd); left<one-1;left++ ){
                        if(tempmax < Math.max(fn[left][k-1]*cap[one],gn[left][k-1]*cap[one]))
                            tempmax = Math.max(fn[left][k-1]*cap[one],gn[left][k-1]*cap[one]);
                        if(tempmin > Math.min(fn[left][k-1]*cap[one], gn[left][k-1]*cap[one]))
                            tempmin = Math.min(fn[left][k-1]*cap[one], gn[left][k-1]*cap[one]);
                    }

                    fn[one][k] = tempmax;
                    gn[one][k] = tempmin;
                }
            }
            long result = Long.MIN_VALUE;
            //�����һ��������ѡһ�����ֵ�ͺ���
            for(int one = kk; one<=std_size; one++){
                if(result< fn[one][kk]){
                    result = fn[one][kk];
                }
            }
            System.out.println(result);
        }
    }

    public static int[] quick(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) { // ???????????��?????????????????????
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }
    public static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];// ??????
        while (low < high) {
            // ??????????��?????��??
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
}
