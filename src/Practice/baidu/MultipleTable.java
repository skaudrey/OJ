package Practice.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MultipleTable
 *
 * @author: Mia Feng
 * @date: 2018/4/18
 *
 * �ȶ��ܺ�үү����һ���˷�����Ϸ���˷���ĵ�i�е�j��λ�õ�Ԫ��Ϊi*j�����ҳ˷����±��Ŵ�1��ʼ������2?��?3�˷���Ϊ

1 2 3
2 4 6

үүʮ�ִ���������n*m�ĳ˷���ֻҪ�ȶ��ܸ���һ����k��үү�������̸��߶ȶ��ܳ˷�����Ԫ�ذ��ղ���˳������֮��
��k��Ԫ���Ƕ��١������ظ������Ϸ��

 �������ڴ������
  ��ʵ�����ö��ֲ���

/**
 * ��ȡ����num�ڳ˷���n*m�е����һ��λ�ã��п��ܴ��ڶ��num��������
 *  1   2   3   4   5
 *  2   4   6   8   10
 *  3   6   9   12  15
 * �˷�������Ϊ�� 1 2 2 3 3 4 4 5 6 6 8 9 10 12 15
 * 6�ڳ˷����λ��Ϊ��10
 *          ���㷽����min(6/1,5)+min(6/2,5)+min(6/3,5) = 10
 *          ��⣺��һ�б�6С����ȵ���6/1��������6Խ����m=5����ֻ��5�����ڶ�����6/2��������������6/3��</br>
 * ͬ��5��λ��Ϊ�� 8
 * ͬ��7��λ��Ϊ��10����7�����ڳ˷����У��Ⲣ������,���ռ���������
 */

public class MultipleTable {

    public static long m;
    public static long n;
    public static long k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        m = sc.nextLong();
        k = sc.nextLong();

        System.out.print(solve2(1,m*n,k));

    }

    //exceed the memory limitation
    public static int solve1(int n, int m ,int k){
        int[] table = new int[n * m];

        int nInd = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                table[nInd++] = i * j;
            }
        }

        Arrays.sort(table);

        System.out.println(table[k - 1]);

        return table[k-1];
    }


    public static long solve2(long left, long right, long k){
        long mid;
        while(left<=right){
            mid = (left+right)/2;

            if(cal(mid)<k)  //˳�򲻿��Է������ڵ����һ��Ҫ��mid-1����
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    public static long cal(long k){
        long sum = 0;

        for(int i = 1; i<=n; i++)   // <= n
            sum += Math.min(k/i,m);

        return sum;
    }
}
