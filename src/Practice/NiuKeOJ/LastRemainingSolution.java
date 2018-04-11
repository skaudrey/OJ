package Practice.NiuKeOJ;

import java.util.LinkedList;

/**
 * LastRemainingSolution
 *
 * @author: Mia Feng
 * @date: 2018/4/11
 *
 * ��ָoffer
 *
 * ��Ŀ����
ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��
Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,
��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,
�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��

������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)

 �������ѧ���⣺Լɪ��

Լɪ�򻷣�Լɪ����һ����ѧ��Ӧ�����⣺
��֪n���ˣ��Ա��1��2��3...n�ֱ��ʾ��Χ����һ��Բ����Χ���ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳��У�
������һ�����ִ�1��ʼ����������m���Ǹ����ֳ��У����˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�

 ���ɵ�˼·����
 x[k+1] = (x[k]+m)%n;

 ��ʵҲ����ģ����Ϸ���̣���LinkList��ά������

 */
public class LastRemainingSolution {

    public int LastRemaining_solve1(int n,int m){

        if(n<1 || m<1)
            return -1;
        if(n==1)
            return 0;
        return (LastRemaining_solve1(n-1,m)+m)%n;

    }


    public int LastRemaining_solve2(int n,int m){

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i<n; i++)
            list.add(i);

        int bt = 0;

        while (list.size()>1){
            bt = (bt+m-1)%list.size();
            list.remove(bt);
        }

        return list.size()==1?list.get(0):-1;

    }
}
