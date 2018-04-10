package Practice.NiuKeOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * MinConcatNum
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * ��ָoffer
 *
 * ��Ŀ����
����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��

 �ص������Զ���һ�����򷽷���ȷ����������ЩӦ����ǰ��ЩӦ���ں������������ֱ��concat�ͺ�

  ����������£�
?* ��ab > ba �� a > b��
?* ��ab < ba �� a < b��
?* ��ab = ba �� a = b��
?* ����˵����
    ���� "3" < "31" ���� "331" > "313"������Ҫ������ƴ���������бȽ�
 */
public class MinConcatNum {

    public static void main(String[] args){

        int[] array = {3,32,321};

        String result = PrintMinNumber(array);

        System.out.println(result);
    }

    public static String PrintMinNumber(int [] numbers) {
        String s = "";

        ArrayList<String> list = new ArrayList<>();

        if(numbers==null && numbers.length==0)
            return s;

        for(int i = 0; i<numbers.length; i++)
            list.add(Integer.toString(numbers[i]));


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String str1 = o1 + o2;
                String str2 = o2 + o1;

                return str1.compareTo(str2);
            }
        });

        for(int i=0; i<list.size(); i++){
            s += list.get(i);
        }
        return s;
    }

}
