package Practice.TouTiao;

import java.util.*;

/**
 * IntervalUnique
 *
 * @author Mia Feng
 * @date 2018/3/24
 *
 *
 *
 */

public class IntervalUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nNum = sc.nextInt();
        int nInterval = sc.nextInt();

        //������ˣ����������ȰѴ����ظ���Ԫ��ȥ���ټ����Ƿ�������Ԫ��֮�����interval��
        //Ȼ�󽫽��˷��˰����Сʱ����ô���治�ظ���Ԫ���ϡ������Ǵ�����
        //ѧ����Set�����Լ�Set ת arrays

        Set numSet = new HashSet<Integer>();

        for (int i = 0; i < nNum; i++) {
            numSet.add(sc.nextInt());
        }
        Object[] numArray = numSet.toArray();
        int nPairs = 0;
        for(int i=0; i<numArray.length; i++){
            for(int j=i; j< numArray.length; j++){
                if(Math.abs(new Integer(numArray[i].toString())-new Integer(numArray[j].toString()))==nInterval)
                    nPairs++;
            }
        }
        System.out.println(nPairs);
    }

}
