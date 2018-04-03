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

        //这里蠢了，明明可以先把串中重复的元素去掉再计算是否有满足元素之差等于interval的
        //然后将近浪费了半个多小时在怎么保存不重复的元素上。。真是蠢啊。
        //学会用Set啊，以及Set 转 arrays

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
