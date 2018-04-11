package Practice.NiuKeOJ;

import java.util.ArrayList;

/**
 * FindNumbersWithSum
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * ��ָoffer
 * ��Ŀ����
����һ����������������һ������S���������в������������ǵ����ǵĺ�������S��
����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
�������:
��Ӧÿ�����԰����������������С���������
 */
public class FindNumbersWithSum {



    //�Լ���˼·�����е���������������˵�˼·����ͦ�ɵ�
    public ArrayList<Integer> FindNumbersWithSum_solve1(int [] array,int sum) {
        int mult = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        int a=0, b = 0;

        int nLen = array.length;
        int i = nLen-1;

        if(array==null || nLen==0)
            return result;

        while(array[i]>sum && i>=0)
            i--;
        if(i==0)
            return result;

        for(int j = 0; j<=i; j++){
            for(int k = j+1;k<=i; k++ ){
                if(array[j]+array[k]==sum){
                    if(array[j]*array[k]<mult){
                        a = Math.min(array[j],array[k]);
                        b = Math.max(array[j],array[k]);

                        mult = a*b;
                    }
                }
            }
        }
        if(a==0&&b==0)
            return result;
        result.add(a);
        result.add(b);
        return result;
    }


    /*
    *
    * �������������������ͷβ����ָ��i��j��
    * ��ai + aj == sum�����Ǵ𰸣����ԽԶ�˻�ԽС��
    * ��ai + aj > sum��aj�϶����Ǵ�֮һ��ǰ���ѵó� i ǰ��������ǲ����ܣ���j -= 1
    * ��ai + aj < sum��ai�϶����Ǵ�֮һ��ǰ���ѵó� j ����������ǲ����ܣ���i += 1
    * O(n)
    * */

    public ArrayList<Integer> FindNumbersWithSum_solve2(int [] array,int sum) {

        ArrayList<Integer> result = new ArrayList<>();

        int nLen = array.length;
        int i = 0,j=nLen-1;

        while(i<j){
            if(array[i]+array[j]==sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
            while(array[i]+array[j]<sum)
                i++;
            while(array[i]+array[j]>sum)
                j--;
        }

        return result;
    }

}