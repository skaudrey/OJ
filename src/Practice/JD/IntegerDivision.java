package Practice.JD;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * IntegerDivision
 *
 * @author: Mia Feng
 * @date: 2018/4/9
 *
 *
 */
public class IntegerDivision {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        int nCase = sc.nextInt();

        long[] cases = new long[nCase];

        for(int i = 0; i<nCase; i++)
            cases[i] = sc.nextLong();

        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i<nCase; i++){
            long tmp = cases[i];

            long[] tmpPair = null;

            if(tmp%2!=0){
                result.add("No");
                continue;
            }

            //拿到最小
            for(long j = 2; j<=tmp; j+=2){
                if(tmp%j==0 && tmp/j%2!=0){
                    tmpPair = new long[2];
                    tmpPair[0] = tmp/j; //奇数
                    tmpPair[1] = j; //偶数
                    String tmpStr = tmpPair[0]+" "+tmpPair[1];
                    result.add(tmpStr);
                    break;
                }
            }
        }

        for (int i = 0; i<nCase; i++){
            System.out.println(result.get(i));
        }
    }

}
