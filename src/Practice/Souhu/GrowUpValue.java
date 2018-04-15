package Practice.Souhu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * GrowUpValue
 *
 * @author: Mia Feng
 * @date: 2018/4/14
 *
 *
 */
public class GrowUpValue {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nOps = sc.nextInt();

        Vector<Integer> ops1Value = new Vector<Integer>(1000);
        Vector<Integer> ops2Value = new Vector<Integer>(1000);

        for(int i = 0; i<1000; i++)
        {
            ops1Value.set(i,Integer.MIN_VALUE);
            ops2Value.set(i,Integer.MIN_VALUE);
        }

        for(int i = 0; i<nOps; i++){
            if(sc.nextInt()==1){


                int nStart = sc.nextInt();
                int nEnd  = sc.nextInt();
                int nValue = sc.nextInt();

                for(int j = nStart-1; j<nEnd; j++){
                    Integer tempValue = ops1Value.get(j);
                    if(tempValue==Integer.MIN_VALUE)
                        ops1Value.add(j, nValue);
                    else
                        ops1Value.add(j, Math.max(nValue,tempValue));
                }
            }
            else{
                int nInd = sc.nextInt();
                int nValue = sc.nextInt();

                Integer tempValue = ops2Value.get(nInd-1);
                if(tempValue==Integer.MIN_VALUE)
                    ops1Value.add(nInd-1, nValue);
                else
                    ops1Value.add(nInd-1, Math.max(nValue,tempValue));
            }
        }
        int nD = Math.min(ops1Value.size(),ops2Value.size());
        int nSum = 0;
        int i = 0;
        for(; i<nD; i++){
            int v1 = ops1Value.get(i)==Integer.MIN_VALUE?0:ops1Value.get(i);
            int v2 = ops2Value.get(i)==Integer.MIN_VALUE?0:ops2Value.get(i);
            nSum += v1+v2;
        }

        while (i<ops1Value.size()){
            nSum += ops1Value.get(i)==Integer.MIN_VALUE?0:ops1Value.get(i);
        }


        while (i<ops2Value.size()){
            nSum += ops2Value.get(i)==Integer.MIN_VALUE?0:ops2Value.get(i);
        }

        System.out.println(nSum);
    }
}
