package Practice.NiuKeOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * PermutationString
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 * ��ָoffer
 *
 * �ַ���ȫ����
 *
 * ���ݷ����ݹ���ɣ��ݹ����Ϊ�ַ�������Ϊ1ʱ
 *
 * �������������ע��㣺
 * 1.   �ݹ����
 * 2.   �ݹ鴫��ȥ��ʲô�ݹ������Ҫ��֤����ȥ�Ĳ���
 *
 * ��Ŀ��
����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
��������:
����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��

ע�⣺�ֵ���Ļ���Ҫ������Ľ��������

 ȥ��ȫ��˼·��
 �ӵ�һ���ַ���ÿ���ַ��ֱ�����������ظ����ֵ��ַ�����
 */
public class PermutationString {

    public static void main(String[] args){
        String str = "abb";

        ArrayList<String> result = Permutation(str);

        for(int i = 0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();

        if(str!=null && str.length()>0){
            permutationHelper(list,str.toCharArray(),0);
            Collections.sort(list); //���ֵ���
        }
            return list;
        }

        public static void permutationHelper(ArrayList<String> list, char[] array, int nBegin){    //��begin��ʼȫ����

            if(nBegin == array.length-1)    //�ݹ����
                list.add(String.valueOf(array));
            else{
                //���else���������1��������һ��λ�õ��ַ��������һ��λ�õ�ȫ�����ַ���ȫ����ӡ��

                //�Ͱѵ�һ���ַ��͵ڶ���������2���ݹ��ӡÿ�ε�һ���ַ�����ȫ�����ַ�����3��ÿ��

//�ݹ��ʱ�򶼻ᴫ��һ���ַ������飬������д�����ǿ�������ַ������鲻�䣬��˼����

//ʲô���Ӵ��ݳ�ȥ����ʲô���Ӵ��ݻ�����һ�㲻�ܱ仯����Ϊ������д��벻�����ڸı�

//�ַ��������
                Set<Character> set = new HashSet<>();

                for(int j = nBegin; j<array.length; j++){
                    if(j==nBegin || !set.contains(array[j])){   //��set���жϺ����Ƿ����ظ��ַ�
                        set.add(array[j]);
                        swap(array, nBegin, j);   //����ʼ���ַ�����治�ظ����ַ�����
                        permutationHelper(list,array,nBegin+1);
                        swap(array,nBegin,j);   //Ϊ��ֹ�ظ������������Ҫ��begin����Ԫ�����»���ȥ
                    }
                }
            }
        }

        public static void swap(char[] array,int i, int j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

        }


}
